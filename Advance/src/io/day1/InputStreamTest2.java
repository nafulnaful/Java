//6/14[2]
package io.day1;
import java.io.*;
/*[실습] 키보드로 입력받은 내용을 도스 콘솔에 출력해보자.
 * -----------------------------------------
 * 데이터 소스 : 키보드   ============>노드 스트림(System.in)
 * 데이터목적지 :도스 콘솔 ============>노드 스트림(System.out)
 * [1] System.in
 * - InputStream타입
 * - 1byte기반 스트림
 * - 키보드와 노드 연결
 * [2] System.out
 * - PrintStream타입
 * - 1byte 기반 스트림
 * - 콘솔과 노드 연결
 * */

public class InputStreamTest2 {

	public static void main(String[] args) 
		throws IOException
		{
		System.out.println("입력하세요=>");
		int input=0;
		int count=0;
		while((input=System.in.read())!=-1) {
			//Ctrl+c(윈도우즈 경우) or Ctrl+D(리눅스) 를 누르면 -1을 반환한다.
			//System.out.print((char)input);//이렇게 하면 아스킵코드값나오는데 안나오게 하는 법(char)로 강제 형변
			System.out.write(input);//write를 써주면 형변환을 하지 않아도 된다. read -> write
			count++;
		}
		System.out.println("===============================");
		System.out.println(count+"bytes익음");
		System.out.println("===============================");
		//input=13,10은 enter값이다
		}

}
