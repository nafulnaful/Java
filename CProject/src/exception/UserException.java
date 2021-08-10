package exception;

import java.util.regex.Pattern;

public class UserException {

	/**ÀÌ¸§ È®ÀÎ*/
	public void nameCheck(String name) throws AuthenException{
		boolean check=Pattern.matches("^[¤¡-¤¾°¡-ÆR]*$", name); //ÇÑ±Û
		if(!check) {
			throw new AuthenException("ÀÌ¸§Àº ÇÑ±Û·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		}
	}//nameCheck()-----------
	
	/**»ı³â¿ùÀÏ È®ÀÎ*/
	public void birthCheck(String birth) throws AuthenException {
		boolean check=Pattern.matches("\\d{8}", birth); //ÇÑ±Û
		if(!check)
			throw new AuthenException("»ı³â¿ùÀÏÀº ¼ıÀÚ 8ÀÚ·Î ÀÔ·ÂÇÏ¼¼¿ä.");
	}
	
	/**¾ÆÀÌµğ È®ÀÎ*/
	public void idFormat(String str) throws AuthenException {
		
		if(str.length()<4||str.length()>13) {
			throw new AuthenException("4~12ÀÚ ÀÌ³»ÀÇ ¾ÆÀÌµğ¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
		}
		
		int cnt1=0;
		int cnt2=0;
		
		for(int i=0; i<str.length(); i++) {
			char ch=str.charAt(i);
			if((ch>='a'&&ch<='z')) //¿µ¹®
				cnt1++;
			else if(ch>='0'&&ch<='9') //¼ıÀÚ
				cnt2++;
		}
		
		if(cnt1==0||cnt2==0)
			throw new AuthenException("¾ÆÀÌµğ´Â ¿µ¹® ¼Ò¹®ÀÚ¿Í ¼ıÀÚ¸¦ È¥¿ëÇØ¼­ ¸¸µé¾îÁÖ¼¼¿ä.");
	}//idFormat()--------------
	
	/**ºñ¹Ğ¹øÈ£ È®ÀÎ*/
	public void pwCheck(String pw1, String pw2) throws AuthenException{
		
		int cnt1=0;
		int cnt2=0;
		
		for(int i=0; i<pw1.length(); i++) {
			char ch=pw1.charAt(i);
			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')) //¼Ò¹®ÀÚ+´ë¹®ÀÚ
				cnt1++;
			else if(ch>='0'&&ch<='9') //¼ıÀÚ
				cnt2++;
		}
		
		if(cnt1==0||cnt2==0)
			throw new AuthenException("ºñ¹Ğ¹øÈ£´Â ¿µ¹®ÀÚ¿Í ¼ıÀÚ¸¦ È¥¿ëÇØ¼­ ¸¸µé¾îÁÖ¼¼¿ä.");
		
		if(!pw1.equals(pw2))
			throw new AuthenException("ºñ¹Ğ¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù.");
	}//pwCheck()------------
	
	/**ÈŞ´ëÀüÈ­ È®ÀÎ*/
	public void telCheck(String phone) throws AuthenException{
		boolean check=Pattern.matches("(010|011|016|017|018|019)\\d{3,4}\\d{4}", phone);
		if(!check)
			throw new AuthenException("ÀüÈ­¹øÈ£´Â ¼ıÀÚ¸¸ ÀÔ·ÂÇÏ¼¼¿ä.");
	}
	
	/**ÀÌ¸ŞÀÏ È®ÀÎ*/
	public void emailCheck(String email) throws AuthenException{
		boolean check=Pattern.matches("^[\\w-_]+(\\.[\\w]+)*@([a-zA-Z]+\\.)+[a-z]{2,3}$", email);
		if(!check)
			throw new AuthenException("ÀÌ¸ŞÀÏ ÀüÃ¼¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
	}

}
