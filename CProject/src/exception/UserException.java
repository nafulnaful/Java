package exception;

import java.util.regex.Pattern;

public class UserException {

	/**�̸� Ȯ��*/
	public void nameCheck(String name) throws AuthenException{
		boolean check=Pattern.matches("^[��-����-�R]*$", name); //�ѱ�
		if(!check) {
			throw new AuthenException("�̸��� �ѱ۷� �Է����ּ���.");
		}
	}//nameCheck()-----------
	
	/**������� Ȯ��*/
	public void birthCheck(String birth) throws AuthenException {
		boolean check=Pattern.matches("\\d{8}", birth); //�ѱ�
		if(!check)
			throw new AuthenException("��������� ���� 8�ڷ� �Է��ϼ���.");
	}
	
	/**���̵� Ȯ��*/
	public void idFormat(String str) throws AuthenException {
		
		if(str.length()<4||str.length()>13) {
			throw new AuthenException("4~12�� �̳��� ���̵� �Է��ϼ���.");
		}
		
		int cnt1=0;
		int cnt2=0;
		
		for(int i=0; i<str.length(); i++) {
			char ch=str.charAt(i);
			if((ch>='a'&&ch<='z')) //����
				cnt1++;
			else if(ch>='0'&&ch<='9') //����
				cnt2++;
		}
		
		if(cnt1==0||cnt2==0)
			throw new AuthenException("���̵�� ���� �ҹ��ڿ� ���ڸ� ȥ���ؼ� ������ּ���.");
	}//idFormat()--------------
	
	/**��й�ȣ Ȯ��*/
	public void pwCheck(String pw1, String pw2) throws AuthenException{
		
		int cnt1=0;
		int cnt2=0;
		
		for(int i=0; i<pw1.length(); i++) {
			char ch=pw1.charAt(i);
			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')) //�ҹ���+�빮��
				cnt1++;
			else if(ch>='0'&&ch<='9') //����
				cnt2++;
		}
		
		if(cnt1==0||cnt2==0)
			throw new AuthenException("��й�ȣ�� �����ڿ� ���ڸ� ȥ���ؼ� ������ּ���.");
		
		if(!pw1.equals(pw2))
			throw new AuthenException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
	}//pwCheck()------------
	
	/**�޴���ȭ Ȯ��*/
	public void telCheck(String phone) throws AuthenException{
		boolean check=Pattern.matches("(010|011|016|017|018|019)\\d{3,4}\\d{4}", phone);
		if(!check)
			throw new AuthenException("��ȭ��ȣ�� ���ڸ� �Է��ϼ���.");
	}
	
	/**�̸��� Ȯ��*/
	public void emailCheck(String email) throws AuthenException{
		boolean check=Pattern.matches("^[\\w-_]+(\\.[\\w]+)*@([a-zA-Z]+\\.)+[a-z]{2,3}$", email);
		if(!check)
			throw new AuthenException("�̸��� ��ü�� �Է��ϼ���.");
	}

}
