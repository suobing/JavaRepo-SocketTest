package edu.cfets.one.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
/*
 * 服务端,实现基于UDP的用户登录
 */
	public static void main(String[] args) throws IOException {
		//1.创建服务器端DatagramSocket,指定端口
		DatagramSocket socket=new DatagramSocket(8800);
		//2.创建数据报,用于接收客户端发送的数据
		byte[] data = new byte[1024];
		DatagramPacket packet=new DatagramPacket(data,data.length);
		//3.接收客户端发送的数据
		System.out.println("Server already setup... stand by...");
		socket.receive(packet);//此方法在接收到数据报之前会一直阻塞
		//4.读取数据(已被保存在字符数组里)
		String info=new String(data,0,packet.getLength());
		System.out.println("I am Server, Client says:"+ info);
		
		/*
		 * 响应客户端(类似客户端向服务器发送数据)
		 */
		//1.定义客户端地址，端口，数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2="欢迎您！".getBytes();
		//2.创建数据报，包含响应的数据信息
		DatagramPacket packet2= new DatagramPacket(data2,data2.length,address,port);
		//3.响应客户端
		socket.send(packet2);
		//4.关闭资源
		socket.close();
	}

}
