//6/14[6]
package io.day1;
import java.io.*;
/*[�ǽ�]Ű����� �Է¹��� ���뤷�� ����(C:/MyJava/Workspace/Advance/Result/txt)�� �����ϴ� ���
 * ----------------------------------
 * ������ �ҽ� : Ű����=>��彺Ʈ��(System.in)
 * ������ ������ :���� =>��彺Ʈ��(FileOutputStream)
 * */
public class FOStreamTest {

	public static void main(String[] args) 
		throws IOException
		{
		String file="C:/MyJava/Workspace/Advance/Result.txt";
		FileOutputStream fos
		=new FileOutputStream(file, true);//?
		//ture���� �ָ� append����� ���´�. ���� ���� ���뿡 ���ο� ������ �����̱���
		
		System.out.println("���Ͽ� ������ ������ �Է��ϼ���=>");
		int n=0, cnt=0;
		//[�ǽ�1]�迭�� ��Ƽ� �а� ���Ͽ� �Ẹ��
		byte[] buf=new byte[100];
		
		while((n=System.in.read(buf))!=-1) {
			fos.write(buf,0,n);//���� ������ ��������
			fos.flush();//��Ʈ���� �����ִ� �����Ͱ� ������ �о�� ����
			cnt+=n;
		}
		System.out.println(cnt+"byte��");
		fos.close();//close�� �Ⱦ��� ���ϵ����Ͱ� �ȳѾ
		System.in.close();
	}
}


