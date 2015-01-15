package server;

import imgProcServerAPI.ImgProcServer;

/*
 * Main class to start various servers
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating and Starting the ImgProcServer
		ImgProcServer ips;
		try {
			if(args.length<1){
				System.out
				.println("Error: Arguments not properly defined!\nPlease enter a port number as arguments!");
		return;
			}
			ips = new ImgProcServer(Integer.parseInt(args[0]));
			ips.start();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
