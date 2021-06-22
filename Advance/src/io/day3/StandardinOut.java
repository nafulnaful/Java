//6/16[4]
package io.day3;
import java.io.*;
/*Ű���� �Է�==> �ֿܼ� ���
 * BufferedReader/BufferedWriter
 * - 2byte���
 * - ���� ��Ʈ��
 * - ���ۿ� ��Ƽ� �а�/����
 * - int read()
 * - String readLine()
 * ------------------------------
 * ������ �ҽ�	 : Ű����==>��彺Ʈ��(System.in)
 * ������ ������: �ܼ� 	==>��彺Ʈ��(System.out)
 * */
public class StandardinOut {

	public static void main(String[] args)
	throws Exception{
		BufferedReader br
		=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader�� �����ڿ� Reader�迭�� ��ü�� �޾Ƶ��δ�.
	    //���� 1����Ʈ��� ��Ʈ���� �����ؾ� �� ���� �긴�� ��Ʈ���� �ʿ��ϴ�.
		
		BufferedWriter bw
		=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line="";
		//readline() �� ���๮��(\n)�� ������ �������� ���ڿ��� ��ȯ�Ѵ�.
		bw.write("�Է��ϼ���=>");
		bw.flush();
		while((line=br.readLine())!=null) {
			//bw.write(line+"\n");
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
	}

}
