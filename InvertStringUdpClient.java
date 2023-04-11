import java.util.*;
import java.io.*;
import java.net.*;

public class InvertStringUdpClient {
	public static void main(String[] args) throws Exception {
		try {
			//DatagramSocket class used for connect client and server
			//client datagram socket cointain no arguments
		DatagramSocket ds = new DatagramSocket();
		
		//Scanner class used for provide user inputs
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the message :");
		String str = sc.nextLine();
		
		//InetAddress class used for get the ip address of host
		InetAddress ip = InetAddress.getByName("localhost");
		
		//DatagramPacket class make datagram of string(message)
		//It contains 1.Bytes of string 2.String length  3.ip address of host 4.port number
		DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(), ip,1111);
		
		//send datagram packet
		ds.send(dp);
		
		//close the connection
		ds.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}