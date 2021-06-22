//6/15[1]
package io.day2;
import java.io.*;
/*BufferedInputStream/BufferedOutputStream
 * - 1byte 기반 스트림
 * - 필터스트림
 * - 기능 : 데이터들을 버퍼에 차곡 차곡 모아두었다가
 *         버퍼가 가득 차면 한꺼번에 읽어들임
 * [실습] 키보드로 입력받아 콘솔에 출력하자
 * 노드스트림: System.in/System.out
 * 필터스트리: BufferedInputStream/BufferedOutputStream
 * */
public class BIStream {

	public static void main(String[] args) 
	throws IOException{//입출력할때는 반드시 io익셉션해줘야한다.

		BufferedInputStream bis
				=new BufferedInputStream(System.in);//in뒤에 ,10를 하면 버퍼의 크기를 의미한다.
		BufferedOutputStream bos
				=new BufferedOutputStream(System.out);
		//데이터는 메모리 버퍼에 누적되고 버퍼가 가득찰면 한꺼번에 읽어들이거나
		//출력한다.
		int n=0, count=0;
		bos.write("입력하세요=>".getBytes());//문자열을 받을수 없다 buffer는 그래서 .getBytes()로 byte배열로 변환해줘야한다.
		bos.flush();//밀어내기(buffer는 모았다가 나가는데 보기 답답하니까 바로바로 밀어내게 만드는 것)
		while((n=bis.read())!=-1) {
			bos.write(n);
			bos.flush();
			count++;
		}
		bos.write((count+"bytes 읽고 씀").getBytes());
		
		bos.close();
		bis.close();
	}

}
