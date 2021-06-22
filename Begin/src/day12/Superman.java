package day12;
/*������ �����ε�
 * -�����ڸ� �پ��ϰ� �����Ͽ� ��ü�� ������ �� �پ��� �ʱ���� �ο��ϵ��� �� �� �ִ�.*/
public class Superman {
	String name;
	int height;
	int power;
	
	//�⺻ ������ �����ϱ� - default constructor
	public Superman() {
		this("�ƹ������۸�",177,100);
		//this()�� �ڱ��ڽ��� �����ڸ� ȣ���� �� ����Ѵ�.
	}
	//�Ű����� name=> ��������
			//������� name=> �ν��Ͻ�����
			//���������� ���������� ������ �̸��� ���� ��� ���������� �켱����
			//�̷� �� ��������� �����ϱ� ���� ������� �տ��� this�� ���δ�.
			//this=> �ڱ��ڽ��� �ν��Ͻ��� ����Ű�� keyword
	public Superman(String name) {//���� ������(�Ű������� �޴� ������)
		this(name,166,200);
	}
	public Superman(String name, int height) {
		this(name,height,300);
	}
	public Superman(String name, int height, int power) {//target: ���⼭ �ʱ�ȭ�� ��(�ݵ�� �ϳ��� �־���Ѵ�)
		
		this.name=name;
		this.height=height;
		this.power=power;
	}
	
	public String showInfo() {
		String str="---���۸� ����---\n";
				str+="�̸�: "+name+"\n";
				str+="Ű: "+height+"\n";
				str+="�ʴɷ�: "+power+"\n";
				return str;
	}
}//////////////////////////////////
