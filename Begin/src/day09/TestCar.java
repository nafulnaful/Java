package day09;
import java.util.Date;

public class TestCar {

	public static void main(String[] args) {
		Date d=new Date();
		System.out.println(d);
		
		//MyCar��ü�� 1�� �����ϼ���
		//�� ��ü�� ����, �뷮�� ����ϼ���
		MyCar mc=new MyCar();
		System.out.println("mc.color="+mc.color);
		System.out.println("mc.capa="+mc.capa);
		mc.color="red";
		
		System.out.println("mc.color="+mc.color);
		System.out.println("mc.capa="+mc.capa);
		//HyundaiCar��ü�� 1�� �����ϱ�
		//spec, cc�� ����ϱ�	
		HyundaiCar hc=new HyundaiCar();
		System.out.println("hc.color="+hc.spec);
		System.out.println("hc.cc="+hc.cc);
		
		HyundaiCar hc2=new HyundaiCar();
		hc2.spec="���ʽý�";
		hc2.cc=3000;
		
		System.out.println("------------------");
		System.out.println("hc2.spec="+hc2.spec);
		System.out.println("hc2.cc="+hc2.cc);
		System.out.println("------------------");
		System.out.println("hc.color="+hc.spec);
		System.out.println("hc.cc="+hc.cc);
		
		

	}

}
