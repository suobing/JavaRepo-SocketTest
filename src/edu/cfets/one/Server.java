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
			ServerSocket serverSocket = new ServerSocket(8888);
			//2.调用accept方法开始监听，等待Client的连接
			System.out.println("Server will start...await client connection>>>>>>>>>>>>>>>>>>>>>>");
			Socket socket=serverSocket.accept();
			
			InputStream is= socket.getInputStream();
			InputStreamReader isr= new InputStreamReader(is);
			BufferedReader br= new BufferedReader(isr);
			String info =null;
			while((info=br.readLine())!=null){
				System.out.println("This is Sever, Client says: "+info);
			}
			
			System.out.println("Receive MSG over>>>>>>>>>>>>>>>>>>>>>>");
			socket.shutdownInput();//关闭输入流
			
			//4.获取输出流，响应客户端需求
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);//包装为打印流
			pw.write("欢迎您！");
			pw.flush();
			
			//5.关闭资源
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
