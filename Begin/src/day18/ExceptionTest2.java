package day18;
/*�߻��� ���ܸ� try~catch���� ó���ϵ�
 * for���� ���ʿ��� ���μ� ó���غ���*/
public class ExceptionTest2 {

	public static void main(String[] args) {

		try {
		for(int i=1;i<=5;i++) {
			
			int x= 50/(i-3);
			System.out.println("x: "+x);	
		
		}//for----
		}catch(ArithmeticException e) {
			System.out.println("���� ����! �и� 0�̾ �ȵſ�!!");}
		System.out.println("The End");

	}//main()----------

}//////////////////
