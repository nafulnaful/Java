//6/14[7]
package io.day1;
import java.io.*;
/*[�ǽ�] C:/MyJava/Workspace/Advance/images/flower.png ������ �о copy.png���Ͽ�
 * ����������.
 * -�����ͼҽ�: flower.png(����)==> FileInputStream
 * -�����͸�����: copy.png(����) ==> FileOutputStream*/
public class ImageCopy {

	public static void main(String[] args) 
	throws IOException{
	
	FileInputStream fis
	=new FileInputStream("C:/MyJava/Workspace/Advance/images/flower.png");
	
	FileOutputStream fos
	=new FileOutputStream("C:/MyJava/Workspace/Advance/copy2.png");
	//[�ǽ�] �迭�� �����ؼ� ������ ����
	int n=0, count=0;
	byte[] data=new byte[1024];
	while((n=fis.read(data))!=-1) {
		fos.write(data,0,n);
		fos.flush();
		count+=n;
	}
	System.out.println(count+"byte���� �Ϸ�");
	fos.close();
	fis.close();
}

}

//�迭 ������ ������
//public class ImageCopy {
//
	//public static void main(String[] args) 
//	throws IOException{
//	
//	FileInputStream fis
//	=new FileInputStream("C:/MyJava/Workspace/Advance/images/flower.png");
//	
//	FileOutputStream fos
//	=new FileOutputStream("C:/MyJava/Workspace/Advance/copy.png");
//	
//	int n=0, count=0;
//	while((n=fis.read())!=-1) {
//		fos.write(n);
//		fos.flush();
//		count++;
//	}
//	System.out.println(count+"byte���� �Ϸ�");
//	fos.close();
//	fis.close();
//}
//
//}
