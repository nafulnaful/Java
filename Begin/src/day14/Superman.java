package day14;
//�ڹٴ� ���ϼӼ����� �ϳ��� ��� ����
public class Superman extends Human{
	int power;
	public Superman(String name, int height, int power) {
		this.name=name;
		this.height=height;
		this.power=power;
		}//����ڰ� �ϳ��� �����ϸ� �⺻�����ڴ� �����
		@Override
		public String showInfo() {
			return super.showInfo()+"�ʴɷ�: "+power+"\n";		
		}
		
		public void showInfo(String title) {
			System.out.println(title);
			System.out.println(this.showInfo());
		}
}
