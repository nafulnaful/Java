	 package day08;
	/* �迭(Array)
	 * - ���� ������ �����͵��� ����
	 * - ���� ũ��. �ش� ũ�� �������� ������ ���� ����
	 * - ������ �Ѿ�� ������
	 * - ������
	 * 
	 * */
	public class ArrayTest {
	
		public static void main(String[] args) {
			//�迭�� �����ϴ� ���
		/* 1)����
		 * 2)�޸��Ҵ�
		 * 3)�ʱ�ȭ
		 * */
		System.out.println("1.----------------------");
		int arr[]; //1���� �迭����
		//int [] arr; ����
		
		//2.�޸��Ҵ�
		arr = new int[3];
		
		//3.�ʱ�ȭ
		//index�� 0���� (�迭�� ũ�� -1)����
		arr[0]=10; // <-- ù��° �迭�� 10
		arr[1]=20; // <-- �ι�° �迭�� 20 
		arr[2]=30; // <-- ����° �迭�� 30
		
		System.out.println("arr[0]="+arr[0]); // ù��° �迭�� ���� ���
		System.out.println("arr[1]="+arr[1]); // �ι�° �迭�� ���� ���
		System.out.println("arr[2]="+arr[2]); // ����° �迭�� ���� ���
		//System.out.println("arr[3]="+arr[3]); [x]
		System.out.println("2.--------------------");
		
		//1.���� +2.�޸��Ҵ�, 3.�ʱ�ȭ
		double brr[]=new double[4];
		System.out.println("brr[0]="+brr[0]); //0.0
		System.out.println("brr[3]="+brr[3]); //0.0
		
		brr[0]=100.45;
		brr[1]=0x12; //16����=18.0
		brr[2]='A';
		brr[3]=450e-2; //4.5
		
		//�迭�� ũ��: length�Ӽ��� �̿��ϸ� ũ�⸦ �� �� �ִ�.
		System.out.println("brr.length="+brr.length);
		System.out.println("arr.length="+arr.length);
		//brr�� ����� ���� for���� �̿��ؼ� �Ѳ����� ����غ�����
		for(int i=0;i<brr.length;i++) {
			System.out.println(brr[i]);	
		}
		System.out.println("3.-----------------------");
		//1+2+3 ����� ���ÿ� �޸� �Ҵ� �� �ʱ�ȭ
		char ch[]= {'J','a','v','a','~'}; //1byte
		System.out.println("ch.length="+ch.length);
		
		//for���� �̿��ؼ� ch�� ����� �� ���
		for(int i=0;i<ch.length;i++) {
			System.out.print(ch[i]);
		}
		System.out.println();
		
		String[] str=new String[2];
		//str[0]
		System.out.println(str[0]);
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("���ڿ� �Է��ϼ���1=>");
		str[0]=sc.next();
		System.out.println("���ڿ� �Է��ϼ���2=>");
		str[1]=sc.next();
		//�� �Է��� �� ����x next�� ���� �������� �Էµ�.
		
		//str�� ����� ���� for���� �̿��ؼ� ����ϼ���
		for(int i=0;i<str.length;i++) {
			System.out.println(str[i]);
		}
		
		/*[1] float������ ������ 1���� �迭�� �����ϰ� ũ��� 5�� �ֱ�
		 *    ������ ��: -16.1, 200.5, 55, 'Z', 3e+3
		 *    �׷� �� for���� �̿��� ����� ���� ����ϱ�
		 *    �� ������ �հ谪�� ����ϱ�
		 *    */
		float flt[] = {-16.1F, 200.5F, 55, 'Z', 3E+3F};
		/*
		flt[0]=-16.1F;
		flt[1]=200.5F;
		flt[2]=55;
		flt[3]='Z';
		flt[4]=3e+3F;
		*/
		
		float sum=0;
		for(int i=0;i<flt.length;i++) {
			System.out.println(flt[i]);
			sum+=flt[i];
		}
		System.out.println("sum="+sum);
		System.out.println("avg="+(sum/flt.length));
		
		/*[2] String������ ������ �迭 �����ϼ���.
		 * 	  ũ��� ������ ���� �����
		 * 	  �ݺ��� ������ ����ϵ�, ��� �빮�ڷ� �ٲ㼭 ����غ���
		 *      
		 * public String toUpperCase():��� �빮�ڷ� ��ȯ
		 * public String toLowerCase():��� �ҹ��ڷ� ��ȯ
		 * public char charAt(int i):�ε��� i��°�� ���ڸ� �Ѱ�  
		 * 							 �����ؼ� ��ȯ��.
		 * 
		 * */
		String[] srr=new String[4];
		srr[0]="Hello!";
		srr[1]=new String("Java ");
		srr[2]="new ";
		srr[3]="string";
		
		for(int i=0;i<srr.length;i++) {
			System.out.print(srr[i].toUpperCase());
			System.out.println(srr[i].toLowerCase());
			System.out.println(srr[i].charAt(0));
		}
		//static String valueOf(int i)	
		int n=256;
		System.out.println(n*2);
		//n�� ���ڿ��� ��ȯ
		String s=n+"";
			System.out.println(s+0);
			
			String s2=String.valueOf(n);
			System.out.println(s2+0);
			
		
			
			
			
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
