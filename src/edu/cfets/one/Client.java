package edu.cfets.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
			OutputStream os= socket.getOutputStream();//字节输出流  //无论S还是C，获得输出流都是socket
			PrintWriter pw=new PrintWriter(os);
			pw.write("用户名：锁;密码：123");
			System.out.println("Cilent will send msg");
			pw.flush();//刷新缓存，发送
			socket.shutdownOutput();
			
			//3.获取输入流，读取服务端的响应信息
			InputStream is = socket.getInputStream();//无论S还是C，获得输入流都是socket
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info =null;
			while((info=br.readLine())!=null){
				System.out.println("This is Client, Server says: "+info);
			}
			//4.关闭资源
			br.close();
			is.close();
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
