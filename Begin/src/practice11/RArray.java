package practice11;
import java.util.Scanner;
public class RArray {

	public static void main(String[] args) {
		//�迭(Array)
		/*����
		 * �޸� �Ҵ�
		 * �ʱ�ȭ
		 * */
		
		
		//1����
		int arr[];
		//2�޸� �Ҵ�
		arr=new int[3];
		//3�ʱ�ȭ
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		
		//1����+�޸��Ҵ�
		int brr[]=new int[3];
		brr[0]=1;
		brr[1]=2;
		brr[2]=3;
		
		//����� �غ���
		for(int i=0;i<brr.length;i++) {
			System.out.println(brr[i]);
		}
		//1����+2�޸��Ҵ�+3�ʱ�ȭ
		char crr[]= {'J','a','v','a','~'};
		
		for(int k=0;k<crr.length;k++){
			System.out.print(crr[k]);
		}
		
		/*[1] float������ ������ 1���� �迭�� �����ϰ� ũ��� 5�� �ֱ�
		������ ��: -16.1, 200.5, 55, 'Z', 3e+3
		 *    �׷� �� for���� �̿��� ����� ���� ����ϱ�
		 *    �� ������ �հ谪�� ����ϱ�
		 *    */
		float fl[]= {16.1F,200.5F,55,'Z',3e+3f};
		
		for(int v=0;v<fl.length;v++) {
			System.out.println(fl[v]);
		}
			/*[2] String������ ������ �迭 �����ϼ���.
			 * 	  ũ��� ������ ���� �����
			 * 	  �ݺ��� ������ ����ϵ�, ��� �빮�ڷ� �ٲ㼭 ����غ���
			 *      
			 * public String toUpperCase():��� �빮�ڷ� ��ȯ
			 * public String toLowerCase():��� �ҹ��ڷ� ��ȯ
			 * public char charAt(int i):�ε��� i��°�� ���ڸ� �Ѱ�  
			 * 							 �����ؼ� ��ȯ��.
			 * */
			
		String st[]= {"av","bv","cv","dv","ev"};
		
		for(int n=0;n<fl.length;n++) {
			System.out.println(st[n].toUpperCase());
			System.out.println(st[n].toLowerCase());
			System.out.println(st[n].charAt(1));
		}
		
		/*���� ���踦 �̿��ؼ� x,y�� ����� ���� ���� �ٲ� �ڿ� 
		 * for������ x,y�� ����� ���� ����ϼ���*/
		int x[]= {10,20,30};
		int y[]= {100,200,300};
		int tmp[] ; // X
		tmp=x;
		y=x;
		tmp=y;
		
		for(int m=0;m<tmp.length;m++) {
			System.out.println(x[m]);
			System.out.println(y[m]);
			
		}
		}//main--------------------
			
		

	}//class------------------------


