package day07;

public class MathTest2 {

	public static void main(String[] args) {
		//java.lang.Tath�� random()�޼ҵ� Ȱ��
		//public static double random(): 0.0<= r <1.0 ������ ������ �Ǽ��� ��ȯ
		
		//[1] 0<= r2 <10 ������ ������ ������ �߻����� ����ϱ�
		int r2=(int)(Math.random()*10);
		System.out.println(r2);
		
		//[2]5<= r3 ,15 ������ ������ ������ �߻����� ����ϱ�
		int r3=(int)(Math.random()*10+5);
		System.out.println(r3);

		/*int r=(int)(Math.random()*���� + ���۵Ǵ� ��)
		 * 
		 * 
		 * */
		
		//[3] 33<= r4 <65 ������ ������ �߻����� ���
		int r4=(int)(Math.random()*32 + 33);
		System.out.println(r4);
		
		//[4] ������ ���ĺ� �빮�ڸ� �Ʒ��� ���� ���·� ����ϼ���
		/*		F C D O K
		 * 		Z I M S W
		 * 		M Q R A K
		 * */
		
				for(int i=1;i<4;i++) {
					for(int k=1;k<6;k++) {
						char c=(char)((Math.random()*26 + 'A'));
						System.out.print(c+"\t");
										}
						System.out.println();
									}
	}

}
