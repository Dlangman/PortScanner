package scanner;
import java.io.IOException;
import java.net.*;

public class scanport implements Runnable {
	public int[] port;
	public int[] ip;
	public int min_port;
	public int max_port;
	public int min_ip;
	public int max_ip;
	public static PORTSQL psql = new PORTSQL();
	
	public void setlength(int[] real_ip, int[] real_port){
		this.ip = real_ip;
		this.port = real_port;

		if(real_ip.length==4){
			max_ip = min_ip = ip[3];
		}
		else {
			max_ip = ip[4];
			min_ip = ip[3];
		}
		if(real_port.length==1){
			max_port = min_port = port[0];
		}
		else{
			max_port = port[1];
			min_port = port[0];
		}

	}
	
	public void resetport(){
		min_port = port[0];
	}

	//同步锁,需要多线程跑完
	public synchronized int get_port(){
		if(min_port<=max_port)
			return min_port++;
		else 
			return -1;
		
	}
	
	public synchronized int get_ip(){
		if(min_ip<=max_ip)
			if(min_port<=max_port)
				return min_ip;
			else{
				resetport();
				return min_ip++;
			}
		else
			return -1;
		
	}
	
	public void run(){
		
		int current_port = get_port();
		int current_ip4 = get_ip();

		while(current_ip4>=0){
			String host = ""+ip[0]+"."+ip[1]+"."+ip[2]+".";
			host = host+""+current_ip4;
			
			while(current_port>=0){
				try {
					//System.out.println("current host is "+host+ "" +current_port);
					Socket client = new Socket(host,current_port);
					System.out.println(host+" "+current_port+" is success! "+psql.getflag(current_port));
					client.close();
				} catch (IOException e) {
					//System.out.println(current_port+" is 3rr0r!");
				} finally{		
					if(current_ip4==min_ip)
						current_port = get_port();
					else
						break;
				}
			} //while(current_port>=0)
			current_ip4 = get_ip();
		} //while(current_ip4>=0)
	}

}


