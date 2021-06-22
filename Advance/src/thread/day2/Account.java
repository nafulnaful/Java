//6/11 2-1
package thread.day2;
/*wait()/notify() �޼ҵ带 �̿��ؼ�
 * �Ա�/��� ������ �����ϵ��� �غ���.
 * wait(), notify(), notifyAll()�޼ҵ�� ����ȭ �������� ȣ�� �����ϴ�.
 * */

public class Account {
	private int money=10;
	private boolean flag=false;//�������ϰ� �ϱ����ؼ� ���� �������ش�
	
	//synchronized�� ���̸� �ش� ��ü�� lock�� �־�߸� �޼ҵ带 ������ �� �ִ�.
	synchronized public void get(int val) {
		//�ι�° ������ true�� ���� ������ if���� �ɸ��� �ʴ´� �ؿ� �ɸ�
		//����° �������� �ؿ� �Ա��� �ϰ� �Ա� ������ false�� ����
		if(!flag) {//flag�� false���
			try {
				wait();
			//wait()�� ȣ���� �Ǹ� ������� ��������� �����ϰ� waiting pool�� ���� �����
			//�� �� ���� �ݳ��ϰ� �����·� ����.
			} catch (InterruptedException e) {
			}	
		}//if-----------------------------------
		
		if(money-val<0) {
			System.out.println("���� ����: ���� �ܾ�="+money+", ��û �ݾ�:"+val);
			flag=false;
			notify();
			return;
		}
		money-=val;
		System.out.println("��ݾ�: "+val+", ����� �ܾ�: "+money);
		flag=false;
		notify();
	}//get()-------------
	
	public void save(int val) {
	/////////////����ȭ ���� �κ�
	synchronized(this) {
		if(flag) {//�ѹ��ϰ� ���Ա��ҷ��� �ҰŴϱ� ���⼭ wait�ɾ���
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
			money+=val;
			System.out.println("�Աݾ�: "+val+", �Ա��� �ܾ�: "+money);
		
		flag=true;//��ݽ����带 �����ϰ� �ϱ�����
		notify();//waiting pool�� ��� ���� ������ �ϳ��� ���� runnable�� ���·�
		//��ȯ��Ŵ. notifyAll()=>��� ���� ������ ��θ� ����
		}//synch-------------
		
		
	}//save()-----------
}///////////////////////
