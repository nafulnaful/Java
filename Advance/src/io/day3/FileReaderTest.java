//6/16[2]
package io.day3;
import java.io.*;
import javax.swing.*;
/*FileReader
 * - 2byte 기반 스트림
 * -노드스트림(파일과 노드 연결)
 * [실습] 파일을 읽어서 콘솔에 출력
 * 2byte스트림 읽으면 출력도 2바이트 기반 스트림을 사용하는 것이 좋다.
 * 데이터 소스	 : 파일 ===>노드스트림(FileReader)-2byte
 * 데이터 목적지: 콘솔 ===>노드스트림(System.out)-1byte===>브릿지스트림(OutputStreamWriter)
 * */
public class FileReaderTest {

	public static void main(String[] args)
	throws IOException{
		//src/io/day3/Dirlist.java
		String file=JOptionPane.showInputDialog("읽을 파일명을 입력하세요");//팝업창 뜨기
		if(file==null) return;//입력하지 않으면 out
		File f=new File(file);//파일 정의
		System.out.println("읽을 파일 크기: "+f.length()+"bytes");//파일 크기 보여주기
		
		FileReader fr=new FileReader(f);//파일리더(2byte)에 파일 넣어서fr로 정의
		OutputStreamWriter ow=new OutputStreamWriter(System.out);//
		int n=0;
		char[] data=new char[1000];//2byte여서 byte타입이 아닌 char타입으로
		while((n=fr.read(data))!=-1) {
			ow.write(data,0,n);//data를 내보내고 0부터 n까지
			ow.flush();
		}
		fr.close();
		ow.close();
	}

}
