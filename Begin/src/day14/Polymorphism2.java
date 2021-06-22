package day14;

public class Polymorphism2 {

	public static void main(String[] args) {
	//�Ʒ� ����� �����غ���
		System.out.println("1.------------------");
		Super sp=new Super();
		System.out.println("sp.a: "+sp.a);//10
		System.out.println("sp.b: "+sp.b);//20
		sp.foo();//foo()**********
		
		System.out.println("2.-------------------");
		Sub sb=new Sub();
		System.out.println("sb.a: "+sb.a);//10
		System.out.println("sb.b: "+sb.b);//30
		System.out.println("sb.c: "+sb.c);//40
		sb.foo();//"foo()###"
		
		System.out.println("3.-------------------");
		Super ss=new Sub();
		System.out.println("ss.a: "+ss.a);//10
		System.out.println("ss.b: "+ss.b);//20
		//System.out.println("ss.c: "+ss.c);
		ss.foo();//"foo()###" override�� �޼ҵ尡 �ִٸ� override�� ����
		
		//�迭: ������ �����͸� ���� ����(�θ�, �ڽ��� ������ �����ͷ� ���ֵȴ�.)
		Super[] arr=new Super[3];
		arr[0]=sp;
		arr[1]=sb;
		arr[2]=ss;
		System.out.println("4.-----------------------------------");
		//�ݺ��� ���鼭 arr�� ����� ��ü ���� foo() ȣ���غ���
		for(int i=0;i<arr.length;i++) {
		System.out.println("a: "+arr[i].a);	
		System.out.println("b: "+arr[i].b);//�迭�� SuperŸ������ �޾����ϱ�  subŸ�Ե� super�� ����	
		/*instanceof ������
		 * �������� instanceof Ŭ������ : ������ Ŭ������ ��ü�� true,�ƴϸ� false��
		 * ��ȯ�ϴ� ������
		 * */
		if(arr[i] instanceof Sub) {
		System.out.println("c: "+((Sub)arr[i]).c);
		}
		arr[i].foo();
		}
		
	}//superŸ�������� subŸ�Կ� �� �ִ� ����

}//////////////////////////
//����������. public> protected > ������ > private
class Super{//�θ� Ŭ����
	int a=10;
	int b=20;
	
	void foo() {//������ ����������
		System.out.println("foo()**********");
	}
	
}////////////////

class Sub extends Super{//�ڽ� Ŭ����
	int b=30;
	int c=40;
	
	@Override
	protected void foo() {//���ٹ����� ���ų� Ŀ���Ѵ�
		System.out.println("foo()###");
	}
	
}/////////////////////