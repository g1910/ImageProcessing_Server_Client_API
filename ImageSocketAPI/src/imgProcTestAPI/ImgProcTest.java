package imgProcTestAPI;

import java.io.File;

import imgProcAPI.ImgProcClient;

/*
 * Test Class for testing the ImgProc API
 */

public class ImgProcTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating a Client Variable
		ImgProcClient ipc;
		try {
			// Passing the server to connect and image file to process
			ipc = new ImgProcClient("localhost", 2500,new File(
					"C:\\Users\\Gaurav\\Desktop\\glass.jpg"));
			// Performing Sharpening of the image
			ipc.perform(ImgProcClient.Sharpen);
			// Performing Scaling Up of the image
			ipc.perform(ImgProcClient.ScaleUp);
			// Saving the processed file
			ipc.saveProcImageAs("C:\\Users\\Gaurav\\Desktop\\proc.jpg");
			// Replacing with a new file for a fresh set of operations without
			// creating a new client
			ipc.replace(new File("C:\\Users\\Gaurav\\Desktop\\glass.jpg"));
			//Performing Color Inversion on the image
			ipc.perform(ImgProcClient.InvertColor);
			//Saving the processed file
			ipc.saveProcImageAs("C:\\Users\\Gaurav\\Desktop\\proc1.jpg");
			//Closing the connection
			ipc.close();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
