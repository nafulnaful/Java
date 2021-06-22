package day11;

public class SchoolApp {

	public static void main(String[] args) {
		//1. 학생객체 2개 생성해서 학번,이름,학급 값을 할당후 showInfo() 호출해서 출력해보기
		Student s1=new Student();
		Student s2=new Student();
		
		s1.setNo(1);
		s1.setName("홍길동");
		s1.setClassName("이과");
		
		s2.setNo(2);
		s2.setName("김기영");
		s2.setClassName("문과");
		
//		System.out.println(s1.getName());
		s1.showInfo();
		s2.showInfo();
	
		
		//2. 교사객체 1개 생성, 초기화, 출력 
		Teacher t1=new Teacher();
		
		t1.setNo(10);
		t1.setName("이가영");
		t1.setSubject("HTML");
		t1.showInfo();
		
		//3.교사 객체 1개 더 생성해서 정보 출력
		Teacher t2=new Teacher();
		
		t2.setNo(15);
		t2.setName("한소영");
		t2.setSubject("JAVA");
		t2.showInfo();
		
		//4.교사 2명을 저장할 배열을 선언하고 메모리할당 한 뒤, t1, t2을 배열에 저장하세요
		//int tea[];
		//tea=new int[2];
		//tea[0]=t1;
		//tea[1]=t2;
		Teacher arr[]=new Teacher[3];//teacher만 가능 student안돼 배열은 같은 개열만 가능
		arr[0]=t1;
		arr[1]=t2;
		arr[2]=new Teacher();
		arr[2].setNo(300);
		arr[2].setName("이교사");
		arr[2].setSubject("c");
		
		//5.반복문 돌면서 배열에 저장된 교사들의 정보를 한꺼번에 출력해보기
		for(int i=0;i<arr.length;i++) {
			arr[i].showInfo();
		}
		
		//6. Student배열 생성해서 s1,s2저장하기
		Student atr[]= {s1,s2};
		/*Student atr[]=new Student[3];
		atr[0]=s1;
		atr[1]=s2;
		atr[2]=new Student();
		atr[2].setNo(3);
		atr[2].setName("김민수");
		atr[2].setClassName("문이과");*/
		
		//7. 반복문 이용해서 학생정보 출력하기
		for(int i=0;i<atr.length;i++) {
			atr[i].showInfo();
		}
	}//////

	private static void showInfo(Student sd) {
		// TODO Auto-generated method stub
		
	}

}
