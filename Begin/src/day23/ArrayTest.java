package day23;
/*(1)
 * ���ʹ� �÷��ǰ迭�� ����Ʈ �迭�� ���Ѵ�
�ڹ��Թ� 2�� ����
���� ���� arraylist*/

import java.util.*;
/*
 * ArrayList
 * -list�迭
 * -���� ���. ������ �ߺ��� ���
 * -vector�� ����. �������� ����ȭ�� �����Ǿ� ���� ����. ������ �ַ� ����
 * */
public class ArrayTest {

	public static void main(String[] args) {
			ArrayList<String> arrList= new ArrayList<>();
			arrList.add("Java");//�����Ҷ��� add
			arrList.add("C");//�����Ҷ��� add
			arrList.add("Python");//�����Ҷ��� add
			arrList.add("JavaScript");//�����Ҷ��� add
			arrList.add("Java");//�̰� ������ �ߺ��� �� ���� ���°����� ����
			
			String str= arrList.get(0);
			System.out.println(str);
			
			//Iterator<E> iterator() �� �̿��ؼ� arrlist�� ����� ���� ����غ���  ==>��ȯŸ���ε� ����Ʈ Ÿ���� ��ȯŸ���� �ִ�
			
			Iterator<String> it=arrList.iterator();
			while(it.hasNext()) {
				String s=it.next();
				System.out.println(s);
			}
	}


}
