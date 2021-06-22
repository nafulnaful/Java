package io.day1;
import java.io.*;
/*DataOuptStream/DataInputStream
 * - 1byte��� ��Ʈ��
 * - ���� ��Ʈ�� (�����ͼҽ��� �����͸������� ���� ��� ���� ����)
 * - ���: �ڹ��� �پ��� �ڷ���(data type)���� byte������ �����ؼ� ����,
 * 		  ���ص� ����Ʈ�� �ٽ� �ڹ� �ڷ������� ������Ű�� ����� ����
 * ----------------------------------------------------------------
 *    [�ǽ�] �ڹ��� �ڷ������� ���� ����(Advance/data.txt)�� ����
 *       �̰��� �ٽ� �о� �ֿܼ� ����غ���.
 * */
public class DataOutTest {

	public static void main(String[] args) 
	throws IOException
	{
		String file="data.txt";
		DataOutputStream dos
		=new DataOutputStream(new FileOutputStream(file));//���ͽ�Ʈ���� �ٷ� ���� ����
		
		//�ڹ��� �پ��� �ڷ����� �����͸� data.txt���Ͽ� �Ẹ��.
		byte a=48;
		byte arr[]= {65,66,67};
		boolean bool=true;
		char ch='��';
		short sh=5000;
		int n=88;
		float ft=.456f;
		String str="ȫ�浿";
		
		dos.write(a);//1
		dos.write(arr,0,arr.length);//4
		dos.writeBoolean(bool);//5
		dos.writeChar(ch);//7
		dos.writeShort(sh);//9
		dos.writeInt(n);//13
		dos.writeFloat(ft);//17
		//dos.writeChars(str);//23//writeChars�� ���� ���� ����� ����
		dos.writeUTF(str);//28 -> �ѱ� 9 ����Ʈ�� ���� 2����Ʈ ����
		/*writeUTF() : �����ڵ��� utf-8 �������� ���ڿ��� ����ϴ� �޼ҵ�
	       *             utf������ �� ������ ǥ���� ���� 1����Ʈ ����ϴ���,
	       *             2����Ʈ ����ϴ��� �Ǵ� 3����Ʈ ����ϴ��� �˾Ƴ���
	       *          �ƽ�Ű ���ڴ� 1����Ʈ��, �׸�����,���긮��, �ƶ��� ���� 2����Ʈ��
	       *          �� �� ���ڴ� 3����Ʈ�� ǥ���ȴ�.
	       * */
		
		
		
		System.out.println(dos.size()+"bytes�� data.txt�� ��");//�ٸ��������� ����ϱ⶧���� �ݺ����� ���� �����Ƿ� size�� �˾ƺ� �� �ִ�.
		dos.flush();
		dos.close();
		
	}

}
