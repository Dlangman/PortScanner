package scanner;

import java.util.Scanner;

public class cmd_import {
	public int[] int_port =null;
	public int[] int_ip = null;
	
	public boolean set_port(String[] port){
		boolean istrue = false;
		int_port = new int[port.length];
		int i;
		try{
			for(i=0;i<port.length;i++){
				int_port[i] = Integer.parseInt(port[i]);
				if(int_port[i]<0||int_port[i]>65535)
					break;
			}
			if(i==1&&port.length==1){
					istrue = true;
			}
			else if(port.length==2&&i==2){
				if(int_port[1]>int_port[0])
					istrue = true;
			}
			
		} catch(NumberFormatException e){
			System.out.println("[!] Wrong2 parameters ");
		}
		return istrue;
	}
	
	public boolean set_ip(String[] ip){
		boolean istrue = false;
		String[] ip1 = ip[0].split("\\.");
		if(ip.length==2){
			int_ip = new int[5] ; 
			int_ip[4] = Integer.parseInt(ip[1]); //最后一个段,单独赋值、判定
			if(int_ip[4]<0||int_ip[4]>255)
				return false;
		}
		else 
			int_ip = new int[4] ;
		try{
			int i;			
			for(i=0;i<ip1.length;i++){
				int_ip[i] = Integer.parseInt(ip1[i]);
				if(int_ip[i]<0||int_ip[i]>255){
					break;
				}
			} //end for
			if(ip.length==1&&i==4)
				istrue = true;
			else if(ip.length==2&&i==4)
				if(int_ip[4]>int_ip[3])
					istrue = true;
		} catch(NumberFormatException e){
			System.out.println("[!] Wrong3 parameters ");
		}
		return istrue;
	}
	
	public void run_real(){
		boolean istrue = false;
		String[] Array_port ;
		String[] Array_ip ;
		while(!istrue){
			System.out.println("[+] Please enter true >>> ");
			Scanner ms4 = new Scanner(System.in);
			String str = ms4.nextLine();
			String[] strArray = str.split(" ");
			
			if(strArray.length==2){
				// 127.0.0.1-2 80-78
				Array_ip = strArray[0].split("-");
				Array_port = strArray[1].split("-");
				if(set_ip(Array_ip)&&set_port(Array_port))
					istrue = true;
			}
			else{
				System.out.println("[!] error ");
			}
		}//end while
	}	
}
