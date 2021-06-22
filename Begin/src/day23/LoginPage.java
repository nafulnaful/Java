package day23;
import java.awt.*;

/*(5.1)MainMemberFrame에 들어감*/
import javax.swing.*;

public class LoginPage extends JPanel{

	public LoginPage() {
		setBackground(Color.pink);
	}
	
	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,20,20);
	}
}
