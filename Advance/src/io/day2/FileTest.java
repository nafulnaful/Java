//6/15[6]//90���ΰ� ��Ʈ���ε� ������ ��Ʈ�� �ƴ�
package io.day2;
import java.io.*;
/*FileŬ������ �ֿ� �޼ҵ� ���캸��
 * */
public class FileTest {

	public static void main(String[] args) {

		String fileName="src/io/day2/ReadEmployee.java";

		File file=new File(fileName);
		
		long fsize=file.length();//���� ũ��
		System.out.println("���� ũ��: "+fsize);
		System.out.println("���ϸ�: "+file.getName());
		System.out.println("�����: "+file.getPath());
		System.out.println("������: "+file.getAbsolutePath());//������ �˾ƾ��ϴ� ��찡 ����.
		
		File file2=new File("sample");//"sample","test.txt"�и�,���ϸ�
		System.out.println("����/DIR ���� ����: "+file2.exists());
		if(!file2.exists()) {//file2�� �������� �ʴ´ٸ�
			boolean b=file2.mkdir();//DIR�� ������
			//���丮�� �����Ǹ� true�� ��ȯ��
			System.out.println("b="+b);
		}//if------------------------------
		
		File file3=new File("example","day01");//���� ���丮, ���� ���丮
				if(!file3.exists()) {//������ �������� Ȯ��
					file3.mkdirs();//���������� dir���鶧�� mkdirs�� ���
				}
		
				//sample���丮���� mydata��� �̸����� �����ϱ�
				//boolean renameTo(File newF)
				
				file2.renameTo(new File("mydata"));
				
				//boolean delete() : ���� �Ǵ� dir����
				boolean b2=file3.delete();
				System.out.println("��������: "+b2);//exaple�� ������ �ȵǰ� day01�� ����
				//����ó���� �ش� ���丮 ���� �����̳� ���� ���丮�� ���� �� ����.
	}

}
