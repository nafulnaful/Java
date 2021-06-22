package day24;
/*(2)
 * -HashSet
 * : �ؽ����� ��ü�� �����ϱ� ���� ��ü�� hashCode()�� ȣ���Ͽ� �ؽ��ڵ带 ����.
 *     �׸��� �̹� ����Ǿ� �ִ� ��ü���� �ؽ��ڵ�� ���Ѵ�. ���� ������ �ؽ��ڵ尡 
 *     �ִٸ� �״������� equals()�޼ҵ�� �� ��ü�� ���ؼ� true�� ������ ������
 *     ��ü�� �Ǵ��ϰ� �ߺ� ������ ���� �ʴ´�.
 *     ObjectŬ������ �޼ҵ�
 *     - hashCode => �ּҰ�(int�� �޴´�)
 *     - equals() => �ּҰ� ��
 *     */

public class Member//extends Object
{

	String name;
	int age;
	public Member() {
		
	}
	public Member(String name, int age) {//�ؽ��¿� ������ ��
		this.name =name;
		this.age = age;
	}
	@Override
	public int hashCode() {//�̰ɷ� �ߺ� ����(1)->equals�� ���� ���ؾ���
		int code=name.hashCode()+age;
		return code;//hashCode���� ���� ���� ��
	}
	
	@Override
	public boolean equals(Object obj) {//�̰ɷ� �ߺ� ����(2)
		if(obj instanceof Member) {//��� ��ü�� �¾�? obj��?��� ��
			Member user=(Member) obj;
			boolean bool = (user.name.equals(this.name) && user.age ==this.age);
			return bool;
		}else {
			return false;
		}
	}
}/////////////////////////
