package day23;

import java.util.*;
/*(4)Member.properties�� �����ٰ� ����.*/
import java.io.*;

public class PropertiesTest2 {

	public static void main(String[] args) 
	throws FileNotFoundException, IOException
	{
		// member.properties ���Ͽ� ����� ������ Properties��ü�� �Űܺ���.
			String fileName="./src/day23/member.properties";//����η� ��Ÿ����(Begin�� �������� �Ѵ�)
			FileReader fr=new FileReader(fileName);//�ش� ������ ã�� �� ������
			//������ �д� Ŭ������ ����

			Properties pr=new Properties();
			pr.load(fr);//member.properties���Ͽ� ����� key-value������
			//Properties��ü�� �ű��.
			
			fr.close();//filereader�� close����� �Ѵ�.
			
			String email= pr.getProperty("Hong");
			System.out.println("Hong=>"+email);
			
			System.out.println("Admin=>"+pr.getProperty("Admin"));
	}

}
