package day11;

public class SchoolApp {

	public static void main(String[] args) {
		//1. �л���ü 2�� �����ؼ� �й�,�̸�,�б� ���� �Ҵ��� showInfo() ȣ���ؼ� ����غ���
		Student s1=new Student();
		Student s2=new Student();
		
		s1.setNo(1);
		s1.setName("ȫ�浿");
		s1.setClassName("�̰�");
		
		s2.setNo(2);
		s2.setName("��⿵");
		s2.setClassName("����");
		
//		System.out.println(s1.getName());
		s1.showInfo();
		s2.showInfo();
	
		
		//2. ���簴ü 1�� ����, �ʱ�ȭ, ��� 
		Teacher t1=new Teacher();
		
		t1.setNo(10);
		t1.setName("�̰���");
		t1.setSubject("HTML");
		t1.showInfo();
		
		//3.���� ��ü 1�� �� �����ؼ� ���� ���
		Teacher t2=new Teacher();
		
		t2.setNo(15);
		t2.setName("�Ѽҿ�");
		t2.setSubject("JAVA");
		t2.showInfo();
		
		//4.���� 2���� ������ �迭�� �����ϰ� �޸��Ҵ� �� ��, t1, t2�� �迭�� �����ϼ���
		//int tea[];
		//tea=new int[2];
		//tea[0]=t1;
		//tea[1]=t2;
		Teacher arr[]=new Teacher[3];//teacher�� ���� student�ȵ� �迭�� ���� ������ ����
		arr[0]=t1;
		arr[1]=t2;
		arr[2]=new Teacher();
		arr[2].setNo(300);
		arr[2].setName("�̱���");
		arr[2].setSubject("c");
		
		//5.�ݺ��� ���鼭 �迭�� ����� ������� ������ �Ѳ����� ����غ���
		for(int i=0;i<arr.length;i++) {
			arr[i].showInfo();
		}
		
		//6. Student�迭 �����ؼ� s1,s2�����ϱ�
		Student atr[]= {s1,s2};
		/*Student atr[]=new Student[3];
		atr[0]=s1;
		atr[1]=s2;
		atr[2]=new Student();
		atr[2].setNo(3);
		atr[2].setName("��μ�");
		atr[2].setClassName("���̰�");*/
		
		//7. �ݺ��� �̿��ؼ� �л����� ����ϱ�
		for(int i=0;i<atr.length;i++) {
			atr[i].showInfo();
		}
	}//////

	private static void showInfo(Student sd) {
		// TODO Auto-generated method stub
		
	}

}
