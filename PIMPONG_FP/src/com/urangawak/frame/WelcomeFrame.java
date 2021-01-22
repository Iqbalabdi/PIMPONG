package com.urangawak.frame;
import com.urangawak.pimpong.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class WelcomeFrame extends JFrame {
	
	public JPanel contentPane;
	Font newFont;
	NewSound btnSound = new NewSound();
	
	public WelcomeFrame() {
		
		this.setResizable(false);
		this.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PIMPONG");
		this.setBounds(100, 100, 702, 524);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			newFont = Font.createFont(Font.TRUETYPE_FONT, new File("Assets/Font/Minecraft.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Assets/Font/Minecraft.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
		
		btnSound.setFile("./Assets/Sound/buttonblip.wav");
		
		JLabel lblNewLabel = new JLabel("PIMPONG");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(newFont.deriveFont(40f));
		lblNewLabel.setBounds(202, 127, 313, 104);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("by UrangAwak");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(newFont.deriveFont(15f));
		lblNewLabel_1.setBounds(284, 194, 150, 49);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("1 PLAYER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame frame = new GameFrame(3);
				btnSound.play();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(newFont.deriveFont(13f));
		btnNewButton.setBounds(311, 315, 100, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CREDITS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credits credits = new Credits();
				btnSound.play();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFont(newFont.deriveFont(13f));
		btnNewButton_1.setBounds(311, 403, 100, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("2 PLAYER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame frame = new GameFrame(2);
				btnSound.play();
			}
		});
		btnNewButton_2.setBounds(311, 359, 100, 33);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(newFont.deriveFont(13f));
		contentPane.add(btnNewButton_2);
	}
}
