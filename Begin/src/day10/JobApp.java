package day10;
/*���α��� ���α׷�
 * - �߻�ȭ �ǽ�
 * 	1) ���õ� ��ü ����
 * 		- ������, ȸ��, �������...
 *  2) Ŭ������ �ű��
 *  	-�Ӽ� (3�� �̻�)
 *  	-�ൿ��� (2�� �̻�)
 *  3) JobApp�� main()�޼ҵ忡�� ��ü �����ؼ� �׽�Ʈ �غ���
 * */
public class JobApp {

	public static void main(String[] args) {
		//JobSeeker��ü 2�� ������ �ڿ� �Ӽ����� �ּ���
		JobSeeker j1=new JobSeeker();
		JobSeeker j2=new JobSeeker();
		JobSeeker j3=j2;
		
//		System.out.println(j1);
//		System.out.println(j2);
//		System.out.println(j3);
		
		j1.showProfile();
		
		j1.name="�豸��";
		j1.age=22;
		j1.tel="010-1111-2222";
		j1.showProfile();
		
		j2.name="���κ�";
		j2.age=23;
		j2.tel="010-3333-4444";
		j2.showProfile();
		
		//�������� ����غ�����
		String a=j1.wantJob("��������", 5000);
		System.out.println(a);
		
		//�������, ���� ����غ�
		System.out.println(j2.wantJob("���ΰ���", 1000));
		
		j3.showProfile();
		
		JobSeeker j4=new JobSeeker();
		j4.input();
		j4.showProfile();
		

	}

}
