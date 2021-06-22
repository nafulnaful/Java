//6/14[6]
package io.day1;
import java.io.*;
/*[실습]키보드로 입력받은 내용ㅇ을 파일(C:/MyJava/Workspace/Advance/Result/txt)에 저장하는 기능
 * ----------------------------------
 * 데이터 소스 : 키보드=>노드스트림(System.in)
 * 데이터 목적지 :파일 =>노드스트림(FileOutputStream)
 * */
public class FOStreamTest {

	public static void main(String[] args) 
		throws IOException
		{
		String file="C:/MyJava/Workspace/Advance/Result.txt";
		FileOutputStream fos
		=new FileOutputStream(file, true);//?
		//ture값을 주면 append기능을 갖는다. 기존 파일 내용에 새로운 내용을 덧붙이기함
		
		System.out.println("파일에 저장할 내용을 입력하세요=>");
		int n=0, cnt=0;
		//[실습1]배열에 담아서 읽고 파일에 써보기
		byte[] buf=new byte[100];
		
		while((n=System.in.read(buf))!=-1) {
			fos.write(buf,0,n);//읽은 데이터 내보내기
			fos.flush();//스트림에 남아있는 데이터가 있으면 밀어내기 해줌
			cnt+=n;
		}
		System.out.println(cnt+"byte씀");
		fos.close();//close를 안쓰면 파일데이터가 안넘어감
		System.in.close();
	}
}


