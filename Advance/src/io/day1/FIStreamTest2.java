//6/14[5]
package io.day1;
import java.io.*;

import javax.swing.JOptionPane;
/*[실습] 파일을 읽어서 도스 콘솔에 출력해보자
 * ----------------------------------
 * 데이터 소스: 파일===>노드스트림 (FileInputStream)
 * 					int read()
 * 					int read(byte[] d)
 * 데이터목적지: 콘솔===>노드스트림 (System.out)
 * */
public class FIStreamTest2 {

	public static void main(String[] args) 
	throws FileNotFoundException//try catch 잡아야 하지만 이걸로 가능(이거 설명)
	,IOException//read할때 해줘야 한다.
	{
		//String fileName="C:/MyJAva/Workspace/Advance/src/io/day1/InputStreamTest.java";//데이터소스가 되는 것(절대경로로 만듬 꼭 그럴필요는 없음(도스에서 할때 오류 안나게 할려고)
		String fileName=JOptionPane.showInputDialog("파일명을 입력하세요");
		
		//파일과 노드 연결
		FileInputStream fis=new FileInputStream(fileName);
		PrintStream ps=System.out;
		
		int input=0, count=0, total=0;
		//파일 데이터를 달걀판(배열)에 담아서 읽고 쓰세요.
		byte[] buf=new byte[1100];
		System.out.println("입력하세요=>");
		while((input=fis.read(buf))!=-1) {
			ps.write(buf,0,input);
			count++;
			total+=input;
		}
		ps.println(total+"bytes");
		ps.println(count+"번 반복함");
		
		
		System.in.close();
		System.out.close();
		
		fis.close();
		ps.close();
		

	}

}
