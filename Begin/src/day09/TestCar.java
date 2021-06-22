package day09;
import java.util.Date;

public class TestCar {

	public static void main(String[] args) {
		Date d=new Date();
		System.out.println(d);
		
		//MyCar객체를 1개 생성하세요
		//그 객체의 색상, 용량을 출력하세요
		MyCar mc=new MyCar();
		System.out.println("mc.color="+mc.color);
		System.out.println("mc.capa="+mc.capa);
		mc.color="red";
		
		System.out.println("mc.color="+mc.color);
		System.out.println("mc.capa="+mc.capa);
		//HyundaiCar객체를 1개 생성하기
		//spec, cc값 출력하기	
		HyundaiCar hc=new HyundaiCar();
		System.out.println("hc.color="+hc.spec);
		System.out.println("hc.cc="+hc.cc);
		
		HyundaiCar hc2=new HyundaiCar();
		hc2.spec="제너시스";
		hc2.cc=3000;
		
		System.out.println("------------------");
		System.out.println("hc2.spec="+hc2.spec);
		System.out.println("hc2.cc="+hc2.cc);
		System.out.println("------------------");
		System.out.println("hc.color="+hc.spec);
		System.out.println("hc.cc="+hc.cc);
		
		

	}

}
