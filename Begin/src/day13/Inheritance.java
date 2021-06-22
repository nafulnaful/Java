package day13;

public class Inheritance {

	public static void main(String[] args) {
		
		Human h1=new Human("È«±æµ¿",177);
		//h1.name="È«±æµ¿";
		//h1.height=177;
		System.out.println(h1.showInfo());
		
		
		Superman s1=new Superman("±è½´ÆÛ¸Ç",188,500);
		System.out.println(s1.showInfo());
		

		Aquaman a1=new Aquaman("ÀÎ¾î°øÁÖ",166,800);
		System.out.println(a1.showInfo());
		 
		System.out.println(s1.showInfo(200));
		
		System.out.println(s1.showInfo("##½´ÆÛ¸Ç Á¤º¸###"));
		
		//Á¦¸ñ, 300
		s1.showInfo("**½´ÆÛ¸Ç info***",50);
		
		
		a1.showInfo("¾ÆÄí¾Æ¸Ç Á¤º¸");
	}

}
