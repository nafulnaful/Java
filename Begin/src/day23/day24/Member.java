package day24;
/*(2)
 * -HashSet
 * : 해쉬셋은 객체를 저장하기 전에 객체의 hashCode()를 호출하여 해시코드를 얻어낸다.
 *     그리고 이미 저장되어 있는 객체들의 해시코드와 비교한다. 만약 동일한 해시코드가 
 *     있다면 그다음에는 equals()메소드로 두 객체를 비교해서 true가 나오면 동일한
 *     객체로 판단하고 중복 저장을 하지 않는다.
 *     Object클래스의 메소드
 *     - hashCode => 주소값(int로 받는다)
 *     - equals() => 주소값 비교
 *     */

public class Member//extends Object
{

	String name;
	int age;
	public Member() {
		
	}
	public Member(String name, int age) {//해쉬셋에 저장할 것
		this.name =name;
		this.age = age;
	}
	@Override
	public int hashCode() {//이걸로 중복 방지(1)->equals로 이제 비교해야함
		int code=name.hashCode()+age;
		return code;//hashCode값을 같게 만든 것
	}
	
	@Override
	public boolean equals(Object obj) {//이걸로 중복 방지(2)
		if(obj instanceof Member) {//멤버 객체가 맞아? obj가?라는 식
			Member user=(Member) obj;
			boolean bool = (user.name.equals(this.name) && user.age ==this.age);
			return bool;
		}else {
			return false;
		}
	}
}/////////////////////////
