//6/16[1]
package io.day3;
import java.io.File;
import java.util.Date;

import javax.swing.JOptionPane;
import java.text.*;

public class DirList {

	public static void main(String[] args) {
		String dirName=JOptionPane.showInputDialog("���丮���� �Է��ϼ���");
		if(dirName==null) return;//�Է��� ���� ������ ����
		
		File dir=new File(dirName);
		// boolean isDirectory() : ���丮�� true�� ��ȯ
		// boolean isFile() : �����̸� true�� ��ȯ
		System.out.println(dir.isDirectory());//dir�� directiory�� �´°�?
		//String[] list()  
		//[1] �ش� ���丮�� �ִ� �����̳� ���丮 �̸��� ������ ����ϱ�
		String[] fList=dir.list();
		if(fList!=null) {
			for(String fname:fList) {
				System.out.println(fname);//������ �̸��̳� ���丮�� �̸��� �߳������� ������ �� �˷���
			}
		}
	
		//[2] �ش� ���丮�� ����/dir�� �̸��� ����ũ��, File/dir, ������������
		//������ ����ϱ�
		//File[] listFiles()
		File[] fList2 = dir.listFiles();
		if(fList2!=null) {
			String fsize="";
			String time="";
			Date d=null;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");//yy:�⵵ MM:��
			//����Ŭ������ => mm:�� mi:��
			System.out.println("------------------------------------------");
			System.out.println("������������\tFILE/DIR\t���ϸ�\t����ũ��");
			System.out.println("------------------------------------------");
			
			for(File f:fList2) {
				String fname=f.getName();
				String str=(f.isFile())?"FILE":"DIR";
				if(!f.isDirectory()) {//������ ���
					fsize=f.length()+"bytes";
					long time_long =f.lastModified();
					d=new Date(time_long);
					time=sdf.format(d);
				}else {//����� ���丮�� ���
					fsize="";
					time="";
				}
				System.out.println(time+"\t"+str+"\t"+fname+"\t"+fsize);
			}
				System.out.println("------------------------------------------");
		}//if()-------------------------------------------

	}

}
