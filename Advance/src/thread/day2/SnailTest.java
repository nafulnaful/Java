//6/11[2]
package thread.day2;

public class SnailTest {

	public static void main(String[] args) {
		// [1] Runnable��ü �����ϱ�
		Snail r = new Snail();//�������� �ڵ� �κ��� ���� �ִ� ��ü
		// [2] Thread�� [1]�� ��ü�� ����
		Thread tr=new Thread(r);
		
		// [3] ������ ����
		tr.start();
	}

}
