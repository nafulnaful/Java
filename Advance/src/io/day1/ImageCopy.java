//6/14[7]
package io.day1;
import java.io.*;
/*[실습] C:/MyJava/Workspace/Advance/images/flower.png 파일을 읽어서 copy.png파일에
 * 내보내보자.
 * -데이터소스: flower.png(파일)==> FileInputStream
 * -데이터목적지: copy.png(파일) ==> FileOutputStream*/
public class ImageCopy {

	public static void main(String[] args) 
	throws IOException{
	
	FileInputStream fis
	=new FileInputStream("C:/MyJava/Workspace/Advance/images/flower.png");
	
	FileOutputStream fos
	=new FileOutputStream("C:/MyJava/Workspace/Advance/copy2.png");
	//[실습] 배열로 저장해서 전송해 보자
	int n=0, count=0;
	byte[] data=new byte[1024];
	while((n=fis.read(data))!=-1) {
		fos.write(data,0,n);
		fos.flush();
		count+=n;
	}
	System.out.println(count+"byte복사 완료");
	fos.close();
	fis.close();
}

}

//배열 이전의 데이터
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
//	System.out.println(count+"byte복사 완료");
//	fos.close();
//	fis.close();
//}
//
//}
