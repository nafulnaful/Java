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
		
		Employee e1=new Employee("ȫ�浿",10,"Manager",5000);
		Employee e2=new Employee("��ö��",20,"Salesman",6000);
		String fileName="obj.txt";//������ ��ġ
		//��ü�� ������ ���� ObjectOutputStream�� ���
		//=> DataOutput�������̽� ����, writeObject(��ü)
		ObjectOutputStream oos
		=new ObjectOutputStream(new FileOutputStream(fileName));
		oos.writeObject(e1);
		oos.writeObject(e2);
		
		oos.flush();
		
		//[�ǽ�1]JFrame�����ؼ� obj.txt�� �����ϱ�
		 JFrame jf=new JFrame("������Ʈ ��Ʈ��");
		 oos.writeObject(jf);
		 oos.flush();
		
		//[�ǽ�2]java.util.Data��ü �����ؼ� obj.txt�� �����ϱ�
		Date d= new Date();
		oos.writeObject(d);
		oos.flush();
		 
		 
		oos.close();
		System.out.println(fileName+"�� ���� �Ϸ�!!");
	}

}
