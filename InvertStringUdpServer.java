import java.util.*;
import java.io.*;
import java.net.*;

public class InvertStringUdpServer {
	public static void main(String[] args) throws Exception {
		System.out.println("Waiting for Client");
		try {
			//InetAddress class used for get the ip address of host
		InetAddress ip = InetAddress.getByName("localhost");
		
		//DatagramSocket class used for connect client and server
			//server datagram socket cointain port number as an arguments
		DatagramSocket ds = new DatagramSocket(1111);
		
		//byte array of size 1024byte used for receive the packet
		byte []data = new byte[1024];
		
		//DatagramPacket class make datagram of string(message)
		//Server datagram packet contains data[] and size
		DatagramPacket dp = new DatagramPacket(data , 1024);
		
		//receive the datagram packet
		ds.receive(dp);
		
		//transfer the datagram packet to string 
		//it cointain data of datagram packet starting index and ending index
		String str = new String(dp.getData(), 0, dp.getLength());
		
		//Call the invert string function to perform invert string
		invert(str);
		
		//close the connection
		ds.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void invert(String s) {
		 char c ;
		 
		 //String array for take character of string s
		 String []string = new String[s.length()];
		 for(int i=0; i < s.length() ; i++){
			 
			 //check character of string is uppercase
			 if(Character.isUpperCase(s.charAt(i))){
				 string[s.length() - i -1] = s.substring(i,i+1); 
				 string[s.length() - i -1] =string[s.length() - i -1].toLowerCase();
			 }
			 //check character of string is lowercase
			else if(Character.isLowerCase(s.charAt(i))){
				 string[s.length() - i - 1] = s.substring(i,i+1); 
				 string[s.length() - i -1] = string[s.length() - i -1].toUpperCase();
			}
			else {
				string[s.length() - i -1] = " ";
			}
		 }
		 
		 //Print the inverted string
		 for(int i=0; i < s.length() ; i++){
			 System.out.print(string[i]);
		 }
	 }
}
		
		
		