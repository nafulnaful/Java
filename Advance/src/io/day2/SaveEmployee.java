//6/15[4]
package io.day2;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.JFrame;

public class SaveEmployee {

	public static void main(String[] args) 
	throws IOException{
		
		Employee e1=new Employee("홍길동",10,"Manager",5000);
		Employee e2=new Employee("김철수",20,"Salesman",6000);
		String fileName="obj.txt";//파일의 위치
		//객체를 저장할 때는 ObjectOutputStream을 사용
		//=> DataOutput인터페이스 구현, writeObject(객체)
		ObjectOutputStream oos
		=new ObjectOutputStream(new FileOutputStream(fileName));
		oos.writeObject(e1);
		oos.writeObject(e2);
		
		oos.flush();
		
		//[실습1]JFrame생성해서 obj.txt에 저장하기
		 JFrame jf=new JFrame("오브젝트 스트림");
		 oos.writeObject(jf);
		 oos.flush();
		
		//[실습2]java.util.Data객체 생성해서 obj.txt에 저장하기
		Date d= new Date();
		oos.writeObject(d);
		oos.flush();
		 
		 
		oos.close();
		System.out.println(fileName+"에 저장 완료!!");
	}

}
