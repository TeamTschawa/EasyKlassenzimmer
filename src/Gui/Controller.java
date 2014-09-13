package Gui;

import java.awt.event.ActionEvent;

import javax.swing.UIManager;

public class Controller {

	Window win;

	public Controller() {
		win = new Window("TEST", this);
	}

	public void left(ActionEvent e) {
		System.out.println("links");
	}

	public void right(ActionEvent e) {
		System.out.println("rechts");
	}

	public void actionBlaze(ActionEvent e) {
		System.out.println("mitte");
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Controller();
	}

}
