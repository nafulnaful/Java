package day08;//소문자 2단계 이상

public class ArrayEx {

	public static void main(String[] args) {
		
		//[5-6]
		int[] coinUnit = {500, 100, 50, 10};
		
		int money = 2680;
		System.out.println("money="+money);
		
		for(int i=0; i<coinUnit.length; i++) {
			if((money%coinUnit[i])==0) {
				System.out.println(coinUnit[i]+"원"+money/coinUnit[i]+"개");
			}else {
				System.out.println(coinUnit[i]+"원"+money/coinUnit[i]+"개");
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





