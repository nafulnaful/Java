//6/16[4]
package io.day3;
import java.io.*;
/*키보드 입력==> 콘솔에 출력
 * BufferedReader/BufferedWriter
 * - 2byte기반
 * - 필터 스트림
 * - 버퍼에 모아서 읽고/쓴다
 * - int read()
 * - String readLine()
 * ------------------------------
 * 데이터 소스	 : 키보드==>노드스트림(System.in)
 * 데이터 목적지: 콘솔 	==>노드스트림(System.out)
 * */
public class StandardinOut {

	public static void main(String[] args)
	throws Exception{
		BufferedReader br
		=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader는 생성자에 Reader계열의 객체를 받아들인다.
	    //따라서 1바이트기반 스트림과 연결해야 할 때는 브릿지 스트림이 필요하다.
		
		BufferedWriter bw
		=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line="";
		//readline() 은 개행문자(\n)를 만나기 전까지의 문자열을 반환한다.
		bw.write("입력하세요=>");
		bw.flush();
		while((line=br.readLine())!=null) {
			//bw.write(line+"\n");
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
	}

}
