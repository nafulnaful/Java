package day12;

public class Overloading {

	
	public static void main(String[] args) {
		Superman s1=new Superman();
		Aquaman a1=new Aquaman();
		
		Superman s2=new Superman("ȫ���۸�");
		//s2.setName("ȫ���۸�")
		
		
		String info=s1.showInfo();
		System.out.println(info);
		System.out.println(s2.showInfo());
		
		Superman s3=new Superman("�轴�۸�",188);
		System.out.println(s3.showInfo());
		
		//�̸�, Ű, �ʴɷ�
		Superman s4=new Superman("�ڽ��۸�",190,300);
		System.out.println(s4.showInfo());
		
		
		Aquaman a2=new Aquaman("������");
		
		System.out.println(a1.showInfo());
		
		//���۸ǰ�ü 4���� ������ �迭�� �����ϰ� �ʱ�ȭ�ϱ�
		//for���� �̿��ؼ� ���۸ǵ��� ��� ���� ����ϱ�
		Superman arr[]= {s1,s2,s3,s4};
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i].showInfo());
		}
		//[2] ����Ƹǵ� �迭�� ������ �ݺ��� �̿��� ����ϱ�
		Aquaman arr2[]=new Aquaman[2];
				arr2[0]=a1;
				arr2[1]=a2;
				
		for(int i=0;i<arr2.length;i++) {
			System.out.println(arr2[i].showInfo());
		}
		//Ȯ�� forloop
		int []x= {1,2,3,4};
		/*for(��������: �ڷᱸ��)
		 * {
		 * 
		 * }
		 * */
		for(int num:x) {
			System.out.println("num: "+num);
		}
		//Ȯ�� forloop �̿��ؼ� arr�� ����� ���۸ǵ��� �̸��� ����ϼ���.
	
		for(Superman s:arr) {
			System.out.println(s.name);
		}
	}

}
