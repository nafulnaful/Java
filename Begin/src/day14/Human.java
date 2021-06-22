package day14;
//부모클래스: Super class, Base class
public class Human {
   
   String name;
   int height;
   
   public Human() {
      this("아무개",155);
   }
   
   //생성자를 1개라도 구성하면 컴파일러가 제공하던 디폴트 생성자는 사라진다.
   public Human(String name, int height) {
      this.name = name;
      this.height =height;
   }
   
   public String showInfo() 
   {
      String str="이름: "+name+"\n";
      str+="키  : "+height+"\n";
      return str;
   }

}