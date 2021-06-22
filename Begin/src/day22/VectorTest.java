package day22;
import java.util.*;

public class VectorTest {

	public static void main(String[] args) {
		Vector v=new Vector(5,3);//�ʱ�뷮:5 ����ġ:3
		System.out.println("v.capacity(): "+v.capacity());//�뷮
		System.out.println("v.size(): "+v.size());
		//���Ϳ� ������ ������Ʈ ��
		
		v.add("Hello");
		v.add(new Object());
		v.add(10);//10���� integer��ü�� ���� auto boxing
		v.add(new Integer(200));
		//vector�� object�����鸸 ���� ����

		System.out.println("v.capacity()2: "+v.capacity());
		System.out.println("v.size()2: "+v.size());
		
		for(int i=1;i<9;i++) {
			v.add("Hi "+i);
		}
		
		System.out.println("v.capacity()3: "+v.capacity());
		System.out.println("v.size()3: "+v.size());
		//������ ������
		//object get(int index)
		//object elementsAt(int index)
		
		Object o1=v.get(0);
		System.out.println(((String)o1).toUpperCase());
	
		Object o2=v.get(2);
		Integer str=(Integer)o2;
		System.out.println(o2);
		System.out.println(Integer.toBinaryString(str));

		System.out.println("*************************");
		//java5.0���� => Generic�� �̿��� ���͸� ����
		//Vector<String> v2=new vector<String>(10,5);
		//v2���� String ������ �����ϰڴٴ� �ǹ�
		Vector<String> v2=new Vector<>(10,5);
		for(int i=1;i<6;i++) {
			v2.add("Java "+i);
		}
		v2.add(String.valueOf(10));
		
		String s1=v2.get(0);
		
		/*[����1] v2�� for������ �̿��ؼ� v2�� ����� ���� �Ѳ����� ���*/
		for(int i=0; i<v2.size();i++) {
			String s=v2.get(i);
			System.out.println(s);
		}
		//Ȯ�� for������ �����غ���
		
		/*[����2] Float������ ������ ���� v3�� �����ϰ� ��ü 3���̻� ����
		 * �׷��� for���� �̿��ؼ� ���� �հ踦 ���ϰ� ��հ��� ���ϼ���*/
		Vector<Float> v3=new Vector<>();
		v3.add(new Float(3.14));
		v3.add(Float.valueOf(2.78f));
		v3.add(Float.valueOf(15));
		//�⺻�ڷ��� ==>Wrapper class�������� auto boxing
		//Wrapper class==> �⺻�ڷ������� auto unboxing
		float sum=0.0f;
		for(int i=0;i<v3.size();i++) {
			Float f=v3.get(i);
			System.out.println(f);
			sum+=f;
		}
		System.out.println("sum :"+sum);
		System.out.println("avg: "+sum/v3.size());
		
		int[]arr= {1,2,3};
		for(int a : arr) {
			System.out.println(a);
		}
		
	//v2 Ȯ�� for���� �̿�
		for(String b:v2) {
			System.out.println(b.toLowerCase());
		}
	//v3 
		for(Float c:v3) {
			System.out.println(c);
		}
	}
	

}
