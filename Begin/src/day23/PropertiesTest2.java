package day23;

import java.util.*;
/*(4)Member.properties를 가져다가 쓴다.*/
import java.io.*;

public class PropertiesTest2 {

	public static void main(String[] args) 
	throws FileNotFoundException, IOException
	{
		// member.properties 파일에 저장된 내용을 Properties객체로 옮겨보자.
			String fileName="./src/day23/member.properties";//상대경로로 나타낸것(Begin을 기준으로 한다)
			FileReader fr=new FileReader(fileName);//해당 파일을 찾을 수 없을때
			//파일을 읽는 클래스와 연결

			Properties pr=new Properties();
			pr.load(fr);//member.properties파일에 저장된 key-value값들을
			//Properties객체로 옮긴다.
			
			fr.close();//filereader는 close해줘야 한다.
			
			String email= pr.getProperty("Hong");
			System.out.println("Hong=>"+email);
			
			System.out.println("Admin=>"+pr.getProperty("Admin"));
	}

}
