package day12;
/*Method Overloading
 * - 메소드를 동일한 이름으로 여러 개 구성하는 것
 * - #규칙
 *    1) 메소드 이름을 동일하게 구성한다
 *  2) 매개변수는 자료형이 다르거나, 갯수가 다르거나, 순서가 달라함
 *  3) 반환타입은 같아도되고 달라도 됨 (신경안씀) 
 * */
public class CoffeeMachine {
   
   int coffee;
   int sugar;
   int cream;
   
   public void makeTea(int cf, int sg, int cr) {//밀크커피
      coffee=cf;
      sugar=sg;
      cream=cr;
      int n=coffee+sugar+cream;
      System.out.println("밀크 커피 나가요~~ 농도: "+n);
   }
   public void makeTea(int cf, int cr) {//크림커피
      coffee=cf;
      cream=cr;
      System.out.println("크림커피 나가요~~ 농도: "+(coffee+cream));
   }
   //블랙커피
   public void makeTea(int cf) {
      coffee=cf;
      System.out.println("블랙커피 나가요~~ 농도: "+coffee);
   }
   //설탕커피
   public void makeTea(int cf, short sg) {
      coffee=cf;
      sugar=sg;
      System.out.println("설탕커피 나가요 농도: "+(coffee+sugar));
   }
   public String makeTea(short sg, int cf) {
      coffee=cf;
      sugar=sg;
      //System.out.println("설탕커피 나가요 농도: "+(coffee+sugar));
      return "설탕커피 나가요~~~ 농도: "+(coffee+sugar);
   }
   
   public void makeTea(Yuja u) {
      System.out.println("***유자차 나가요~~~****");
      System.out.println("유자 : "+u.getYuja());
      System.out.println("설탕 : "+u.getSugar());
      System.out.println("농도 : "+(u.getYuja()+u.getSugar()));
   }
   

}


