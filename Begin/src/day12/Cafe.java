package day12;

public class Cafe {

   public static void main(String[] args) {
      CoffeeMachine cm=new CoffeeMachine();
      
      //1. ��ũĿ�� �����
      cm.makeTea(1,2,3);
      
      //2. ��Ŀ��
      cm.makeTea(2);
      
      //3. ũ��Ŀ��
      cm.makeTea(1,2);
      
      //4. ����Ŀ��
      String str=cm.makeTea((short)2,2);
      System.out.println(str);
      
      cm.makeTea(2, (short)3);
      
      //5. ������ ����� (����:6, ����:6)
      Yuja yu=new Yuja();
      //yu.yuja=6;
      yu.setYuja(6);
      yu.setSugar(6);
      
      cm.makeTea(yu);
      
   }

}

