package day12;
/*Method Overloading
 * - �޼ҵ带 ������ �̸����� ���� �� �����ϴ� ��
 * - #��Ģ
 *    1) �޼ҵ� �̸��� �����ϰ� �����Ѵ�
 *  2) �Ű������� �ڷ����� �ٸ��ų�, ������ �ٸ��ų�, ������ �޶���
 *  3) ��ȯŸ���� ���Ƶ��ǰ� �޶� �� (�Ű�Ⱦ�) 
 * */
public class CoffeeMachine {
   
   int coffee;
   int sugar;
   int cream;
   
   public void makeTea(int cf, int sg, int cr) {//��ũĿ��
      coffee=cf;
      sugar=sg;
      cream=cr;
      int n=coffee+sugar+cream;
      System.out.println("��ũ Ŀ�� ������~~ ��: "+n);
   }
   public void makeTea(int cf, int cr) {//ũ��Ŀ��
      coffee=cf;
      cream=cr;
      System.out.println("ũ��Ŀ�� ������~~ ��: "+(coffee+cream));
   }
   //��Ŀ��
   public void makeTea(int cf) {
      coffee=cf;
      System.out.println("��Ŀ�� ������~~ ��: "+coffee);
   }
   //����Ŀ��
   public void makeTea(int cf, short sg) {
      coffee=cf;
      sugar=sg;
      System.out.println("����Ŀ�� ������ ��: "+(coffee+sugar));
   }
   public String makeTea(short sg, int cf) {
      coffee=cf;
      sugar=sg;
      //System.out.println("����Ŀ�� ������ ��: "+(coffee+sugar));
      return "����Ŀ�� ������~~~ ��: "+(coffee+sugar);
   }
   
   public void makeTea(Yuja u) {
      System.out.println("***������ ������~~~****");
      System.out.println("���� : "+u.getYuja());
      System.out.println("���� : "+u.getSugar());
      System.out.println("�� : "+(u.getYuja()+u.getSugar()));
   }
   

}


