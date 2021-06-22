package day07;

public class Test428 {

	public static void main(String[] args) {
		String str="12345";
		int sum=0;
		
		for(int i=0; i<str.length(); i++) {
			int c = str.charAt(i) - 48;
			System.out.println("c=" + c);
			sum += str.charAt(i) - '0';
		}
		
		System.out.println("sum ="+sum);
	}

}
