package day10;
/*Ŭ����: ���赵, Ʋ
 * 1. �Ӽ� (property, attribute)=> ���, �ּ�, ������,.... ==> �������
 * 2. �ൿ���(behvior) : ���� ������ �����ִ�, �󸶿� ��Ʈ�ϴ�, ����ּҿ� ��ġ�ϴ�....==>�޼ҵ�
 * 
 * */
public class House {
	//1.�Ӽ�==>"has a"���踦 ����� �Ѵ�.
	int room;//House has a room
	String owner;
	String addr;
	
	//2. ���,�ൿ���
	public void showInfo() {
		System.out.println("---House ����----");
		System.out.println("������: "+owner);
		System.out.println("�� �� : "+room);
		System.out.println("�� �� : "+addr);//���� �������� ����
	}//-------------------
	public String existAt(int bunji) {
		String str=owner+"�� ��: "+addr+" "+bunji+"������ ��ġ�մϴ�";
		return str;
	}//-------------------
}////////////////////////////////////
