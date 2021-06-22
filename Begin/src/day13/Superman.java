package day13;
//Ŭ������ ��ӹ��� ���� extends��� Ű���带 �̿��Ѵ�.
//�ڽ�Ŭ����: Sub class, Derived class
//��� ����: "is a"���谡 �����Ǿ�� �Ѵ�.
//��� class���� �⺻������ java.lang.Object�� ��ӹް� �ִ�.
//�θ��ڽ� ���谡 ���� ��� �ڽ� Ŭ������ ������ �ȿ����� ����������
//super()�� ȣ���Ѵ�.
//super()==> �θ��� �⺻�����ڸ� ȣ��
public class Superman extends Human {
	//Superman is a Human
	int power;
	
	public Superman() {
		super("���۸�",168);
		//�ڽ� Ŭ������ �����ڿ����� ���������� super()ȣ���Ѵ�.
		//���� �θ� ����Ʈ �����ڰ� ���ٸ� ������ ���Ƿ�
		//��������� super(����)�� �̿��ؼ� �θ� �����ڸ� ȣ���ϵ��� �Ѵ�.
		//�ݵ�� �������� ù��° ���ο� ��ġ�ؾ� �Ѵ�.
	}
	public Superman(String name, int height, int power) {
		super(name, height);
		//this.name=name;
		//this.height=height;
		this.power=power;
	}
	/*�޼ҵ� �������̵�(Overriding):
	 * �θ��� �޼ҵ带 �ٽ� �����ؼ� �����ϴ� ��
	 *   - ��Ģ
     *     1) �޼ҵ� �̸��� �θ��� �Ͱ� �����ϰ� �����Ѵ�.
     *     2) �Ű������� ������ Ÿ�԰� ����, ������ �θ��� �Ͱ� ���� �����Ѵ�.
     *     3) ��ȯŸ�Ե� ���ƾ� �Ѵ�.
     *     4) ���� �����ڴ� �θ��� �Ͱ� �����ϰų� �� ���� ������ �����Ѵ�.
     *     5) ���ܴ� �θ��� �Ͱ� �����ϰų� �� ��ü���� ���ܸ� �߻���Ų��.*/
	
	//1�� �θ� ó�� �����ؾ���
	@Override
	public String showInfo() {
		//String str="�̸� : "+name+"\n";
		//		str+="Ű : "+height+"\n";
		String str=super.showInfo();//�̸�, Ű
			str+="�ʴɷ� : "+power+"\n";
				return str;
	}
	public String showInfo(String title) {
		String str=title+"\n";
		str+=this.showInfo();//�̸�, Ű, �ʴɷ�(���� �ִ� this�� �޴°�)
		//str+="�̸� : "+name+"\n";
		//str+="Ű : "+height+"\n";
		//str+="�ʴɷ� : "+power+"\n";
		return str;
	}
	//showInfo()�����ε� 1�� �� �غ���
	public String showInfo(int pw) {
		this.power+=pw;
		//String str="�̸� : "+name+"\n";
		//str+="Ű : "+height+"\n";
		String str=super.showInfo();//�̸�, Ű
		str+=">>�ʴɷ� ����<<\n";
		str+="�ʴɷ� : "+power+"\n";
		return str;
	}
	public void showInfo(String title, int pw) {
		String str=this.showInfo(title);
		power+=pw;
		str+=">>�ʴɷ� ����<<<<";
		str+="�ʴɷ�: "+power;
		System.out.println(str);
	}
	
}///////////////////////////
