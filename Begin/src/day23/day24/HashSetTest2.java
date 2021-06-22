package day24;
/*(3)
 * hashset은 2중 로그인 방지할때 사용-member가서 보면 됨*/
import java.util.*;

public class HashSetTest2 {

	public static void main(String[] args) {
		//[1] Member객체 3명 생성해서 HashSet에 저장하세요
		Member m1=new Member("김고은",23);
		Member m2=new Member("박정민",27);
		Member m3=new Member("이연결",25);
		Member m4=new Member("김고은",23);//중복인 경우 확인하기 위해서
		Member m5=new Member("이연결",33);
		
		
		HashSet<Member> set=new HashSet();
		set.add(m1);
		set.add(m2);
		set.add(m3);
		set.add(m4);
		set.add(m5);
		System.out.println(set.size()+"명 저장됨");
		
		
		//[2] iterator()또는 확장 for루프 이용해서
		//HashSet에 저장된 회원들의 이름과 나이를 출력하세요//get이 없다
		for(Member user:set) {
			//System.out.println(user.hashCode()+"#"+user+"#"+user.name);
			System.out.println(user.name+": "+user.age);
		}

	}

}
