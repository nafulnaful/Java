package day08;

public class ArrayTest3 {

	public static void main(String[] args) {
		/* 2차원 배열
		 * 1)선언
		 * 2)메모리 할당
		 * 3)초기화
		 * */
		int [][]a; //2차원 배열 선언
		int []b[];
		int c[][];
		
		//2. 메모리 할당
		a= new int[3][2];//3행2열
		//3.초기화
		a[0][0]=1;
		a[0][1]=2;
		a[1][0]=3;
		a[1][1]=4;
		a[2][0]=5;
		a[2][1]=6;
		
		//for루프 중첩해서 a에 저장된 값 출력해보기
		for(int i=0;i<a.length;i++) {//행의 조건: 행의 크기 => a.length 
			for(int j=0;j<a[i].length;j++) {//열의 조건: 열의 크기 =>a[i].length
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
		//선언과 동시에 메모리할당, 초기화
		int d[]= {5,6,7};
		int [][]e= {{1,2},{10,20},{'a','b','c'}};
		System.out.println("행의 크기: "+e.length);
		// %d:정수, %f:실수, %c:문자  이런 형태로 출력해달라
		System.out.printf("열의 크기: %d, %d, %d\n",e[0].length, e[1].length, e[2].length);
		
		
		//[1]for루프 이용해서 e에 저장된 값들의 누적 합과 평균값을 출력하세요
		int sum=0, cnt=0;
		for(int i=0;i<e.length;i++) {
			for(int j=0;j<e[i].length;j++) {
				System.out.print(e[i][j]+"\t");
				sum+=e[i][j];
			}
			cnt+=e[i].length; //열의 크기 누적
			System.out.println();
		}
		System.out.println("sum= "+sum);
		System.out.println("avg= "+sum/(float)cnt);
		

	}
}








