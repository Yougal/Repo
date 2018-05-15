package com.yougal.sockets;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server{

	ServerSocket serverSocket;

	ExecutorService executorService;
	
	public Server() {
		try {
			this.serverSocket= new ServerSocket(1234);
			this.executorService = Executors.newFixedThreadPool(10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int start() throws IOException{
		while(true) {
			Socket accept = serverSocket.accept();
			ServerThread serverThread = new ServerThread(accept);
			executorService.submit(serverThread);
		}
	}
	
	public static class ServerThread implements Runnable{
		private Socket acceptedSocket=null;
		ServerThread(Socket acceptedSocket){
			this.acceptedSocket = acceptedSocket;
		}
		@Override
		public void run() {
			DataOutputStream out   = null;
			DataInputStream in = null;
				try {
					System.out.println("Server- " + Thread.currentThread().getName() +" Socket Address: " + acceptedSocket.getInetAddress());
					System.out.println("Server- " + Thread.currentThread().getName() +" Socket Port: " + acceptedSocket.getPort());
					while(true) {
						out   = new DataOutputStream( new DataOutputStream( acceptedSocket.getOutputStream()));
						in = new DataInputStream(new BufferedInputStream (acceptedSocket.getInputStream()));
						int number = Integer.valueOf(in.readInt());
						out.writeInt(number*2);
						out.flush();
						Thread.sleep(2000);
					}
					
				} catch (Exception e) {
					throw new RuntimeException(e);
				}finally {
					try {
						out.close();
						in.close();
						acceptedSocket.close();
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			
		}
	}
	
}
