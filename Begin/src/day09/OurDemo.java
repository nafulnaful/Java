package day09;
/*3. �޼ҵ�(method):��� �� ����� ������ �ִ� ��
 * 			(1) non-static �޼ҵ� : �ν��Ͻ� �޼ҵ� ==>"��ü��.�޼ҵ��()"   ex)sc.nextInt()
 * 			(2) static �޼ҵ� : Ŭ���� �޼ҵ�	   ==>"Ŭ������.�޼ҵ��()" ex)Math.random()
 * 		-�����ϴ� ���
 * 			����������(access modifier) [static(modifier)] ��ȯŸ�� �޼ҵ��([�Ű�����1,....])
 * 			{
 * 				��� ����
 * 			}
 * 			
 * 		-ȣ���ϴ� ���(�����)
 * */
public class OurDemo {
	
	public OurDemo() {//������
		
	}
	//����� ���� �޼ҵ�
	public void sayHello(String name) {//�ν��Ͻ� �޼ҵ�
		System.out.println("Hello ~~"+name+"��!!");
	}
	public static void sayHi(String name) {//Ŭ���� �޼ҵ�
		System.out.println("Hi ~~"+name+"~~");
	}
	
	public void showStar() {
		System.out.println("�ڡڡڡڡ�");
	}
	public static void showSharp() {
		System.out.println("######");
	}
	public void showSnail(int row, int col) {
		//�Ű������� �޾Ƶ��̴� �޼ҵ�
		for(int i=0;i<row;i++) {
			for(int k=0;k<col;k++) {
				System.out.print("@");
			}//for
			System.out.println();
		}//for
		
	}
	/////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {//�޼ҵ�
	OurDemo.sayHi("�����");
	OurDemo.sayHi("Tom");
	
	OurDemo od=new OurDemo();
	od.sayHello("��ö��");
	od.sayHello("Susan");
	
	//showStar()
	OurDemo od2=new OurDemo();
	od2.showStar();
	od.showStar();
	
	//ShowSharp()
	OurDemo.showSharp();
	
	//showSnail()
	OurDemo od3=new OurDemo();
	od3.showSnail(5,7);

	}

}
