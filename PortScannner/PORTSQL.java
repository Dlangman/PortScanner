package scanner;

import java.util.Hashtable;

public class PORTSQL {
	public Hashtable<Integer, String> has=new Hashtable<Integer, String> ();

	public PORTSQL(){
		has.put(21,"FTP (TCP)");
		has.put(23,"TELNET (TCP)");
		has.put(25,"SMTP (TCP)");
		has.put(80,"HTTP (TCP)");
		has.put(110,"POP (TCP)");
		has.put(139,"netBIOS (TCP)");
		has.put(1433,"SQL Server (TCP)");
		has.put(3389,"Terminal Service(TCP)");
		has.put(443,"HTTPS (TCP)");
		has.put(1521,"Oracle (TCP)");
		has.put(3306,"mysql (TCP)");
	}
	public String getflag(int port){
		String flag = has.get(port);
		if(flag!=null)
			return flag;
		else
			return "";
		
	}



}
