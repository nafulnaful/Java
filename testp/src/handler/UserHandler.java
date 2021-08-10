package handler;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import page.LoginPage;
import page.MainFrame;

public class UserHandler extends MouseAdapter {
	   MainFrame mainF;
	   LoginPage loginF;

	   public UserHandler(MainFrame mainF) {
	      this.mainF=mainF;
	   }
	   
	   @Override
	   public void mousePressed(MouseEvent e) {
	      Object o= e.getSource();
	   
	   }

}