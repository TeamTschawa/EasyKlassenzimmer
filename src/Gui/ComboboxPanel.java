package Gui;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class ComboboxPanel extends JPanel{
	private ArrayList<JButton> buttonList = new ArrayList<>();
	
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
			this.setSize(blazonButton.getWidth() + 20, 10 + blazonButton.getY() + blazonButton.getHeight());
		}
	}

	private void buttonClicked(ActionEvent e)
	{
		for(JButton button : buttonList)
		{
			if(button == e.getSource())
			{
				System.out.println(button.getText());
			}
		}
	}
	
	public String getButtonText(int index) throws Exception
	{
		if(buttonList.size() < index && index >= 0)
				return buttonList.get(index).getText();
		throw new Exception();
	}
	
	public int getButtonListSize()
	{
		return buttonList.size();
	}

}
