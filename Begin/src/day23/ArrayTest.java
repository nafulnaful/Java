package day23;
/*(1)
 * 벡터는 컬렉션계열중 리스트 계열에 속한다
자바입문 2에 나옴
오늘 배울건 arraylist*/

import java.util.*;
/*
 * ArrayList
 * -list계열
 * -순서 기억. 데이터 중복을 허용
 * -vector와 유사. 차이점은 동기화가 구현되어 있지 않음. 웹에서 주로 사용됨
 * */
public class ArrayTest {

	public static void main(String[] args) {
			ArrayList<String> arrList= new ArrayList<>();
			arrList.add("Java");//저장할때는 add
			arrList.add("C");//저장할때는 add
			arrList.add("Python");//저장할때는 add
			arrList.add("JavaScript");//저장할때는 add
			arrList.add("Java");//이게 데이터 중복이 됨 전에 나온거지만 가능
			
			String str= arrList.get(0);
			System.out.println(str);
			
			//Iterator<E> iterator() 를 이용해서 arrlist에 저장된 값을 출력해보자  ==>반환타입인데 리스트 타입은 반환타입이 있다
			
			Iterator<String> it=arrList.iterator();
			while(it.hasNext()) {
				String s=it.next();
				System.out.println(s);
			}
	}


}
