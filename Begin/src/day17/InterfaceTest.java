package day17;

interface MyInter{
	void foo();//public abstract�� �ڵ����� �ٴ´�.
}////////////////
interface YourInter{
	String STR="HI INTERFACE";//����ϱ�
	//public static final�� �ڵ����� �ٴ´�.
	String bar();
	
}
/*�������̽��� ��ӹ��� ���� implements�� ��ӹ�����,
 * ���� ���� �������̽��� ��ӹ��� �� �ִ�.(���߻��)*/
class MyClass implements MyInter , YourInter{//concrete class(����� ������ Ŭ����)
	public void foo() {
		System.out.println("foo()~~~~~");
	}
	public String bar() {
		return "bar()##";//��ȯŸ���̴ϱ� ���ڶ� ��ȯ�ؾ��Ѵ�.
	}
}

public class InterfaceTest {

	public static void main(String[] args) {
		//MyInter mi=new Myinter();
		MyInter mi=new MyClass();
		mi.foo();
		String str=((YourInter)mi).bar();
		//bar()=>YourInter�� ��. MyInter�������δ� ���� �Ұ�
		System.out.println(str);
		
		MyClass mc=new MyClass();
		mc.foo();
		System.out.println(mc.bar());
		
		//YourInterŸ���� ������ �����ϰ� MyClass��ü�� ������ �Ŀ�
		//foo(), bar(), STR �� ����ϱ�
		YourInter yi = new MyClass();
		((MyInter)yi).foo();
		System.out.println(yi.bar());
		System.out.println(MyClass.STR);
		System.out.println(YourInter.STR);
	}

}
