package day08;

public class ArrayTest4 {

	public static void main(String[] args) {
		//행의 크기만 먼저 잡아놓고, 열의 크기를 나중에 할당하는 방법(반대로는 불가능)
		char[][] ch=new char[3][];
		
		ch[0]=new char[2];//1행은 2열
		ch[1]=new char[4];//2행은 4열
		ch[2]=new char[3];//3행은 3열
		
		ch[0][0]='H';
		ch[0][1]='i';
		
		ch[1][0]='J';
		ch[1][1]='a';
		ch[1][2]='v';
		ch[1][3]='a';
		
		//char의 디폴트값: '\u0000'
		
		//for루프 이용해 출력하기
		for(int i=0;i<ch.length;i++) {
			for(int k=0;k<ch[i].length;k++) {
				System.out.print(ch[i][k]);
			}
			System.out.println();
		}
		
		/*[1] 2차원 배열을 생성해서 아래와 같이 값을 저장-for루프 이용해서 한 뒤, for루프문 이용해 출력하세요
	       * 
	       * 1 0 0 0 0
	       * 0 1 0 0 0
	       * 0 0 1 0 0
	       * 0 0 0 1 0
	       * 0 0 0 0 1
	       */
		int[][] arr=new int[5][5];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(i==j)
					arr[i][j]=1;
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
		 
	       /* [2] 다음 예시를 보고 자료유형을 맞춰보세요
	       * 
	       * 1) int i, j;            정수형
	       * 2) int i[], j;          i:1차원배열,j:정수형          
	       * 3) int [] i, j;         i,j:1차원배열     
	       * 4) int i[], j[][], k;   i:1차원배열, j:2차원배열, k:정수형    
	       * 5) int []i[], j;        i:2차원배열, j:1차원배열
	       * 6) int []i[], []j;      i,j:2차원배열
	       * */
	
	}

}









