package day09;

public class ClassCar {
	String spec;
	String color;
	String making;
	int capa;
	int mas;
	int mis;
	
	class ClassCar2 {
		spec="쏘나타";
		color="whit";
		making="2020.12.01";
		capa=2000;
		mas=220;
		mis=10;
	}
	
	class ClassCar3 {
		spec="G70";
		color="green";
		making="2020.11.01";
		capa=3500;
		mas=260;
		mis=20;aa
	}
	
	class ClassCar4 {
		spec="G90";
		color="litghtblue";
		making="2020.02.11";
		capa=3500;
		mas=300;
		mis=15;
	}
	
	class ClassCar5 {
		spec="GV80";
		color="black";
		making="2019.11.11";
		capa=3200;
		mas=270;
		mis=30;
	}
	public static void main(String[] args) {
		ClassCar mc=new ClassCar();
		System.out.println("자동차 모델명="+mc.spec);
		System.out.println("색상="+mc.color);
		System.out.println("제조년도="+mc.making);
		System.out.println("용량="+mc.capa);
		System.out.println("초기 속도="+mc.mas);
		System.out.println("최대 속도="+mc.mis);
		

	}

}
