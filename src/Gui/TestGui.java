package Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class TestGui extends JFrame{
	ComboboxPanel kp = new ComboboxPanel();
	
	public TestGui() {
		super();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setPreferredSize(kp.getSize());
		this.add(kp);
		this.setSize(kp.getSize());
		this.setResizable(false);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new TestGui();
	}
}
