//6/11 2-2
package thread.day2;

import java.util.Random;//��Ʈ�� ����Ʈ o

//1~5���� ���� �ݾ��� �����ϰ� �����ϴ� ������
public class UserOut extends Thread {
	
	private Account account;

	public UserOut(String name, Account ac) {
		this.account=ac;
		setName(name);
	}

	public void run() {
		Random ran=new Random();
		for(int i=0;i<5;i++) {
			int val=ran.nextInt(5)+1;//1~5���� ���� ���� ����
			account.get(val);
		}
	}
}
