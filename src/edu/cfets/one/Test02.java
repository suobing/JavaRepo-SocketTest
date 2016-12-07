package edu.cfets.one;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL 常用方法
 */
public class Test02 {

	public static void main(String[] args) {
		// 创建一个URL实例
		try {
			URL imooc = new URL("http://www.imooc.com");
			URL url= new URL(imooc,"/index.html?username=tom#test");//参数，锚点
			
			System.out.println("协议："+url.getProtocol());
			System.out.println("主机："+url.getHost());
			//未声明端口号：http默认端口号为80；这里得到端口号为-1
			System.out.println("端口："+url.getPort());//-1
			System.out.println("文件路径："+url.getPath());
			System.out.println("文件名："+url.getFile());
			System.out.println("相对路径："+url.getRef());//锚点
			System.out.println("查询字符串："+url.getQuery());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
