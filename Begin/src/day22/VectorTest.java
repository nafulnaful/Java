package day22;
import java.util.*;

public class VectorTest {

	public static void main(String[] args) {
		Vector v=new Vector(5,3);//초기용량:5 증가치:3
		System.out.println("v.capacity(): "+v.capacity());//용량
		System.out.println("v.size(): "+v.size());
		//벡터에 저장한 엘리먼트 수
		
		v.add("Hello");
		v.add(new Object());
		v.add(10);//10값이 integer객체로 저장 auto boxing
		v.add(new Integer(200));
		//vector는 object유형들만 저장 가능

		System.out.println("v.capacity()2: "+v.capacity());
		System.out.println("v.size()2: "+v.size());
		
		for(int i=1;i<9;i++) {
			v.add("Hi "+i);
		}
		
		System.out.println("v.capacity()3: "+v.capacity());
		System.out.println("v.size()3: "+v.size());
		//데이터 꺼내기
		//object get(int index)
		//object elementsAt(int index)
		
		Object o1=v.get(0);
		System.out.println(((String)o1).toUpperCase());
	
		Object o2=v.get(2);
		Integer str=(Integer)o2;
		System.out.println(o2);
		System.out.println(Integer.toBinaryString(str));

		System.out.println("*************************");
		//java5.0이후 => Generic을 이용해 벡터를 생성
		//Vector<String> v2=new vector<String>(10,5);
		//v2에는 String 유형만 저장하겠다는 의미
		Vector<String> v2=new Vector<>(10,5);
		for(int i=1;i<6;i++) {
			v2.add("Java "+i);
		}
		v2.add(String.valueOf(10));
		
		String s1=v2.get(0);
		
		/*[문제1] v2를 for루프를 이용해서 v2에 저장된 값을 한꺼번에 출력*/
		for(int i=0; i<v2.size();i++) {
			String s=v2.get(i);
			System.out.println(s);
		}
		//확장 for루프로 변경해보기
		
		/*[문제2] Float유형을 저장할 벡터 v3를 생성하고 객체 3개이상 저장
		 * 그런뒤 for루프 이용해서 꺼내 합계를 구하고 평균값도 구하세요*/
		Vector<Float> v3=new Vector<>();
		v3.add(new Float(3.14));
		v3.add(Float.valueOf(2.78f));
		v3.add(Float.valueOf(15));
		//기본자료형 ==>Wrapper class유형으로 auto boxing
		//Wrapper class==> 기본자료형으로 auto unboxing
		float sum=0.0f;
		for(int i=0;i<v3.size();i++) {
			Float f=v3.get(i);
			System.out.println(f);
			sum+=f;
		}
		System.out.println("sum :"+sum);
		System.out.println("avg: "+sum/v3.size());
		
		int[]arr= {1,2,3};
		for(int a : arr) {
			System.out.println(a);
		}
		
	//v2 확장 for루프 이용
		for(String b:v2) {
			System.out.println(b.toLowerCase());
		}
	//v3 
		for(Float c:v3) {
			System.out.println(c);
		}
	}
	

}
