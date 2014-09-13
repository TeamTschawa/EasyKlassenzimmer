package Gui;

import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class ComboboxPanel extends JPanel{
	ArrayList<JButton> buttonList = new ArrayList<>();
	
	public ComboboxPanel(){
		this.setLayout(null);
		File dir = new File("blazon");
		System.out.println(dir.getAbsolutePath());
		File[] fileList = dir.listFiles();
		for(int i = 0; i < fileList.length; i++)
		{
			Image arRight = Toolkit.getDefaultToolkit().getImage("blazon/" + fileList[i].getName());
			JButton blazonButton = new JButton(fileList[i].getName().replace(".png", ""), new ImageIcon(arRight.getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
			blazonButton.setHorizontalAlignment(SwingConstants.LEFT);
			blazonButton.setIconTextGap(30);
			blazonButton.setBounds(10, 10 + i * (30 + 3), 280, 30);
			blazonButton.setVisible(true);
			this.add(blazonButton);
			this.setSize(blazonButton.getWidth() + 20, 10 + blazonButton.getY() + blazonButton.getHeight());
		}
	}

}
