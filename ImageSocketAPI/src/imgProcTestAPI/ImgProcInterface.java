package imgProcTestAPI;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import imgProcAPI.ImgProcClient;

/*
 * Interface for the ImgProc API
 */

public class ImgProcInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating a Client Variable
		ImgProcClient ipc;
		try {
			//Check for existence of IP/name of the server and image file to be uploaded
			if(args.length<2){
				System.out.println("Error: Arguments not properly defined!\nPlease enter the server name/IP followed by valid image file address as arguments!");
				return;
			}
			// Passing the server to connect and image file to process
			ipc = new ImgProcClient(args[0], 2500, new File(args[1]));
			//Reading request from System.in
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s;
			while((s=br.readLine()) != null){
				//Parsing the requests file
				s=s.trim();
				String[] ins = s.split(" ");
				ins[0]=ins[0].trim();
				//Processing the PERFORM request
				if(ins[0].equals("PERFORM")){
					try {
						ipc.perform(ins[1]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				//Processing the REPLACE request
				else if(ins[0].equals("REPLACE")){
					try {
						File f = new File(ins[1]);
						ipc.replace(f);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
				//Processing the RECEIVE request
				else if(ins[0].equals("RECEIVE")){
					ipc.saveProcImageAs(ins[1]);
				}
				//Processing the CLOSE request
				else if(ins[0].equals("CLOSE")){
					break;
				}
				else{
					System.out.println("Not a Valid Request!!");
				}
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
