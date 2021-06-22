//6/11[4]
package thread.day2;
import javax.swing.*;
import java.awt.*;

public class MyImagePanel extends JPanel {

	Image img;
	int x=20,y=20;
	
	public void setImg(Image img) {
		this.img =img;
	}
	public Image getImg() {
		return img;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img,  x, y, this);
	}
}
