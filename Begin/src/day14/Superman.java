package day14;
//자바는 단일속성으로 하나만 상속 가능
public class Superman extends Human{
	int power;
	public Superman(String name, int height, int power) {
		this.name=name;
		this.height=height;
		this.power=power;
		}//사용자가 하나라도 생성하면 기본생성자는 사라짐
		@Override
		public String showInfo() {
			return super.showInfo()+"초능력: "+power+"\n";		
		}
		
		public void showInfo(String title) {
			System.out.println(title);
			System.out.println(this.showInfo());
		}
}
