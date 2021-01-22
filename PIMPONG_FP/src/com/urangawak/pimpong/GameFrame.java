package com.urangawak.pimpong;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GameFrame extends JFrame{
	
	Image img;
	int tag;
	
	public GameFrame(int tag){
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(20, 20));
		buttonPanel.setBackground(Color.BLACK);
		this.add(buttonPanel,BorderLayout.NORTH);
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setPreferredSize(new Dimension(20, 20));
		buttonPanel2.setBackground(Color.BLACK);
		this.add(buttonPanel2,BorderLayout.EAST);
		
		JPanel buttonPanel3 = new JPanel();
		buttonPanel3.setPreferredSize(new Dimension(20, 20));
		buttonPanel3.setBackground(Color.BLACK);
		this.add(buttonPanel3,BorderLayout.WEST);
		
		JPanel buttonPanel4 = new JPanel();
		buttonPanel4.setPreferredSize(new Dimension(20, 20));
		buttonPanel4.setBackground(Color.BLACK);
		this.add(buttonPanel4,BorderLayout.SOUTH);
		this.setTitle("Pong Game");
		
		GamePanel panel = new GamePanel(tag);
		add(panel, BorderLayout.CENTER);
		
		this.setResizable(false);
		this.pack();
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int choose = JOptionPane.showConfirmDialog(null, 
							"Do you really want to exit the application ?",
							"Confirm Close", JOptionPane.YES_NO_OPTION, 
							JOptionPane.INFORMATION_MESSAGE);
				if (choose == JOptionPane.YES_OPTION) {
					e.getWindow().dispose();
				} 
				else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);	
	}
}