// 6/11[1]
package thread.day2;
import javax.swing.*;
//java.lang.Runnable인터페이스를 상속받아 구현
public class Snail extends JPanel implements Runnable {
	
	@Override
	public void run(){
		for(int i=0; i<5;i++) {
			System.out.println("달팽이가 기어가요~~");
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
