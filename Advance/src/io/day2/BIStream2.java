//6/15[2]
package io.day2;
import java.io.*;
/*BIStream.java 파일을 읽어서 콘솔에도 출력하고 파일(copy.txt)에도 출력하는 프로그램을 작성하세요.
 * 단 BufferedInputStream과 BufferedOutputStream을 사용하세요.
 * - 데이터소스:   파일    =>노드스트림(FileInputStream) => 필터스트림(BufferedInputStream)
 * - 데이터목적지: 콘솔     =>노드스트림(System.out) => 필터스트림(BufferedOutputStream)
 * 				파일    =>노드스트림(FileOutputStream) => 필터스트림(BufferedOutputStream)
 * */

public class BIStream2 {

	public static void main(String[] args) 
	throws IOException{
		
		String fileName="C:\\MyJava\\Workspace\\Advance\\src\\io\\day2\\BIStream.java";
		FileInputStream fis
		=new FileInputStream(fileName);
		
		BufferedInputStream bis
		=new BufferedInputStream(fis);//파일을 받고 그 파일을 버퍼에 넣어주기
		
		BufferedOutputStream bos
		=new BufferedOutputStream(System.out);
		
		BufferedOutputStream bos2
		=new BufferedOutputStream(new FileOutputStream("copy.txt"));
		
		int n=0, count=0;
		while((n=bis.read())!=-1) {
			bos.write(n);
			bos2.write(n);
		}
		bos.close();
		bos2.close();
		bis.close();
		fis.close();

	}

}
