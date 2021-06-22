package day11;

public class Cafe {

	public static void main(String[] args) {
		CoffeeMachine cm=new CoffeeMachine();
		//cm.coffee=2;
		//cm.sugar=1;
		//cm.cream=3;
		cm.setCoffee(2);//직접 꺼내오는게 아닌 메소드를 통해서 꺼내오는 것
		cm.setSugar(1);
		cm.setCream(3L);
		
		
		System.out.println("cm.coffee: "+cm.getCoffee());
		System.out.println("cm.sugar: "+cm.getSugar());
		System.out.println("cm.cream: "+cm.getCream());

	}

}
