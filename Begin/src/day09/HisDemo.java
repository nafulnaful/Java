package day09;

public class HisDemo {
	public HisDemo() {
		
	}
	//반환타입이 있는 메소드==>메소드 블럭 끝에서 return문을 이용해서 반환타입에 맞는 값을 반환해야 한다.
	public static int giveMeDouble(int money) {
		System.out.println("투자금: "+money+"만원");	
		return money*2;
	}//-----------------------------------------
	
	public float giveME3Times(int money) {//byte로 받을 수는 없다.
		System.out.println("투자금: "+money+"만원");
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
		System.out.println(b+"만원");
		
		//[3] showUpper()
		//HisDemo su=new HisDemo(); 위에꺼 사용
		String c= mn.showUpper("hello world~~");
		System.out.println(c);
	}

}
