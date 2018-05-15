package com.yougal.sockets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class Client implements Runnable{

	AtomicInteger atomicInteger = new AtomicInteger(1);
	
	public Client() {
	}
	
	@Override
	public void run() {
		DataOutputStream out   = null;
		DataInputStream in = null;
		Socket clientSocket=null;
		try {
			clientSocket= new Socket(InetAddress.getLocalHost(),1234);
			System.out.println("Client- " +Thread.currentThread().getName()+ " Connecting to Address: " + clientSocket.getInetAddress());
			System.out.println("Client- " +Thread.currentThread().getName()+ " Connecting to Port: " + clientSocket.getPort());
			out   = new DataOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
			in = new DataInputStream(new BufferedInputStream (clientSocket.getInputStream()));
			while(true) {
				int number = atomicInteger.incrementAndGet();
				out.writeInt(number);
				out.flush();
				int result = in.readInt();
				System.out.println("Client- "+Thread.currentThread().getName() + " Number Input: " +number + " Result from Server: " + result);
				if(result!=2*number) {
					throw new Exception("Corrupt Value");
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				clientSocket.close();
				in.close();
				out.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	
}
