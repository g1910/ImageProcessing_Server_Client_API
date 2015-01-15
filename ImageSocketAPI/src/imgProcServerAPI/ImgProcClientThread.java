package imgProcServerAPI;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
/*
 * This class provides the functionality to serve every client
 * as an individual thread on the server side
 */
public class ImgProcClientThread extends Thread {

	//Declaring instance variables
	BufferedImage image;
	DataInputStream dis;
	DataOutputStream dos;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	ImgProcProtocol ipp;
	String message, service;
	
	//Declaring the socket to be served
	Socket client = null;
	
	boolean success;

	//Keeping a count of the number of threads
	static int count;

	//Constructing the class with accepted socket
	public ImgProcClientThread(Socket socket) {
		super("Client " + ++count);
		client = socket;
	}

	
	//Defining the functionality to be performed by the thread
	public void run() {
		try {
			//Defining the various input and output streams
			System.out.println("Connected to " + client.toString());
			OutputStream os = client.getOutputStream();
			InputStream is = client.getInputStream();
			oos = new ObjectOutputStream(os);
			ois = new ObjectInputStream(is);
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			//Accepting the image to be processed
			acceptImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot connect to the Client");
			e.printStackTrace();
		}
		
		//Performing the various requests by the client
		while (true) {
			try {
				service = dis.readUTF();
				message = "ImgProc Request: " + service;
				// Closing the connection
				if (service.equals("CLOSE")) {
					dos.writeUTF(message + "\nClosing Connection...");
					dos.flush();
					break;
				}
				// Performing an operation
				else if (service.equals("PERFORM")) {
					// System.out.println("hello");
					dos.writeUTF(message + "\nAccepting Operation...");
					dos.flush();
					//Calling performOp to operate on the image
					performOp();
				}
				// Sending the processed image
				else if (service.equals("RECEIVE")) {
					//Checking for the existance of the processed image
					if (ipp.getProcImage() == null) {
						dos.writeUTF(message
								+ "\nProcessed Image does not exist!");
						dos.flush();
					} else {
						dos.writeUTF(message + "\nSending Processed Image...");
						dos.flush();
						//Calling function to send the processed image
						sendProcImage();
					}
				}
				//Replacing the existing image with a new one
				else if (service.equals("REPLACE")) {
					dos.writeUTF(message + "\nReplacing image...");
					dos.flush();
					acceptImage();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Connection with client "+client.toString()+" closed unexpectedly!");
				try {
					client.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			}
		}
	}

	//Function to operate on the image
	private void performOp() {
		// TODO Auto-generated method stub
		try {
			//Accepting the byte code for the Image Processing operation
			byte x = dis.readByte();
			dos.writeUTF("Operation Accepted!");
			dos.flush();
			//Calling the protocol function to operate on the image
			message = ipp.operate(x);
			//Setting the boolean success variable
			if (message.contains("Success")) {
				success = true;
				// System.out.println("hello success");
			}
			dos.writeUTF(message);
			dos.flush();
			//Catching various exceptions
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			try {
				dos.writeUTF("Error: ClassNotFoundException");
				dos.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				dos.writeUTF("Error: IOException");
				dos.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			try {
				dos.writeUTF(e.getMessage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			//Sending the final feedback message for processing
			dos.writeUTF("Operation Complete!");
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Function to send the processed image
	private void sendProcImage() {
		// TODO Auto-generated method stub
		//Converting the processed image to byte array
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image = ipp.getProcImage();
		try {
			ImageIO.write(image, "jpg", baos);
			baos.flush();
			byte[] imageInBytes = baos.toByteArray();
			//Sending the byte array to the client
			oos.writeObject(imageInBytes);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Function to accept image for processing
	private void acceptImage() {
		// TODO Auto-generated method stub
		try {
			//Reading image from accepted file
			File f = (File) ois.readObject();
			image = ImageIO.read(f);
			//Creating ImgProcProtocol for operating on the image
			ipp = new ImgProcProtocol(image);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			message = "Error: Cannot read the Image.CNF";
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			message = "Error: Cannot read the Image.IO";
			e.printStackTrace();
		}
		message = "Success: Image read successfully.";
		try {
			//Sending the feedback image
			dos.writeUTF(message);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
