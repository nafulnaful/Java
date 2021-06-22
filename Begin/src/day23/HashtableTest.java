package day23;
/*(2)
 * Map계열
 * Hashtable
 * -Object유형을 저장할 수 있다.
 * - key와 value값을 매핑하여 저장한다.
 * - key값의 중복을 허용하지 않는다. value값은 허용
 * - 무순서
 * - 데이터가 75%차면 자동으로 저장 역역을 확대한다.(vector는 100%)
 * - 데이터 저장: Object put(Object key, Object value)
 * - 데이터 꺼내기: Object get(Object key)
 * */
import java.util.*;

public class HashtableTest {

	public static void main(String[] args) {//Dictionary(사전적)유형이다
		Hashtable h=new Hashtable(20,0.8f); //초기 용량 20/ 80%가 차면 자동으로 영역 확대
		h.put("하나", new Integer(1));
		h.put("둘", 2); //auto boxing이 되서 integer(정수)객체로 저장된다.
		h.put("빨강", "Red");
		h.put("파랑", java.awt.Color.blue);
		
		//Generic을 안쓰면 아래와 같이
		Object obj = h.get("둘");
		Integer i=(Integer)obj; //Integer로 형변환해야한다.(이유 알아보기-오브젝트 유형이여서)
		System.out.println(i);
		
		/*String s=(String)h.get("파랑");
		System.out.println(s);
		이러면 오류가 남 =>잘못된 형변환*/
		
		//Generic사용 <Key값의 유형, Value값의 유형>
		Hashtable<String, Integer> h2=new Hashtable<>();
		h2.put("생년", 1999);
		h2.put("용돈", new Integer(500000));//원래 이렇게 해야하지만 auto boxing된것
		h2.put("나이", 21);
		h2.put("나이", 33);//key값이 중복되지 않고 전에 것을 덮어 쓴다 
		
		Integer age=h2.get("나이");
		System.out.println("age: "+age);//Generic사용하면 형변환 하지 않아도 된다.
		System.out.println("h2.size(): "+h2.size());//사이즈 확인해 보는것
		
		//[실습1] Enumeration<K>	keys()
		//h2에 저장된 key 값들만 추출해서 출력해보기
		Enumeration<String> en=h2.keys();//Generic을 해주는<> 것
		while(en.hasMoreElements()) {
			String key=en.nextElement();
			Integer val=h2.get(key);
			System.out.println(key+": "+ val);
		}
		
		
		//[실습2]Enumeration<V> elements()
		//h2에 저장된 value값들만 추출해서 출력해보기
		Enumeration<Integer> en2=h2.elements();
		for(i=1;en2.hasMoreElements();i++) {
			Integer val=en2.nextElement();
			System.out.println(i+": "+ val);
		}
		
		
		//[실습3]Set<K>    	keySet():key값만 추출
		Set<String> set=h2.keySet();
		Iterator<String> it = set.iterator();
		for(;it.hasNext();) {
			String key=it.next();
			System.out.println(key);
		}
		
		//Set은 확장 for loop 쓸 수 있다
		for(String ky:set) {
			System.out.println(ky+"#");
		}
		
		//[실습4]Collection<V>	values():value값만 추출
		Collection<Integer> col=h2.values();
		for(Integer val:col) {
			System.out.println(val+"@");
		}
	
	}

}////////////////////
