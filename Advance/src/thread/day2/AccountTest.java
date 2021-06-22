//6/11 2-3
package thread.day2;

public class AccountTest {

	public static void main(String[] args) {
		Account ac=new Account();
		
		UserIn u1= new UserIn("개미", ac);//ac객체를 생성자에 전달하는 과정
		UserOut u2=new UserOut("베짱이",ac);
		
		u2.start();
		u1.start();
	}

}
