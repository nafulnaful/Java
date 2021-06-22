package day24;
/*(4)
 * HashMap
 * -map계열
 * -key와 value 매핑하여 저장
 * -Hashtable과 유사. 차이점: 해쉬맵은 동기화가 구현되어 있지 않다.
 * -주로 웹에서 많이 사용
 * */
import java.util.*;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<Integer, Member> map=new HashMap<>();
		Member m1=new Member("홍길동",19);
		Member m2=new Member("김철수",21);
		map.put(1, m1);//1번회원은 m1
		map.put(new Integer(2), m2);
		
		Member user=map.get(2);
		System.out.println(user.name);
		
		if(map.containsKey(1))//map에 1번 회원이 있느냐
		{
		System.out.println(map.get(1).name);
		}
		Set<Integer> set=map.keySet();
		for(Integer key: set) {
			System.out.println(key+"=>"+map.get(key).name);
		}
		//map.values(); => value값만 Collection유형으로 반환
	}

}
