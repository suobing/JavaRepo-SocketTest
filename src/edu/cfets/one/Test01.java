package edu.cfets.one;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;


public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress address = InetAddress.getLocalHost();
		
		System.out.println("计算机名: "+address.getHostName());//DESKTOP-V05FLJV
		System.out.println("IP: "+address.getHostAddress());//192.168.215.108
		
		byte[] bytes = address.getAddress();
		System.out.println("字节数组的形式： "+Arrays.toString(bytes));//[-64, -88, -41, 108]...?
		
		System.out.println(address);
		
		System.out.println("============================================");
//		InetAddress address2 = InetAddress.getByName("DESKTOP-V05FLJV");
		InetAddress address2 = InetAddress.getByName("192.168.215.108");//这也可以
		System.out.println("计算机名: "+address2.getHostName());//DESKTOP-V05FLJV
		System.out.println("IP: "+address2.getHostAddress());
	}

}
