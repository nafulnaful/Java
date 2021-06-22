package day24;
/*(1)
 * Set�迭�� Ư¡
 * -������ ������� �ʴ´�.
 * -������ �ߺ��� ������� �ʴ´�.
 * -����Ŭ����
 * -HashSet
 * : �ؽ����� ��ü�� �����ϱ� ���� ��ü�� hashCode()�� ȣ���Ͽ� �ؽ��ڵ带 ����.
 *     �׸��� �̹� ����Ǿ� �ִ� ��ü���� �ؽ��ڵ�� ���Ѵ�. ���� ������ �ؽ��ڵ尡 
 *     �ִٸ� �״������� equals()�޼ҵ�� �� ��ü�� ���ؼ� true�� ������ ������
 *     ��ü�� �Ǵ��ϰ� �ߺ� ������ ���� �ʴ´�.
 *     */
import java.util.*;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<String> set=new HashSet<>();
		set.add("Java");
		set.add("Servlet");
		set.add("JSP");
		System.out.println("����� ��ü ��: "+set.size());
		set.add("Java");
		System.out.println("����� ��ü ��2" + set.size());
		
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String str=it.next();
			System.out.println(str);
		}
		
		for(String s:set) {//s�� ����� ������ ����
			System.out.println(s.toLowerCase());
		}
		
		
	}

}
