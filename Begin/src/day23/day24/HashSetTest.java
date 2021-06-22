package day24;
/*(1)
 * Set계열의 특징
 * -순서를 기억하지 않는다.
 * -데이터 중복을 허용하지 않는다.
 * -구현클래스
 * -HashSet
 * : 해쉬셋은 객체를 저장하기 전에 객체의 hashCode()를 호출하여 해시코드를 얻어낸다.
 *     그리고 이미 저장되어 있는 객체들의 해시코드와 비교한다. 만약 동일한 해시코드가 
 *     있다면 그다음에는 equals()메소드로 두 객체를 비교해서 true가 나오면 동일한
 *     객체로 판단하고 중복 저장을 하지 않는다.
 *     */
import java.util.*;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> set=new HashSet<>();
		set.add("Java");
		set.add("Servlet");
		set.add("JSP");
		System.out.println("저장된 객체 수: "+set.size());
		set.add("Java");
		System.out.println("저장된 객체 수2" + set.size());
		
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String str=it.next();
			System.out.println(str);
		}
		
		for(String s:set) {//s에 저장된 데이터 선언
			System.out.println(s.toLowerCase());
		}
		
		
	}

}
