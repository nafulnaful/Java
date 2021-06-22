package day18;
/*���� ���� ���ܰ� �߻��� ���
 * try���� 1�� catch���� ���� �� �� �� �ִ�.
 * try{
 * }catch(A a){
 * }catch(B b){
 * }finally{
 * 		finally���� �ݵ�� �ѹ��� �����ϴ� ���̴�.
 * 		�տ� return���� �ִ��� �ݵ�� �����ϰ� ������� �ѱ��.
 * 		�� ���ܰ� �ִ�. �ý��� ���� �ڵ尡 �տ� ���� ��쿡�� ������� �ʴ´�.
 * }
 * �̶� ���� ����.
 * Exception�� �θ� �ڽ��� ��Ӱ��谡 ���� ���
 * �ڽĿ��ܸ� ���� catch�ϰ� �θ� ���ܸ� ���߿� catch�ؾ� �Ѵ�.*/
import javax.swing.*;
public class ExceptionTest4 {
	
	public static void main(String[] args) {
		try {
	String numStr=JOptionPane.showInputDialog("������ �Է��ϼ���");
	System.out.println("numStr: "+numStr);
	//���ڿ��� ������ ��ȯ�ϱ�
	int num = Integer.parseInt(numStr);
	
	int x=50/num;
	System.out.println("X: "+x);
	
	String str=null;
	System.out.println(str.toUpperCase());
	}catch(ArithmeticException e){
		System.out.println("���� 0���� ������ �ٸ� ������ �Է��ϼ���");
		System.exit(-1); //�ý��� ����
	}catch(NumberFormatException e){
		System.out.println("���� ���� �Է��ϼ���.");
		return;
	}catch(Exception e) {//�θ�- �ڽĺ��� ���߿� ��ƾ��Ѵ�.
		System.out.println("��Ÿ �� �� ���� ���� �߻�: "+e);
	}finally{
		System.out.println("---�ݵ�� �����ؾ� �� �ڵ�---");
	}
	System.out.println("The End");
	
}
}
