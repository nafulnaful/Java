package day14;

public class Polymorphism {

	public static void main(String[] args) {
		//1. Human��ü �����ؼ� showInfo()
		Human h1=new Human("��ÿ�",165);
	System.out.println(h1.showInfo());
		//2. Superman
		Superman s1=new Superman("����ö",180,230);
		System.out.println(s1.showInfo());
		s1.showInfo("##���۸� ����###");
		
		//3. Aquaman
		Aquaman a1=new Aquaman("����",150,50.22);
		String info=a1.showInfo();
		System.out.println(info);
		
		//������
		/*�θ�� �ڽ��� ��Ӱ��踦 ���� ���
		 * �θ�Ÿ���� ������ �����ϰ� �ڽ��� ��ü�� �����ϴ� ���� �����ϴ�.
		 * �׷��� �� ���� ������ ������ �� �ִ� ������ ������ �ִ�.
		 * */
		Human hs = new Superman("�ּ���",188,700);
		System.out.println("hs.name="+hs.name);
		System.out.println("hs.height="+hs.height);
		//System.out.println("hs.power="+hs.power);[x]
		System.out.println("((Superman)hs).power="+((Superman)hs).power);
		System.out.println(hs.showInfo());
		
		Superman s2=(Superman)hs;//[1]
		s2.showInfo("@@@���۸� ����@@@");
		((Superman)hs).showInfo("@@@���۸� ����@@@");//[2]
		/*hs�� ������ �� �ִ� ����
		 * -�θ�� ���� �������� ������ �޼ҵ�� ���� �����ϴ�.
		 * - �ڽ��� ������ �ִ� ������ ������ �޼ҵ�� �θ�Ÿ������ ���� �Ұ�
		 * -�׷��� �ڽ�Ŭ�������� �������̵��� �޼ҵ尡 ���� ��쿡��
		 * �׿������̵��� �޼ҵ带 �켱 ȣ���Ѵ�.
		 * */
		
		
		
		
		
		//HumanŸ������ ���� �����ϰ� Aquaman��ü �����ϱ�
		//�̸�, Ű, ���ǵ�
		//showInfo()ȣ���غ���
		
		Human ha=new Aquaman("�ּ���",180,220);
		System.out.println("ha.name="+ha.name);
		System.out.println("ha.height="+ha.height);
		System.out.println("((Aquaman)ha).speed="+((Aquaman)ha).speed);//�θ� �ڽ� ��Ӱ��迡 ���� �� ����ȯ ����
		System.out.println(ha.showInfo());//override�� ���� �켱������ ������ ������ ���ǵ� ����
	}

}
