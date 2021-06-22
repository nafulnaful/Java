package day23;
/*(3)*/
import java.util.*;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties p=new Properties();//genric할필요 없다 String만 쓸수 있기 때문
		p.put("OS","Window");//put써도 저장은 되나 setProperty 권장
		p.setProperty("DBMS", "Oracle11g");
		p.setProperty("Lang", "Java#HTML#CSS#SQL");
		
		String os=(String)p.get("OS");
		System.out.println(os);
		
		String db=p.getProperty("DBMS");
		System.out.println(db);
		
		//[문제1] 사용 가능한 언어를 꺼내서 출력하기
		String lang=p.getProperty("Lang");
		System.out.println(lang);
		
		//[문제2] #을 기준으로 문자열을 쪼개서 Java HTML CSS SQL형태로 출력해보기
		//이런것을 토큰이라고 한다. String[] split(String regex)
		

		String[] tokens=lang.split("#");
		//#을 기준으로 문자열을 쪼개어 배열로 반환을 한다.
		if(tokens!=null) {
			for(String tk: tokens) {//:이거 뭐지???
				System.out.print(tk);
			}
		}
	}

}
