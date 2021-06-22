//6/15[5]
package io.day2;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

import javax.swing.JFrame;
/*
 * [실습] src/io/day02/obj.txt 파일을 읽어서 저장된 객체들을 복원시킨다.
 * Employee객체 2개를 복원시켜서 print()메소드 호출해보기
 * 
 * JFrame도 복원시켜서 setSize(), setVisible(true)주기
 * 
 * Date객체를 복원시켜서 toString()호출해서 출력하기
 * 
 * [1] 데이터 소스: 파일===> FileInputStream ===>ObjectInputStream
 * 
 *       Object readObject()
 *      쓴 순서대로 읽어야 함에 주의하자.
 * */
public class ReadEmployee {

	public static void main(String[] args) 
	throws IOException, ClassNotFoundException//해당 클레스를 찾을려고 했으나 못찾을 때 사용
	{
		String file="obj.txt";
		
		ObjectInputStream ois
		=new ObjectInputStream(new FileInputStream(file));
		Employee o1=(Employee)ois.readObject();//쓴순서대로 읽어줘야한다
		o1.print();//자식이 가지고있는 것을 못가져옴 그래서 employee로 받아서 가져옴
		
		Employee o2=(Employee)ois.readObject();//쓴순서대로 읽어줘야한다
		o2.print();//자식이 가지고있는 것을 못가져옴
		
		JFrame jf=(JFrame)ois.readObject();
		jf.setSize(200,200);
		jf.setVisible(true);
		
		Date d=(Date)ois.readObject();
		System.out.println(d.toString());
		
		ois.close();//String은 반드시 close
	}

}
