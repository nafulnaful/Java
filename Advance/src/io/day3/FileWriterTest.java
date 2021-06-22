//6/16[3]
package io.day3;
import java.io.*;
/*키보드 입력받아서 파일에 출력하자.
 * 데이터소스: 키보드 (System.in)-1byte==>InputStreamReader
 * 데이터목적지: 파일 (FileWriter)-2byte
 * 
 * */
public class FileWriterTest {

	public static void main(String[] args) 
	throws IOException
	{
		System.out.println("입력하세요. 입력한 내용은 result.txt에 저장됩니다.");
		String file="C:/MyJava/WorkSpace/Advance/Result.txt";
		
		//키보드와 연결 스트림 생성
		InputStreamReader ir=new InputStreamReader(System.in);
		//file과 연결 스트림 생성
		FileWriter fw=new FileWriter(file, true);//true를 주면 덧붙이기 가능
		
		//반복문 돌면서 키보드 입력받고 파일에 출력하기
		System.out.println("입력하세요");
		int n=0;
		//달걀판에 담아서 읽고 쓰는 코드로 바꿔보기
		char[] data=new char[300];
		while((n=ir.read(data))!=-1) {
			fw.write(data,0,n);
			fw.flush();
		}
		
		//close
		fw.close();
		ir.close();
		System.in.close();
		System.out.close();
		
	}

}
