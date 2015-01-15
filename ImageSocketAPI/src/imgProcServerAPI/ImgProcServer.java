package imgProcServerAPI;

import java.io.IOException;
import java.net.ServerSocket;


/*
 * ImgProcServer creates a serversocket to
 * cater to various Image Processing request 
 * made by the clients
 */
public class ImgProcServer {

	/**
	 * @param args
	 */
	//Declaring the ServerSocket
	ServerSocket server;
	
	//Constructing the server
	public ImgProcServer(int i) throws Throwable{
		// TODO Auto-generated constructor stub
			server = new ServerSocket(i);
			System.out.println("Image Processing Server started at port "+i);
	}

	//Starting the server to accept client as separate threads
	public void start() {
		// TODO Auto-generated method stub
			while(true){
				try {
					//Creating a new thread for each accepted client
					new ImgProcClientThread(server.accept()).start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	
}
