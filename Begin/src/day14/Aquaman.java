package day14;

public class Aquaman extends Human{

	double speed;
	
	public Aquaman(String n, int h, double s) {
		name=n;
		height=h;
		speed=s;
	}
	@Override
	public String showInfo() {
		return super.showInfo()+"½ºÇÇµå: "+speed+"\n";
	}
	
	
}
