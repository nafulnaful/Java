package day07;

public class BreakContinue {

	public static void main(String[] args) {
		//결과가 어떻게 나올지 예측해보기
		System.out.println("1.-----------------");
		for(int i=0;i<3;i++) {
			if(i==1) break;//조건이 true면 for루프문을 벗어나라
			System.out.println("i="+i);//i=0
		}
		
		System.out.println("2.-----------------");
		for(int i=0;i<3;i++) {
			if(i==1) continue;//조건이 true면 아래 문장을 건너뛰고 계속 반복문을 수행하라
			System.out.println("i="+i);//i=0 i=2
		}
		System.out.println("3.--------------");
		for(int i=0;i<3;i++) {
			for(int k=0;k<3;k++) {
				if(k==1) break;//가장 가까운 반복문을 벗어남
				System.out.println("i="+i+", k="+k);
			}//for-
			
		}//for
		
		System.out.println("4.--------------");
		for(int i=0;i<3;i++) {
			for(int k=0;k<3;k++) {
				if(k==1) continue;//가장 가까운 반복문을 계속 수행함
				System.out.println("i="+i+", k="+k);
			}//for-
			
		}//for
		
		System.out.println("5.--------------");
		
		//반복문 앞에 label을 붙일 수 있다.
		//break, continue할때 label을 지정할 수 있다.
		outer:
		for(int i=0;i<3;i++) {
			inner:
			for(int k=0;k<3;k++) {
				if(k==1) break outer;//outer라벨에 가까운 반복문을 벗어남
				System.out.println("i="+i+", k="+k);
			}//for-
			
		}//for
		
		System.out.println("6.--------------");
		outer:
		for(int i=0;i<3;i++) {
			inner:
			for(int k=0;k<3;k++) {
				if(k==1) continue outer;//outer에 가까운 반복문을 계속 수행함
				System.out.println("i="+i+", k="+k); 
			}//for-
			
		}//for
		/*return문 : 특정 조건일 때 되돌아 간다.
		 * 			return문을 포함하고 있는 메소드를 호출한 쪽으로 돌아간다.
		 * 
		 * */
	}//main
}//class
