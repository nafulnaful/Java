package day24;
/*(3)
 * hashset�� 2�� �α��� �����Ҷ� ���-member���� ���� ��*/
import java.util.*;

public class HashSetTest2 {

	public static void main(String[] args) {
		//[1] Member��ü 3�� �����ؼ� HashSet�� �����ϼ���
		Member m1=new Member("�����",23);
		Member m2=new Member("������",27);
		Member m3=new Member("�̿���",25);
		Member m4=new Member("�����",23);//�ߺ��� ��� Ȯ���ϱ� ���ؼ�
		Member m5=new Member("�̿���",33);
		
		
		HashSet<Member> set=new HashSet();
		set.add(m1);
		set.add(m2);
		set.add(m3);
		set.add(m4);
		set.add(m5);
		System.out.println(set.size()+"�� �����");
		
		
		//[2] iterator()�Ǵ� Ȯ�� for���� �̿��ؼ�
		//HashSet�� ����� ȸ������ �̸��� ���̸� ����ϼ���//get�� ����
		for(Member user:set) {
			//System.out.println(user.hashCode()+"#"+user+"#"+user.name);
			System.out.println(user.name+": "+user.age);
		}

	}

}
