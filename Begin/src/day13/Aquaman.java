package day13;
//Human��� ���� �� speed�߰�, ������ 2�� �����ε��ϱ�
public class Aquaman extends Human {
	
	double speed;

	public Aquaman() {
		//super("�ξ����",192);
		//this.speed(123.12);
		this("�ξ����",192,123.12);
	}
	
	public Aquaman(String name, int height, double speed) {
		super(name, height);
		//this.name="��ٴ�";
		//this.height=185;
		this.speed= speed;
	}
	
	//showInfo()�������̵� �ϼ���
	//@Override => annotation�� �ٿ��ָ�, ������ Ÿ�ӿ� �ش� �޼ҵ尡
	//override ��Ģ�� �´��� üũ�ؼ� ����� ��� ������ �߻���Ŵ
	@Override
	public String showInfo() {
		//String str="�̸� : "+name+"\n";
		//		str+="Ű : "+height+"\n";
		String str=super.showInfo();
				str+="���ǵ� : "+speed+"\n";
				return str;
	}
	
	//showInfo() �����ε��ϱ�
	public String showInfo(String title) {
		String str=title+"\n";
		str+=this+showInfo();
		return str;	
	}
	
	
}////////////////////////
