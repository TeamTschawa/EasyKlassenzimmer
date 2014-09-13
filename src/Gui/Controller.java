package Gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Controller {

	Window win;
	int currentState = 0;

	public Controller() {
		win = new Window("TEST", this);
	}

	public void left(ActionEvent e) {
		if (currentState - 1 < 0) {
			currentState = 15;
		} else {
			currentState--;
		}
		Image img = Toolkit.getDefaultToolkit().getImage(
				"blazon/" + win.combobox.fileList[currentState].getName());
		win.blazon.setIcon(new ImageIcon(img.getScaledInstance(win.blazon.getWidth(),
				win.blazon.getHeight(), Image.SCALE_SMOOTH)));
	}

	public void right(ActionEvent e) {
		if (currentState + 1 > 15) {
			currentState = 0;
		} else {
			currentState++;
		}
		Image img = Toolkit.getDefaultToolkit().getImage(
				"blazon/" + win.combobox.fileList[currentState].getName());
		win.blazon.setIcon(new ImageIcon(img.getScaledInstance(win.blazon.getWidth(),
				win.blazon.getHeight(), Image.SCALE_SMOOTH)));
	}

	public void actionBlaze(ActionEvent e) {
		win.blazon.removeMouseListener(win);
		win.combobox.setVisible(!win.combobox.isVisible());
		win.blazon.removeMouseListener(win);
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
