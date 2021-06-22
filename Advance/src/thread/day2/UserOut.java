//6/11 2-2
package thread.day2;

import java.util.Random;//컨트롤 시프트 o

//1~5만원 사이 금액을 랜덤하게 인출하는 스레드
public class UserOut extends Thread {
	
	private Account account;

	public UserOut(String name, Account ac) {
		this.account=ac;
		setName(name);
	}

	public void run() {
		Random ran=new Random();
		for(int i=0;i<5;i++) {
			int val=ran.nextInt(5)+1;//1~5만원 사이 값을 인출
			account.get(val);
		}
	}
}
