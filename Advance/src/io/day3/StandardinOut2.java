//6/16[5]
package io.day3;
import java.io.*;
/*Ű���� �Է�==> �ֿܼ� ���
 * BufferedReader/PrintWriter
 * - 2byte���
 * - ���� ��Ʈ��
 * - ���ۿ� ��Ƽ� �а�/����
 * - int read()
 * - String readLine()
 * ------------------------------
 * ������ �ҽ�	 : Ű����==>��彺Ʈ��(System.in)
 * ������ ������: �ܼ� 	==>��彺Ʈ��(System.out)
 * */
public class StandardinOut2 {

	public static void main(String[] args)
	throws Exception{
		BufferedReader br
		=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader�� �����ڿ� Reader�迭�� ��ü�� �޾Ƶ��δ�.
	    //���� 1����Ʈ��� ��Ʈ���� �����ؾ� �� ���� �긴�� ��Ʈ���� �ʿ��ϴ�.
		
		PrintWriter pw
		=new PrintWriter(System.out, true);//true���� �ָ� auto flush�� ������
		//��, �ٹٲ� ����(\n)�� ������ �� �ڵ����� flush�Ѵ�.
		
		String line="";
		
		while((line=br.readLine())!=null) {
			/*pw.write(line);
			pw.flush();*/
			pw.println(line);//=>���� ó�� �� �ʿ� ���� �ڵ����� flush��
		}
		br.close();
		pw.close();
		
	}

}
