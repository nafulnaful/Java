package day24;
/*(4)
 * HashMap
 * -map�迭
 * -key�� value �����Ͽ� ����
 * -Hashtable�� ����. ������: �ؽ����� ����ȭ�� �����Ǿ� ���� �ʴ�.
 * -�ַ� ������ ���� ���
 * */
import java.util.*;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<Integer, Member> map=new HashMap<>();
		Member m1=new Member("ȫ�浿",19);
		Member m2=new Member("��ö��",21);
		map.put(1, m1);//1��ȸ���� m1
		map.put(new Integer(2), m2);
		
		Member user=map.get(2);
		System.out.println(user.name);
		
		if(map.containsKey(1))//map�� 1�� ȸ���� �ִ���
		{
		System.out.println(map.get(1).name);
		}
		Set<Integer> set=map.keySet();
		for(Integer key: set) {
			System.out.println(key+"=>"+map.get(key).name);
		}
		//map.values(); => value���� Collection�������� ��ȯ
	}

}
