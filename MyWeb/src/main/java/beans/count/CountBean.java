package beans.count;

//Java Beans
public class CountBean {
	
	private int count;//property => input name�� �����ϰ� �ִ� ���� ����
	
	public CountBean() {
		System.out.println("CountBean()������...");
	}
	
	public void setCount(int val) {
		count+=val;//����
		System.out.println("setCount()ȣ���..."+val);
	}
	
	public int getCount() {
		return count;
	}

}
