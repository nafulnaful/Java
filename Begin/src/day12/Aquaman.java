package day12;

public class Aquaman {

	String name;
	int height;
	double speed;
	//this() �̿��ؼ� �ʱ�ȭ
	public Aquaman() {
		this("�������",150,200);
		/*name="������";
		height=150;
		speed=200;*/
	}
	
	public Aquaman(String name) {
		this(name,250,220);
	}
	
	public Aquaman(String name, int height) {
		this(name,height,220);
	}
	
	public Aquaman(String name, int height, int speed) {
		this.name=name;
		this.height=height;
		this.speed=speed;
	}
	
	public String showInfo() {
		String str="---����Ƹ� ����---\n";
				str+="�̸�: "+name+"\n";
				str+="Ű: "+height+"\n";
				str+="���ǵ�: "+speed+"\n";
			return str;
	}
}
