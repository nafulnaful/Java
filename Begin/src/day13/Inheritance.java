package day13;

public class Inheritance {

	public static void main(String[] args) {
		
		Human h1=new Human("ȫ�浿",177);
		//h1.name="ȫ�浿";
		//h1.height=177;
		System.out.println(h1.showInfo());
		
		
		Superman s1=new Superman("�轴�۸�",188,500);
		System.out.println(s1.showInfo());
		

		Aquaman a1=new Aquaman("�ξ����",166,800);
		System.out.println(a1.showInfo());
		 
		System.out.println(s1.showInfo(200));
		
		System.out.println(s1.showInfo("##���۸� ����###"));
		
		//����, 300
		s1.showInfo("**���۸� info***",50);
		
		
		a1.showInfo("����Ƹ� ����");
	}

}
