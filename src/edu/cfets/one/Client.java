package edu.cfets.one;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 */
public class Client {
	public static void main(String[] args) {
		//1.创建Socket，指定服务器地址 端口
		try {
			Socket socket = new Socket("localhost",8888);
			//2.获取输出流,向服务器端发送信息
			OutputStream os= socket.getOutputStream();//字节输出流
			PrintWriter pw=new PrintWriter(os);
			pw.write("用户名：admin;密码：123");
			System.out.println("Cilent will send msg");
			pw.flush();//刷新缓存，发送
			socket.shutdownOutput();
			
			//3.关闭资源
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
