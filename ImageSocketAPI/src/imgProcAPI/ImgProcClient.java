package imgProcAPI;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;

/*
 * ImgProcClient creates a socket to communicate with 
 * the ImgProcServer for performing
 * Image Processing Operations on loaded image
 */
public class ImgProcClient {

	// Byte Codes for various Image Processing Operations
	public static final byte GaussianBlur = 0;
	public static final byte InvertColor = 1;
	public static final byte ScaleUp = 2;
	public static final byte ScaleDown = 3;
	public static final byte Brighten = 4;
	public static final byte Darken = 5;
	public static final byte Sharpen = 6;

	// Declaring instance variables
	Socket client;
	File imgFile;
	BufferedImage image;
	DataInputStream dis;
	DataOutputStream dos;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	String message;

	// Flags for successful operation and file upload respectively
	boolean success, file;

	public boolean isSuccessful() {
		return success;
	}

	// Constructor for ImgProcClient to connect to 'server' and upload image
	// 'file'
	public ImgProcClient(String server,int port, File f) throws Throwable {
		System.out.println("Connecting to Image Processing Server....");
		try {
			// Connecting to server at given port number
			client = new Socket(server, port);
			System.out.println("Successfully connected to the Server!");
			// Declaring various input and output streams
			OutputStream os = client.getOutputStream();
			InputStream is = client.getInputStream();
			oos = new ObjectOutputStream(os);
			ois = new ObjectInputStream(is);
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			// catching errors
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot Connect to the Server!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot Connect to the Server!");
			e.printStackTrace();
		}
		// Setting image for processing
		setImageAsFile(f);
		// System.out.println("hello");
	}

	// Function to upload Image file to the server for further processing
	private void setImageAsFile(File imgFile) throws Throwable {
		//Checking for the validity of the file
		if (!imgFile.exists()) {
			System.out.println("File does not exist! Enter a valid FileName");
			file = false;
		}
		if (!imgFile.canRead()) {
			System.out.println("File is not readable!");
			file = false;
		}
		try {
			//Reading image from the File object
			image = ImageIO.read(imgFile);
			//Writing the image to the output stream
			oos.writeObject(imgFile);
			//Flushing the contents
			oos.flush();
			//Reading the feedback message
			message = dis.readUTF();
			System.out.println(message);
			if (message.contains("Success")) {
				file = true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Checking for successful file upload
		if (!file) {
			throw new Exception("Error: File not uploaded!");
		}
		System.out.println("");

	}

	//Function to perform Image Processing Operation on the image
	public void perform(Byte o) {
		try {
			//Sending request string to the server
			dos.writeUTF("PERFORM");
			dos.flush();
			//Reading the feedback message
			message = dis.readUTF();
			System.out.println(message);
			//Sending operation byte code
			dos.writeByte(o);
			dos.flush();
			//Reading feedback messages and displaying them on the fly
			while ((message = dis.readUTF()).contains("Complete") == false) {
				System.out.println(message);
				if (message.contains("Success")) {
					success = true;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	//Function taking operation as string type, detecting the byte code and performing the operation
	public void perform(String o){
		byte op = -1;
		//Matching to string to the bytecode
		switch(o){
		
		case "GAUSSIAN_BLUR":op=0;break;
		case "INVERT_COLOR":op=1;break;
		case "SCALE_UP":op=2;break;
		case "SCALE_DOWN":op=3;break;
		case "BRIGHTEN":op=4;break;
		case "DARKEN":op=5;break;
		case "SHARPEN":op=6;break;
		default:System.out.println("Not a valid operation!");break;
		}
		//Performing the operation
		if(op>=0){
			System.out.println("Operation to be performed: "+o);
			perform(op);
		}
	}

	//Function to replace existing image with a new one
	public void replace(File f) throws Throwable {
		try {
			//Sending request string to the server
			dos.writeUTF("REPLACE");
			dos.flush();
			//Reading the feedback message
			message = dis.readUTF();
			System.out.println(message);
			// Setting image for processing
			setImageAsFile(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
	}

	//Function to receive and save processed image 
	public void saveProcImageAs(String string) throws Throwable {
		// TODO Auto-generated method stub
		try {
			//Sending request string to the server
			dos.writeUTF("RECEIVE");
			dos.flush();
			//Reading the feedback message
			message = dis.readUTF();
			if (message.contains("not")) {
				throw new Exception(message);
			}
			System.out.println(message);
			//Receiving the image as byte array
			byte[] imageInBytes = (byte[]) ois.readObject();
			//Saving the byte array as File
			File f = new File(string);
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(imageInBytes);
			fos.close();
			System.out.println("Image successfully saved!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
	}
	
	//Function to close the connection
	public void close() {
		try {
			//Sending request string to the server
			dos.writeUTF("CLOSE");
			dos.flush();
			//Reading the feedback message
			System.out.println(dis.readUTF());
			System.out.println("Connection Closed!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
	}

}
