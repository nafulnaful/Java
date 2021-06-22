//6/15[1]
package io.day2;
import java.io.*;
/*BufferedInputStream/BufferedOutputStream
 * - 1byte ��� ��Ʈ��
 * - ���ͽ�Ʈ��
 * - ��� : �����͵��� ���ۿ� ���� ���� ��Ƶξ��ٰ�
 *         ���۰� ���� ���� �Ѳ����� �о����
 * [�ǽ�] Ű����� �Է¹޾� �ֿܼ� �������
 * ��彺Ʈ��: System.in/System.out
 * ���ͽ�Ʈ��: BufferedInputStream/BufferedOutputStream
 * */
public class BIStream {

	public static void main(String[] args) 
	throws IOException{//������Ҷ��� �ݵ�� io�ͼ���������Ѵ�.

		BufferedInputStream bis
				=new BufferedInputStream(System.in);//in�ڿ� ,10�� �ϸ� ������ ũ�⸦ �ǹ��Ѵ�.
		BufferedOutputStream bos
				=new BufferedOutputStream(System.out);
		//�����ʹ� �޸� ���ۿ� �����ǰ� ���۰� �������� �Ѳ����� �о���̰ų�
		//����Ѵ�.
		int n=0, count=0;
		bos.write("�Է��ϼ���=>".getBytes());//���ڿ��� ������ ���� buffer�� �׷��� .getBytes()�� byte�迭�� ��ȯ������Ѵ�.
		bos.flush();//�о��(buffer�� ��Ҵٰ� �����µ� ���� ����ϴϱ� �ٷιٷ� �о�� ����� ��)
		while((n=bis.read())!=-1) {
			bos.write(n);
			bos.flush();
			count++;
		}
		bos.write((count+"bytes �а� ��").getBytes());
		
		bos.close();
		bis.close();
	}

}
