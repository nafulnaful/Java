package day08;//�ҹ��� 2�ܰ� �̻�

public class ArrayEx {

	public static void main(String[] args) {
		
		//[5-6]
		int[] coinUnit = {500, 100, 50, 10};
		
		int money = 2680;
		System.out.println("money="+money);
		
		for(int i=0; i<coinUnit.length; i++) {
			if((money%coinUnit[i])==0) {
				System.out.println(coinUnit[i]+"��"+money/coinUnit[i]+"��");
			}else {
				System.out.println(coinUnit[i]+"��"+money/coinUnit[i]+"��");
				money=money%coinUnit[i];	
			}
		}
		
		//[ex]
		int[][] arr=new int[5][5];
		arr[0][0]=1;
		
		for(int i=0;i<arr.length;i++) {
			for(int k=0;k<arr[i].length;k++) {
				
				System.out.print(arr[i][k]);
				
			}
			
			System.out.println();
			
		}
		

	}

}





