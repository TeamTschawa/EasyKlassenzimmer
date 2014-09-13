package Gui;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class ComboboxPanel extends JPanel {

	public ArrayList<JButton> buttonList = new ArrayList<>();
	private Window win;
	File dir;
	File[] fileList;

	public ComboboxPanel(Window _win) {
		this.setLayout(null);
		this.setVisible(false);
		dir = new File("blazon");
		fileList = dir.listFiles();
		win = _win;
		for (int i = 0; i < fileList.length; i++) {
			Image arRight = Toolkit.getDefaultToolkit().getImage(
					"blazon/" + fileList[i].getName());
			JButton blazonButton = new JButton(fileList[i].getName().replace(
					".png", ""), new ImageIcon(arRight.getScaledInstance(24,
					24, Image.SCALE_SMOOTH)));
			blazonButton.setHorizontalAlignment(SwingConstants.LEFT);
			blazonButton.setIconTextGap(30);
			blazonButton.setBounds(10, 10 + i * (30 + 3), 280, 30);
			blazonButton.setVisible(true);
			blazonButton.setContentAreaFilled(false);
			blazonButton.setBorderPainted(false);
			blazonButton.setFocusPainted(false);
			blazonButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			blazonButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					buttonClicked(e);
				}
			});
			buttonList.add(blazonButton);
			this.add(blazonButton);
			this.setSize(blazonButton.getWidth() + 20, 10 + blazonButton.getY()
					+ blazonButton.getHeight());
		}
	}

	private void buttonClicked(ActionEvent e) {
		for (int i = 0; i < buttonList.size(); i++) {
			if (buttonList.get(i) == e.getSource()) {
				win.con.currentState = i;
				Image img = Toolkit.getDefaultToolkit().getImage(
						"blazon/" + fileList[i].getName());
				
				win.blazon.setIcon(new ImageIcon(img.getScaledInstance(win.blazon.getWidth(),
						win.blazon.getHeight(), Image.SCALE_SMOOTH)));
				this.setVisible(false);
			}
		}
	}

	public String getButtonText(int index) throws Exception {
		if (buttonList.size() < index && index >= 0)
			return buttonList.get(index).getText();
		throw new Exception();
	}

	public int getButtonListSize() {
		return buttonList.size();
	}

}
