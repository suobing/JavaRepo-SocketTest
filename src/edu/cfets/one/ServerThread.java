package edu.cfets.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket socket = null;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream is = null;
		InputStreamReader isr=null;
		BufferedReader br= null;
		OutputStream os= null;
		PrintWriter pw= null;
		try {
			is= socket.getInputStream();//无论S还是C，获得输入流都是socket
			isr= new InputStreamReader(is);
			br= new BufferedReader(isr);
			String info =null;
			while((info=br.readLine())!=null){
				System.out.println("This is Sever, Client says: "+info);
			}
			
			System.out.println("Receive MSG over>>>>>>>>>>>>>>>>>>>>>>");
			socket.shutdownInput();//关闭输入流
			
			//4.获取输出流，响应客户端需求
			os = socket.getOutputStream();//无论S还是C，获得输出流都是socket
			pw = new PrintWriter(os);//包装为打印流
			pw.write("欢迎您！");
			pw.flush();
			

		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//5.关闭资源
			try {
				pw.close();
				os.close();
				br.close();
				isr.close();
				is.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	
}
