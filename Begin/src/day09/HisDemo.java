package day09;

public class HisDemo {
	public HisDemo() {
		
	}
	//��ȯŸ���� �ִ� �޼ҵ�==>�޼ҵ� �� ������ return���� �̿��ؼ� ��ȯŸ�Կ� �´� ���� ��ȯ�ؾ� �Ѵ�.
	public static int giveMeDouble(int money) {
		System.out.println("���ڱ�: "+money+"����");	
		return money*2;
	}//-----------------------------------------
	
	public float giveME3Times(int money) {//byte�� ���� ���� ����.
		System.out.println("���ڱ�: "+money+"����");
		return money*3;
	}//-----------------------------------------
	public String showUpper(String msg) {
		return msg.toUpperCase();
	}
	
	public static void main(String[] args) {
		//giveMeDouble()
		int a=HisDemo.giveMeDouble(100);
		System.out.println(a);
		System.out.println(a+50);
		
		//giveMe3Times()
		HisDemo mn=new HisDemo();
		float b= mn.giveME3Times(500);
		System.out.println(b+"����");
		
		//[3] showUpper()
		//HisDemo su=new HisDemo(); ������ ���
		String c= mn.showUpper("hello world~~");
		System.out.println(c);
	}

}
