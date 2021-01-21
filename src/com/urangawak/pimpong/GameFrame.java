package com.urangawak.pimpong;

import java.awt.*;
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);	
	}
}