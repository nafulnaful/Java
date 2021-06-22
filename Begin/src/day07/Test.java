package day07;
import java.util.Scanner;
public class Test {

	public static void main(String[] args) {
		System.out.println("별의 개수를 입력하세요.=>");
		Scanner sc=new Scanner(System.in);
		int star = sc.nextInt();
		for(int i=1;i<= star*2-1; i++) {
			int cnt=(i<=star)? i: 2*star-i;
			/*if(i<=star) {
				cnt=i;
			}else {
				cnt=star*2-i;}*/
			for(int k=1;k<=cnt;k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
