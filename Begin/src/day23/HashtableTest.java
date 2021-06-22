package day23;
/*(2)
 * Map�迭
 * Hashtable
 * -Object������ ������ �� �ִ�.
 * - key�� value���� �����Ͽ� �����Ѵ�.
 * - key���� �ߺ��� ������� �ʴ´�. value���� ���
 * - ������
 * - �����Ͱ� 75%���� �ڵ����� ���� ������ Ȯ���Ѵ�.(vector�� 100%)
 * - ������ ����: Object put(Object key, Object value)
 * - ������ ������: Object get(Object key)
 * */
import java.util.*;

public class HashtableTest {

	public static void main(String[] args) {//Dictionary(������)�����̴�
		Hashtable h=new Hashtable(20,0.8f); //�ʱ� �뷮 20/ 80%�� ���� �ڵ����� ���� Ȯ��
		h.put("�ϳ�", new Integer(1));
		h.put("��", 2); //auto boxing�� �Ǽ� integer(����)��ü�� ����ȴ�.
		h.put("����", "Red");
		h.put("�Ķ�", java.awt.Color.blue);
		
		//Generic�� �Ⱦ��� �Ʒ��� ����
		Object obj = h.get("��");
		Integer i=(Integer)obj; //Integer�� ����ȯ�ؾ��Ѵ�.(���� �˾ƺ���-������Ʈ �����̿���)
		System.out.println(i);
		
		/*String s=(String)h.get("�Ķ�");
		System.out.println(s);
		�̷��� ������ �� =>�߸��� ����ȯ*/
		
		//Generic��� <Key���� ����, Value���� ����>
		Hashtable<String, Integer> h2=new Hashtable<>();
		h2.put("����", 1999);
		h2.put("�뵷", new Integer(500000));//���� �̷��� �ؾ������� auto boxing�Ȱ�
		h2.put("����", 21);
		h2.put("����", 33);//key���� �ߺ����� �ʰ� ���� ���� ���� ���� 
		
		Integer age=h2.get("����");
		System.out.println("age: "+age);//Generic����ϸ� ����ȯ ���� �ʾƵ� �ȴ�.
		System.out.println("h2.size(): "+h2.size());//������ Ȯ���� ���°�
		
		//[�ǽ�1] Enumeration<K>	keys()
		//h2�� ����� key ���鸸 �����ؼ� ����غ���
		Enumeration<String> en=h2.keys();//Generic�� ���ִ�<> ��
		while(en.hasMoreElements()) {
			String key=en.nextElement();
			Integer val=h2.get(key);
			System.out.println(key+": "+ val);
		}
		
		
		//[�ǽ�2]Enumeration<V> elements()
		//h2�� ����� value���鸸 �����ؼ� ����غ���
		Enumeration<Integer> en2=h2.elements();
		for(i=1;en2.hasMoreElements();i++) {
			Integer val=en2.nextElement();
			System.out.println(i+": "+ val);
		}
		
		
		//[�ǽ�3]Set<K>    	keySet():key���� ����
		Set<String> set=h2.keySet();
		Iterator<String> it = set.iterator();
		for(;it.hasNext();) {
			String key=it.next();
			System.out.println(key);
		}
		
		//Set�� Ȯ�� for loop �� �� �ִ�
		for(String ky:set) {
			System.out.println(ky+"#");
		}
		
		//[�ǽ�4]Collection<V>	values():value���� ����
		Collection<Integer> col=h2.values();
		for(Integer val:col) {
			System.out.println(val+"@");
		}
	
	}

}////////////////////
