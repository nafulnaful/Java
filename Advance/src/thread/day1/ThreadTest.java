//[1]
package thread.day1;
/*main()����                  main()����
 * |---------------------------------|
 * 
 * |---thread���� -------->|          |main()
 * |---------thread����-------------- |main()---------->|thread����
 * 
 * 
 * */

public class ThreadTest {

	public static void main(String[] args) {
		System.out.println("Hello World~~");
		//[1]���� ���� ���� �����带 �˾ƺ���.
		Thread tr=Thread.currentThread();//currentThread�� �۵����� �����带 �����ش�.
		System.out.println(tr.getName()+"�����尡 ���� �� �Դϴ�..");
		
		int cnt=Thread.activeCount();//activeCount�� �۵����� �������� ������ �����ش�.
		System.out.println("���� ���� ���� ������ ����: "+cnt);
		
		Thread.currentThread().setName("Happy Thread");//������ �̸� ����
		System.out.println(Thread.currentThread().getName());//����� �̸� ȣ��
	}

}
