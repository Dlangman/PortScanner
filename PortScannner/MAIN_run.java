package scanner;

import java.util.Scanner;
import java.util.Vector;

public class MAIN_run {
	
	//合适的地方跑线程(主线程)
	public void run(int length) {		
		boolean isfinished = false;
		scanport scp1 = new scanport();
		Vector<Thread> threads = new Vector<Thread>();  
		
		do{			
			cmd_import cmdimport = new cmd_import();
			cmdimport.run_real();
			scp1.setlength(cmdimport.int_ip,cmdimport.int_port);
			for(int i=0; i<length; i++){
				Thread t = new Thread(scp1);
				threads.add(t);
				t.start();
				/**************************
				 * 这个方法不行，将会变成类似单线程运行
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				*************************/
			}//end for
	
		    for (Thread t : threads) {  
		        try {  
		          // 等待所有线程执行完毕  
		          t.join();  
		        } catch (InterruptedException e) {  
		          e.printStackTrace();  
		        }  
		      }  
		    //threads.clear();//清空列表
			System.out.print("[?]Continue Y/N: ");
			Scanner ms = new Scanner(System.in);
			String str = ms.nextLine().substring(0, 1).toUpperCase();
			if(str.equals("N")){
				isfinished = true;
			}
			
		}while(isfinished==false);
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		MAIN_run run = new MAIN_run();
		run.run(200);

	}

}
