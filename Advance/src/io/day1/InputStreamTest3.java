//6/14 [3]
package io.day1;
import java.io.*;
/*키보드 입력, 콘솔에 출력
 * 1byte단위로 이동하는 것이 아니라 byte배열에 담아서 읽고 내보내보자.
 * => 달걀판에 담아 이동시키기
 * */
public class InputStreamTest3 {

	public static void main(String[] args) 
	throws IOException
	{
		//달걀판 만들기
		byte[] data=new byte[6];
		int input=0, count=0, total=0;
		System.out.println("입력=>");
		while((input=System.in.read(data))!=-1) {//data를 넣음으로써 달걀판이 만들어진격 입력하면
			//입력받은 데이터는 data배열에 담긴다.
			//System.out.write(input);//[x]
			System.out.write(data,0,input);//0에서부터 담은 달걀 개수까지만 내보내라
			//달걀이 담긴 달갼판을 write해야 함
			//여기서 input변수에는 달걀판에 담긴 달걀의 개수를 가지고 있음
			count++; //반복문 횟수
			//System.out.println("input="+input); 이건 달걀 횟수를 알기위해 했으나 확인했으니까 주석
			total+=input;
 		}
		System.out.println("------------------------------");
		System.out.println(total+"bytes 읽음");
		System.out.println("------------------------------");
		
		System.in.close();//구멍들을 닫아주는 역활 원래는 해줘야하나 시스템을 닫으면 잠겨서 그냥 안했었음
		System.out.close();
	}

}
