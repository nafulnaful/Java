//6/15[6]//90프로가 스트림인데 파일은 스트림 아님
package io.day2;
import java.io.*;
/*File클래스의 주요 메소드 살펴보기
 * */
public class FileTest {

	public static void main(String[] args) {

		String fileName="src/io/day2/ReadEmployee.java";

		File file=new File(fileName);
		
		long fsize=file.length();//파일 크기
		System.out.println("파일 크기: "+fsize);
		System.out.println("파일명: "+file.getName());
		System.out.println("상대경로: "+file.getPath());
		System.out.println("절대경로: "+file.getAbsolutePath());//절대경로 알아야하는 경우가 많다.
		
		File file2=new File("sample");//"sample","test.txt"분모,파일명
		System.out.println("파일/DIR 존재 여부: "+file2.exists());
		if(!file2.exists()) {//file2가 존재하지 않는다면
			boolean b=file2.mkdir();//DIR을 만들어라
			//디렉토리가 생성되면 true를 바환함
			System.out.println("b="+b);
		}//if------------------------------
		
		File file3=new File("example","day01");//상위 디렉토리, 하위 디렉토리
				if(!file3.exists()) {//파일의 존제여부 확인
					file3.mkdirs();//객층구조의 dir만들때는 mkdirs를 사용
				}
		
				//sample디렉토리명을 mydata라는 이름으로 변경하기
				//boolean renameTo(File newF)
				
				file2.renameTo(new File("mydata"));
				
				//boolean delete() : 파일 또는 dir삭제
				boolean b2=file3.delete();
				System.out.println("삭제여부: "+b2);//exaple은 삭제가 안되고 day01이 삭제
				//삭제처리는 해당 디렉토리 내에 파일이나 서브 디렉토리가 없을 때 가능.
	}

}
