package day07;

public class BreakContinue {

	public static void main(String[] args) {
		//����� ��� ������ �����غ���
		System.out.println("1.-----------------");
		for(int i=0;i<3;i++) {
			if(i==1) break;//������ true�� for�������� �����
			System.out.println("i="+i);//i=0
		}
		
		System.out.println("2.-----------------");
		for(int i=0;i<3;i++) {
			if(i==1) continue;//������ true�� �Ʒ� ������ �ǳʶٰ� ��� �ݺ����� �����϶�
			System.out.println("i="+i);//i=0 i=2
		}
		System.out.println("3.--------------");
		for(int i=0;i<3;i++) {
			for(int k=0;k<3;k++) {
				if(k==1) break;//���� ����� �ݺ����� ���
				System.out.println("i="+i+", k="+k);
			}//for-
			
		}//for
		
		System.out.println("4.--------------");
		for(int i=0;i<3;i++) {
			for(int k=0;k<3;k++) {
				if(k==1) continue;//���� ����� �ݺ����� ��� ������
				System.out.println("i="+i+", k="+k);
			}//for-
			
		}//for
		
		System.out.println("5.--------------");
		
		//�ݺ��� �տ� label�� ���� �� �ִ�.
		//break, continue�Ҷ� label�� ������ �� �ִ�.
		outer:
		for(int i=0;i<3;i++) {
			inner:
			for(int k=0;k<3;k++) {
				if(k==1) break outer;//outer�󺧿� ����� �ݺ����� ���
				System.out.println("i="+i+", k="+k);
			}//for-
			
		}//for
		
		System.out.println("6.--------------");
		outer:
		for(int i=0;i<3;i++) {
			inner:
			for(int k=0;k<3;k++) {
				if(k==1) continue outer;//outer�� ����� �ݺ����� ��� ������
				System.out.println("i="+i+", k="+k); 
			}//for-
			
		}//for
		/*return�� : Ư�� ������ �� �ǵ��� ����.
		 * 			return���� �����ϰ� �ִ� �޼ҵ带 ȣ���� ������ ���ư���.
		 * 
		 * */
	}//main
}//class
