package day09;
//������ �����ϱ�
public class MyVar {
	
		   String str;//null��
	static double PI;
	
	static {
		//static initializer�� �޸𸮿� ���� ���� �ö󰣴�. main()���ٵ� ���� �ö󰣴�.
		PI=3.14;
		System.out.println("---static �� ȣ���---");
	}
	
	public MyVar() {
		str="�ȳ� MyVar~";
	}
	public static void main(String[] args) {
		System.out.println("---main()�޼ҵ�-----------");
		//[1] MyVar�� str���� ���� ����ϱ�
		MyVar mv=new MyVar();
		System.out.println("mv.str="+mv.str);//static�� �Ⱥ����� ��ü �������ְ� �θ� ���� ��ü ���·�
		
		//[2] PI�� ����ϱ�
		System.out.println(MyVar.PI);//�̰� ��ü�� �ƴѰ�?
		
		//[3] MyVar�� str���� ���� �����غ���
		mv.str="�߰� MyVar~";
		System.out.println("mv.str="+mv.str);
		
		MyVar mv2=new MyVar();
		System.out.println("mv2.str: "+mv2.str);
		System.out.println("mv.str="+mv.str);

		mv.PI=500;
		System.out.println("mv.PI: "+mv.PI);
		System.out.println("mv2.PI: "+mv2.PI);
		//static������ ��ü�鸶�� �����Ѵ�. ���� �ٸ� ��ü���� ���� �����ϸ�, ��� ��ü�� �� ����� ����
		//����ϰ� �ȴ�.
		System.out.println("MyVar.PI: "+MyVar.PI);
	}

}
