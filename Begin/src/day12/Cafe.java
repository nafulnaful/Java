package day12;

public class Cafe {

   public static void main(String[] args) {
      CoffeeMachine cm=new CoffeeMachine();
      
      //1. 밀크커피 만들기
      cm.makeTea(1,2,3);
      
      //2. 블랙커피
      cm.makeTea(2);
      
      //3. 크림커피
      cm.makeTea(1,2);
      
      //4. 설탕커피
      String str=cm.makeTea((short)2,2);
      System.out.println(str);
      
      cm.makeTea(2, (short)3);
      
      //5. 유자차 만들기 (유자:6, 설탕:6)
      Yuja yu=new Yuja();
      //yu.yuja=6;
      yu.setYuja(6);
      yu.setSugar(6);
      
      cm.makeTea(yu);
      
   }

}

