package day13;
//�θ�Ŭ����: Superclass, Base class
public class Human {

	String name;
	int height;
	
	/*public Human() {//�⺻ �������̴�.
		this("�ƹ���",155);
	}*/
	
	//�����ڸ� 1���� �����ϸ� �����Ϸ��� �����ϴ� ����Ʈ �����ڴ� �������.
	//1���� �������� ������ ����Ʈ ������ �����ش�.
	public Human(String name, int height) {
		this.name = name;
		this.height = height;
	}
	
	public String showInfo() {
		String str="�̸�: "+name+"\n";
		str+="Ű : "+height+"\n";
		return str;
	}
}
