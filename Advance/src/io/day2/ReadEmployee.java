//6/15[5]
package io.day2;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

import javax.swing.JFrame;
/*
 * [�ǽ�] src/io/day02/obj.txt ������ �о ����� ��ü���� ������Ų��.
 * Employee��ü 2���� �������Ѽ� print()�޼ҵ� ȣ���غ���
 * 
 * JFrame�� �������Ѽ� setSize(), setVisible(true)�ֱ�
 * 
 * Date��ü�� �������Ѽ� toString()ȣ���ؼ� ����ϱ�
 * 
 * [1] ������ �ҽ�: ����===> FileInputStream ===>ObjectInputStream
 * 
 *       Object readObject()
 *      �� ������� �о�� �Կ� ��������.
 * */
public class ReadEmployee {

	public static void main(String[] args) 
	throws IOException, ClassNotFoundException//�ش� Ŭ������ ã������ ������ ��ã�� �� ���
	{
		String file="obj.txt";
		
		ObjectInputStream ois
		=new ObjectInputStream(new FileInputStream(file));
		Employee o1=(Employee)ois.readObject();//��������� �о�����Ѵ�
		o1.print();//�ڽ��� �������ִ� ���� �������� �׷��� employee�� �޾Ƽ� ������
		
		Employee o2=(Employee)ois.readObject();//��������� �о�����Ѵ�
		o2.print();//�ڽ��� �������ִ� ���� ��������
		
		JFrame jf=(JFrame)ois.readObject();
		jf.setSize(200,200);
		jf.setVisible(true);
		
		Date d=(Date)ois.readObject();
		System.out.println(d.toString());
		
		ois.close();//String�� �ݵ�� close
	}

}
