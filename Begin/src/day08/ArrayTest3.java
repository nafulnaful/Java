package day08;

public class ArrayTest3 {

	public static void main(String[] args) {
		/* 2���� �迭
		 * 1)����
		 * 2)�޸� �Ҵ�
		 * 3)�ʱ�ȭ
		 * */
		int [][]a; //2���� �迭 ����
		int []b[];
		int c[][];
		
		//2. �޸� �Ҵ�
		a= new int[3][2];//3��2��
		//3.�ʱ�ȭ
		a[0][0]=1;
		a[0][1]=2;
		a[1][0]=3;
		a[1][1]=4;
		a[2][0]=5;
		a[2][1]=6;
		
		//for���� ��ø�ؼ� a�� ����� �� ����غ���
		for(int i=0;i<a.length;i++) {//���� ����: ���� ũ�� => a.length 
			for(int j=0;j<a[i].length;j++) {//���� ����: ���� ũ�� =>a[i].length
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
		//����� ���ÿ� �޸��Ҵ�, �ʱ�ȭ
		int d[]= {5,6,7};
		int [][]e= {{1,2},{10,20},{'a','b','c'}};
		System.out.println("���� ũ��: "+e.length);
		// %d:����, %f:�Ǽ�, %c:����  �̷� ���·� ����ش޶�
		System.out.printf("���� ũ��: %d, %d, %d\n",e[0].length, e[1].length, e[2].length);
		
		
		//[1]for���� �̿��ؼ� e�� ����� ������ ���� �հ� ��հ��� ����ϼ���
		int sum=0, cnt=0;
		for(int i=0;i<e.length;i++) {
			for(int j=0;j<e[i].length;j++) {
				System.out.print(e[i][j]+"\t");
				sum+=e[i][j];
			}
			cnt+=e[i].length; //���� ũ�� ����
			System.out.println();
		}
		System.out.println("sum= "+sum);
		System.out.println("avg= "+sum/(float)cnt);
		

	}
}








