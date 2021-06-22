package day22;
import java.util.*;

public class VectorTest2 {

	public static void main(String[] args) {
		//[1] Person객체를 3개 생성하기
		Person p1=new Person("홍길동",22);
		Person p2=new Person("이지영",23);
		Person p3=new Person("김남국",24);
		
		//[2] Person 객체를 저장할 Vector v생성하기
		Vector<Person> v=new Vector<>();
		
		//[3] v에 Person객체 3개를 저장하기
		v.add(p1);
		v.add(p2);
		v.add(p3);
		
		//[4] for루프 이용해서 v에 저장된 person의 이름과 나이 출력하기
		for(int i=0;i<v.size();i++) {
			Person p=v.get(i);
			System.out.println(p.getName()+": "+p.getAge()+"세");
		}
	
	//Enumeration<E> elements()
	//Iterator<E> iterator()
		/*
         * public Enumeration<E> elements()
         * public Iterator<E> iterator()
         * : Enumeration이나 Iterator 들은 객체들을 집합체로 관리해주는 인터페이스이다.
         *   이들 인터페이스에는 각각의 객체들을 한 순간에 하나씩 처리할 수 있는 메소드를 제공한다.
         *   (논리적 커서가 존재하여 커서를 이동하면서 데이터를 꺼내올 수 있다.)
         *   -논리적 커서는 첫번째 요소 직전에 위치한다.
         *   1. Enumeration의 주요 메소드
         *      - boolean hasMoreElements(): 논리적 커서가 위치하는 곳 이후에 요소들이 있는지
         *            여부를 묻는다. 요소들이 있으면 true를 반환하고 없으면 false를 반환한다.
         *      - E  nextElement() : 논리적 커서를 다음으로 이동시키고 가리키고 있는 지점의 요소를
         *               반환한다.
         *  2.  Iterator 주요 메소드
         *     - boolean hasMext()
         *     - E next();  
         *    
         * */

	Enumeration<Person> en=v.elements();
	
	while(en.hasMoreElements()) {
		Person p=en.nextElement();
		System.out.println(p.getName()+"#"+p.getAge());
	}
	
	//iterator()메소드를 이용해서 v에 저장도니 요소들을 한꺼번에 출력해보기
	Iterator<Person> it=v.iterator();
	for(int i=1;it.hasNext();i++) {
		Person p=it.next();
		System.out.println(p.getName()+"@"+p.getAge());
	}
	//void copyInto(Object[] anArray)
	//:벡터에 저장된 엘리먼트들을 배열에 카피해준다.
	Person []arr=new Person[v.size()];
	v.copyInto(arr);
	
	//v에 저장된 객체들을 person타입 배열에 카피한 뒤
	//해당 배열을 확장 for루프 이용해서 이름만 출력해보세요
	for(Person per:arr) {
		System.out.println(per.getName());
	}
	
	
	}
	

}
