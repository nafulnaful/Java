// 6/11[1]
package thread.day2;
import javax.swing.*;
//java.lang.Runnable�������̽��� ��ӹ޾� ����
public class Snail extends JPanel implements Runnable {
	
	@Override
	public void run(){
		for(int i=0; i<5;i++) {
			System.out.println("�����̰� ����~~");
			int sec=(int)(Math.random()*2000);
			try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//try----
		}//for--
	}//run()-------------
}//class------------
