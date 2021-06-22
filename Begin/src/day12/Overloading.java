package day12;

public class Overloading {

	
	public static void main(String[] args) {
		Superman s1=new Superman();
		Aquaman a1=new Aquaman();
		
		Superman s2=new Superman("홍슈퍼맨");
		//s2.setName("홍슈퍼맨")
		
		
		String info=s1.showInfo();
		System.out.println(info);
		System.out.println(s2.showInfo());
		
		Superman s3=new Superman("김슈퍼맨",188);
		System.out.println(s3.showInfo());
		
		//이름, 키, 초능력
		Superman s4=new Superman("박슈퍼맨",190,300);
		System.out.println(s4.showInfo());
		
		
		Aquaman a2=new Aquaman("김아쿠아");
		
		System.out.println(a1.showInfo());
		
		//슈퍼맨객체 4명을 저장할 배열을 생성하고 초기화하기
		//for루프 이용해서 슈퍼맨들의 모든 정보 출력하기
		Superman arr[]= {s1,s2,s3,s4};
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i].showInfo());
		}
		//[2] 아쿠아맨도 배열에 저장후 반복문 이용해 출력하기
		Aquaman arr2[]=new Aquaman[2];
				arr2[0]=a1;
				arr2[1]=a2;
				
		for(int i=0;i<arr2.length;i++) {
			System.out.println(arr2[i].showInfo());
		}
		//확장 forloop
		int []x= {1,2,3,4};
		/*for(변수선언문: 자료구조)
		 * {
		 * 
		 * }
		 * */
		for(int num:x) {
			System.out.println("num: "+num);
		}
		//확장 forloop 이용해서 arr에 저장된 슈퍼맨들의 이름만 출력하세요.
	
		for(Superman s:arr) {
			System.out.println(s.name);
		}
	}

}
