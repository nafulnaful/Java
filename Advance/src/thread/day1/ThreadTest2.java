//[2]
package thread.day1;

//java.lang.ThreadŬ������ ��ӹ޾� �����ϴ� ���
//run()�޼ҵ带 �������̵� �Ѵ�.
class SnailThread extends Thread
{
	public SnailThread(String name) {//������ �̸� �������ִ� ��
		this.setName(name);
	}
	@Override
	public void run() {//�����尡 �� �۵��ϳ� �ݺ����� ���ؼ� ����ȭ
		for(int i=0;i<5;i++) {
			System.out.println(this.getName()+"�����尡 ���ϴ�.");
			/*try {
			Thread.sleep(1000);//delay�ִ� ��(1��)
			}catch(InterruptedException e) {// ����Ʈ������ throws�� �ϰ� �����ϱ� catch�ؼ� ����ִ� ��
				e.printStackTrace();
			}*///sleep�� �ָ� �켱������ �൵ �پ��ϰ� ���´�.
		}//for-----------
	}//run()----------------
	
}////////////////


public class ThreadTest2 {

	public static void main(String[] args) {//���۽�Ű�� ���� JVM�����̴�
		SnailThread tr1=new SnailThread("�ʶ��� ������");
		SnailThread tr2=new SnailThread("Ȧ���� ������");
		SnailThread tr3=new SnailThread("�׶��� ������");
		tr1.setPriority(Thread.MAX_PRIORITY); //10
		tr2.setPriority(Thread.NORM_PRIORITY); //5
		tr3.setPriority(Thread.MIN_PRIORITY); //1
		
		tr1.start();
		tr2.start();
		tr3.start();
		//tr2.interrupt();
		
		/*sleep()�̳� wait(), join() ���� ������ ��
		 * InterruptedException�� �߻���Ų��.*/
		
		//tr2.stop();
		/*stop()�� ������ ���� ���� ������ �߻���Ű�Ƿ� ������� ����.
		 * �����ϸ� ������� �ڿ������� �ϻ��� ��ġ���� ���α׷��� �ؾ� �Ѵ�.
		 * run() ������ ��ġ�� �״´�.
		 * */
		
		
		  //try {
	      //   tr2.join();
	      //   /*tr2 �����尡 �۾��� �� ��ĥ ������ tr2.join()�� ȣ���� ������(���⼭�� ���ν�����)
	      //    * �� block���°� �ȴ�*/
	      //}catch(InterruptedException e){
	      //   e.printStackTrace();
	      //}
		
	      Thread.yield();
	      /*�켱������ ���ų� ���� �����忡�Ը� �纸��.
	       * �ݸ� sleep()�� ���� �켱������ ������� ����
	       * */

		
		System.out.println("Hello World~~");
	}

}///////////////////////////////////
