package day08;

public class ArrayTest4 {

	public static void main(String[] args) {
		//���� ũ�⸸ ���� ��Ƴ���, ���� ũ�⸦ ���߿� �Ҵ��ϴ� ���(�ݴ�δ� �Ұ���)
		char[][] ch=new char[3][];
		
		ch[0]=new char[2];//1���� 2��
		ch[1]=new char[4];//2���� 4��
		ch[2]=new char[3];//3���� 3��
		
		ch[0][0]='H';
		ch[0][1]='i';
		
		ch[1][0]='J';
		ch[1][1]='a';
		ch[1][2]='v';
		ch[1][3]='a';
		
		//char�� ����Ʈ��: '\u0000'
		
		//for���� �̿��� ����ϱ�
		for(int i=0;i<ch.length;i++) {
			for(int k=0;k<ch[i].length;k++) {
				System.out.print(ch[i][k]);
			}
			System.out.println();
		}
		
		/*[1] 2���� �迭�� �����ؼ� �Ʒ��� ���� ���� ����-for���� �̿��ؼ� �� ��, for������ �̿��� ����ϼ���
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
		
		
		 
	       /* [2] ���� ���ø� ���� �ڷ������� ���纸����
	       * 
	       * 1) int i, j;            ������
	       * 2) int i[], j;          i:1�����迭,j:������          
	       * 3) int [] i, j;         i,j:1�����迭     
	       * 4) int i[], j[][], k;   i:1�����迭, j:2�����迭, k:������    
	       * 5) int []i[], j;        i:2�����迭, j:1�����迭
	       * 6) int []i[], []j;      i,j:2�����迭
	       * */
	
	}

}









