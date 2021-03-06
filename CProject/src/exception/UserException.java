package exception;

import java.util.regex.Pattern;

public class UserException {

	/**이름 확인*/
	public void nameCheck(String name) throws AuthenException{
		boolean check=Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name); //한글
		if(!check) {
			throw new AuthenException("이름은 한글로 입력해주세요.");
		}
	}//nameCheck()-----------
	
	/**생년월일 확인*/
	public void birthCheck(String birth) throws AuthenException {
		boolean check=Pattern.matches("\\d{8}", birth); //한글
		if(!check)
			throw new AuthenException("생년월일은 숫자 8자로 입력하세요.");
	}
	
	/**아이디 확인*/
	public void idFormat(String str) throws AuthenException {
		
		if(str.length()<4||str.length()>13) {
			throw new AuthenException("4~12자 이내의 아이디를 입력하세요.");
		}
		
		int cnt1=0;
		int cnt2=0;
		
		for(int i=0; i<str.length(); i++) {
			char ch=str.charAt(i);
			if((ch>='a'&&ch<='z')) //영문
				cnt1++;
			else if(ch>='0'&&ch<='9') //숫자
				cnt2++;
		}
		
		if(cnt1==0||cnt2==0)
			throw new AuthenException("아이디는 영문 소문자와 숫자를 혼용해서 만들어주세요.");
	}//idFormat()--------------
	
	/**비밀번호 확인*/
	public void pwCheck(String pw1, String pw2) throws AuthenException{
		
		int cnt1=0;
		int cnt2=0;
		
		for(int i=0; i<pw1.length(); i++) {
			char ch=pw1.charAt(i);
			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')) //소문자+대문자
				cnt1++;
			else if(ch>='0'&&ch<='9') //숫자
				cnt2++;
		}
		
		if(cnt1==0||cnt2==0)
			throw new AuthenException("비밀번호는 영문자와 숫자를 혼용해서 만들어주세요.");
		
		if(!pw1.equals(pw2))
			throw new AuthenException("비밀번호가 일치하지 않습니다.");
	}//pwCheck()------------
	
	/**휴대전화 확인*/
	public void telCheck(String phone) throws AuthenException{
		boolean check=Pattern.matches("(010|011|016|017|018|019)\\d{3,4}\\d{4}", phone);
		if(!check)
			throw new AuthenException("전화번호는 숫자만 입력하세요.");
	}
	
	/**이메일 확인*/
	public void emailCheck(String email) throws AuthenException{
		boolean check=Pattern.matches("^[\\w-_]+(\\.[\\w]+)*@([a-zA-Z]+\\.)+[a-z]{2,3}$", email);
		if(!check)
			throw new AuthenException("이메일 전체를 입력하세요.");
	}

}
