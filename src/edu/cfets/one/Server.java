package edu.cfets.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 */
public class Server {
	public static void main(String[] args) {
		//1.创建服务器端socket，即ServerSocket，指定绑定的端口，并监听此端口
		try {
			int count=0;
			ServerSocket serverSocket = new ServerSocket(8888);
			//2.调用accept方法开始监听，等待Client的连接
			System.out.println("Server will start...await client connection>>>>>>>>>>>>>>>>>>>>>>");
			Socket socket = null;
			while(true){
				socket=serverSocket.accept();
				count++;
				System.out.println("Client 数量："+count);
				ServerThread socketThread = new ServerThread(socket);
				socketThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
