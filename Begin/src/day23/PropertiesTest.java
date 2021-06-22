package day23;
/*(3)*/
import java.util.*;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties p=new Properties();//genric���ʿ� ���� String�� ���� �ֱ� ����
		p.put("OS","Window");//put�ᵵ ������ �ǳ� setProperty ����
		p.setProperty("DBMS", "Oracle11g");
		p.setProperty("Lang", "Java#HTML#CSS#SQL");
		
		String os=(String)p.get("OS");
		System.out.println(os);
		
		String db=p.getProperty("DBMS");
		System.out.println(db);
		
		//[����1] ��� ������ �� ������ ����ϱ�
		String lang=p.getProperty("Lang");
		System.out.println(lang);
		
		//[����2] #�� �������� ���ڿ��� �ɰ��� Java HTML CSS SQL���·� ����غ���
		//�̷����� ��ū�̶�� �Ѵ�. String[] split(String regex)
		

		String[] tokens=lang.split("#");
		//#�� �������� ���ڿ��� �ɰ��� �迭�� ��ȯ�� �Ѵ�.
		if(tokens!=null) {
			for(String tk: tokens) {//:�̰� ����???
				System.out.print(tk);
			}
		}
	}

}
