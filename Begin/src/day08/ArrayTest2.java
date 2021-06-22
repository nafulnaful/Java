package day08;

public class ArrayTest2 {

	public static void main(String[] args) {
		int []a= {1,2,3,4};
		int b[]; //배열 선언
		b=a; //b를 a로 초기화
		/*
		 * a-------->|1|2|3|4|
		 *         |
		 * b-------+
		 * 배열b는 기존 배열a로 할당함
		 * 이 때 b는 새로운 메모리를 할당 받아 생성되는 것이 아니라
		 * a가 참조하는 배열을 b도 같이 참조하는 형태가 된다.
		 * 따라서 a나 b에 저장된 값을 변경하면 함께 변경된다.
		 * */
		//a에 저장된 값 for루프 돌려 출력
		for(int i=0;i<a.length;i++) {
			System.out.println("a["+i+"]="+a[i]);			
		}	
		//b에 저장된 값 for루프 돌려 출력
		for(int i=0;i<b.length;i++) {
			System.out.println("b["+i+"]="+b[i]);
		}
		b[2]=200;
		System.out.println("b[2]="+b[2]);
		System.out.println("a[2]="+a[2]);
		
		System.out.println("---------------------------");
		int x[]= {100,200};
		int []y= {10,20,30};
		int tmp[];
		/*참조 관계를 이용해서 x,y에 저장된 값을 서로 바꾼 뒤에 
		 * for루프로 x,y에 저장된 값을 출력하세요*/
		tmp=x;
		x=y;
		y=tmp;
		for(int i=0;i<x.length;i++) {
			System.out.print(x[i]+", ");
		}
		System.out.println();
		for(int i=0;i<y.length;i++) {
			System.out.print(y[i]+", ");
		}
		System.out.println();
		
	
	}

}








