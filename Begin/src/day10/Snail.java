package day10;

public class Snail {

	public static void main(String[] args) {
		int [] arr[] =new int[5][5];
		int cnt=0;//반복문 돌면서 계속 ++ 증가시킬 예정
		int x=0, y=0;//x: 행의 인덱스 , y:열의 인덱스로 사용 예정
		for(int j=0;j<2;j++) {
			for(int i=0;i<4;i++) {
				arr[x][y]=++cnt;
				y++;
			}
			if(x+y==4) {
				for(int i=0;i<4;i++) {
					arr[x][y]=++cnt;
					x++;
				}
			}
			if(x==y) {
				for(int i=0;i<4;i++) {
					arr[x][y]=++cnt;
					y--;
				}
			}
			if(x+y==4) {
				for(int i=0;i<4;i++) {
					arr[x][y]=++cnt;
					x--;
				}
			}
		}//for j------------------
			
		System.out.println("x: "+x+", y: "+y);
		System.out.println("--------------");
		for(int i=0;i<arr.length;i++) {
			for(int k=0;k<arr[i].length;k++) {
				System.out.print(arr[i][k]+"\t");
			}
			System.out.println();
		}//for---

	}

}
