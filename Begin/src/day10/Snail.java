package day10;

public class Snail {

	public static void main(String[] args) {
		int [] arr[] =new int[5][5];
		int cnt=0;//�ݺ��� ���鼭 ��� ++ ������ų ����
		int x=0, y=0;//x: ���� �ε��� , y:���� �ε����� ��� ����
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
