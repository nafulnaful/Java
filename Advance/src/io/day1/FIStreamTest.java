//6/14[4]
package io.day1;
import java.io.*;
/*[실습] 파일을 읽어서 도스 콘솔에 출력해보자
 * ----------------------------------
 * 데이터 소스: 파일===>노드스트림 (FileInputStream)
 * 					int read()
 * 					int read(byte[] d)
 * 데이터목적지: 콘솔===>노드스트림 (System.out)
 * */
public class FIStreamTest {

	public static void main(String[] args) 
	throws FileNotFoundException//try catch 잡아야 하지만 이걸로 가능(이거 설명)
	,IOException//read할때 해줘야 한다.
	{
		String fileName="C:/MyJAva/Workspace/Advance/src/io/day1/InputStreamTest.java";//데이터소스가 되는 것(절대경로로 만듬 꼭 그럴필요는 없음)
		
		//파일과 노드 연결
		FileInputStream fis=new FileInputStream(fileName);
		PrintStream ps=System.out;
		int input=0, count=0;
		while((input=fis.read())!=-1) {
			//파일의 끝에 도달하면 -1을 반환한다.
			ps.write(input);
			count++;
		}
		ps.println(count+"bytes읽고 씀");
		fis.close();
		ps.close();
		

	}

}
