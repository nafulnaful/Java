package day18;
//1) Handle�ϴ� ���: try ~ catch���� �̿��ϴ� ���
public class ExceptionTest {

	public static void main(String[] args) {

String fruits[]= {"���","��","����"};
try {
	for(int i=0;i<4;i++) {
		System.out.println(fruits[i]);
	}
}catch(ArrayIndexOutOfBoundsException e) {
	//���� ó�� �ڵ�
	System.out.println("�迭 �ε��� ���� �ʰ���. �����ϼ���~~");
}

System.out.println("###�ݵ�� ����Ǿ�� �� �ڵ�###");

	}

}
