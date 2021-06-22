package day22;
import java.util.*;

public class VectorTest2 {

	public static void main(String[] args) {
		//[1] Person��ü�� 3�� �����ϱ�
		Person p1=new Person("ȫ�浿",22);
		Person p2=new Person("������",23);
		Person p3=new Person("�賲��",24);
		
		//[2] Person ��ü�� ������ Vector v�����ϱ�
		Vector<Person> v=new Vector<>();
		
		//[3] v�� Person��ü 3���� �����ϱ�
		v.add(p1);
		v.add(p2);
		v.add(p3);
		
		//[4] for���� �̿��ؼ� v�� ����� person�� �̸��� ���� ����ϱ�
		for(int i=0;i<v.size();i++) {
			Person p=v.get(i);
			System.out.println(p.getName()+": "+p.getAge()+"��");
		}
	
	//Enumeration<E> elements()
	//Iterator<E> iterator()
		/*
         * public Enumeration<E> elements()
         * public Iterator<E> iterator()
         * : Enumeration�̳� Iterator ���� ��ü���� ����ü�� �������ִ� �������̽��̴�.
         *   �̵� �������̽����� ������ ��ü���� �� ������ �ϳ��� ó���� �� �ִ� �޼ҵ带 �����Ѵ�.
         *   (���� Ŀ���� �����Ͽ� Ŀ���� �̵��ϸ鼭 �����͸� ������ �� �ִ�.)
         *   -���� Ŀ���� ù��° ��� ������ ��ġ�Ѵ�.
         *   1. Enumeration�� �ֿ� �޼ҵ�
         *      - boolean hasMoreElements(): ���� Ŀ���� ��ġ�ϴ� �� ���Ŀ� ��ҵ��� �ִ���
         *            ���θ� ���´�. ��ҵ��� ������ true�� ��ȯ�ϰ� ������ false�� ��ȯ�Ѵ�.
         *      - E  nextElement() : ���� Ŀ���� �������� �̵���Ű�� ����Ű�� �ִ� ������ ��Ҹ�
         *               ��ȯ�Ѵ�.
         *  2.  Iterator �ֿ� �޼ҵ�
         *     - boolean hasMext()
         *     - E next();  
         *    
         * */

	Enumeration<Person> en=v.elements();
	
	while(en.hasMoreElements()) {
		Person p=en.nextElement();
		System.out.println(p.getName()+"#"+p.getAge());
	}
	
	//iterator()�޼ҵ带 �̿��ؼ� v�� ���嵵�� ��ҵ��� �Ѳ����� ����غ���
	Iterator<Person> it=v.iterator();
	for(int i=1;it.hasNext();i++) {
		Person p=it.next();
		System.out.println(p.getName()+"@"+p.getAge());
	}
	//void copyInto(Object[] anArray)
	//:���Ϳ� ����� ������Ʈ���� �迭�� ī�����ش�.
	Person []arr=new Person[v.size()];
	v.copyInto(arr);
	
	//v�� ����� ��ü���� personŸ�� �迭�� ī���� ��
	//�ش� �迭�� Ȯ�� for���� �̿��ؼ� �̸��� ����غ�����
	for(Person per:arr) {
		System.out.println(per.getName());
	}
	
	
	}
	

}
