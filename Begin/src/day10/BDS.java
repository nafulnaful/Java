package day10;
/*�ε��� ����
 * ==> ���õ� ��ü�� ����
 * 		��, �ŵ���, �ż���, �߰���, �Ӵ���, ������....
 * ==> ������ ��ü�� Ŭ������ �ű�� ��===> �߻�ȭ(Abstraction)
 * 				��ü�� �Ӽ�==> �������
 * 			    ���(�ൿ���)==> �޼ҵ��
 * */
public class BDS {

	public static void main(String[] args) {
		//Ŭ���� : ���赵. �ؾƲ (��ü�� ������ Ʋ)
		//��ü(Object) : Ŭ������ ���� ������� ����ü (��, �ؾ)
		House h1 = new House();//�޸� �� ������ �ö� ==> object, instance
		House h2 = new House();
		
		//��������ϱ�==> showInfo()
		h1.showInfo();
		h2.showInfo();
		
		h1.owner="ȫ�浿";
		h1.addr="���� �������� ����";
		h1.room=2;
		
		//h2
		h2.owner="��浿";
		h2.addr="��⵵ ����";
		h2.room=3;
		
		h1.showInfo();
		h2.showInfo();
		
		//h1�� 100����
		String a=h1.existAt(100);
		//h2  150����
		System.out.println(a);
		
		String b=h2.existAt(150);
		System.out.println(b);

	}

}








