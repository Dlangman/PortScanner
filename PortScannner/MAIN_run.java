package scanner;

import java.util.Scanner;
import java.util.Vector;

public class MAIN_run {
	
	//���ʵĵط����߳�(���߳�)
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
				 * ����������У����������Ƶ��߳�����
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				*************************/
			}//end for
	
		    for (Thread t : threads) {  
		        try {  
		          // �ȴ������߳�ִ�����  
		          t.join();  
		        } catch (InterruptedException e) {  
		          e.printStackTrace();  
		        }  
		      }  
		    //threads.clear();//����б�
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
