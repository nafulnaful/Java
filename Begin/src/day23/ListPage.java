package day23;
import java.awt.*;

/*(5.3)MainMemberFrame�� ��*/
import javax.swing.*;

public class ListPage extends JPanel{

	public ListPage() {
		setBackground(Color.yellow);
	}
	
	
	@Override
	public Insets getInsets() {
		return new Insets(20,20,20,20);
	}
}
