package day08;

public class ArrayTest2 {

	public static void main(String[] args) {
		int []a= {1,2,3,4};
		int b[]; //�迭 ����
		b=a; //b�� a�� �ʱ�ȭ
		/*
		 * a-------->|1|2|3|4|
		 *         |
		 * b-------+
		 * �迭b�� ���� �迭a�� �Ҵ���
		 * �� �� b�� ���ο� �޸𸮸� �Ҵ� �޾� �����Ǵ� ���� �ƴ϶�
		 * a�� �����ϴ� �迭�� b�� ���� �����ϴ� ���°� �ȴ�.
		 * ���� a�� b�� ����� ���� �����ϸ� �Բ� ����ȴ�.
		 * */
		//a�� ����� �� for���� ���� ���
		for(int i=0;i<a.length;i++) {
			System.out.println("a["+i+"]="+a[i]);			
		}	
		//b�� ����� �� for���� ���� ���
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
		/*���� ���踦 �̿��ؼ� x,y�� ����� ���� ���� �ٲ� �ڿ� 
		 * for������ x,y�� ����� ���� ����ϼ���*/
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








