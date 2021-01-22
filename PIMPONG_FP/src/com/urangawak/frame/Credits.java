package com.urangawak.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Credits extends JFrame {

	private JPanel contentPane;
	Font newFont;

	public Credits() {
		
		setVisible(true);
		setTitle("CREDITS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			newFont = Font.createFont(Font.TRUETYPE_FONT, new File("Assets/Font/Typographica-Blp5.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Assets/Font/Typographica-Blp5.ttf")));
		}
		catch(IOException | FontFormatException e) {
			
		}
		
		JLabel lblNewLabel_1 = new JLabel("PBO-G");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(630, 48, 104, 50);
		lblNewLabel_1.setFont(newFont.deriveFont(17f));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M. Iqbal Abdi");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(newFont.deriveFont(15f));
		lblNewLabel_2.setBounds(157, 336, 93, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Vicky Thirdian");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(newFont.deriveFont(15f));;
		lblNewLabel_3.setBounds(548, 339, 91, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("05111940000151");
		lblNewLabel_4.setBounds(157, 368, 104, 23);
		lblNewLabel_4.setFont(newFont.deriveFont(15f));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(new ImageIcon("Assets/Images/profile_1.png"));
		lblNewLabel_5.setBounds(101, 151, 236, 189);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("Dosen Pengajar :\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(newFont.deriveFont(15f));
		lblNewLabel.setBounds(335, 474, 135, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Rizky Januar Akbar, S.Kom,. M.Eng.");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(newFont.deriveFont(16f));
		lblNewLabel_6.setBounds(282, 489, 245, 50);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel();
		lblNewLabel_5_1.setIcon(new ImageIcon("Assets/Images/profile_2.png"));
		lblNewLabel_5_1.setBounds(490, 151, 236, 189);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_7 = new JLabel("05111940000211");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(538, 370, 110, 19);
		lblNewLabel_7.setFont(newFont.deriveFont(15f));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("PIMPONG");
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(newFont.deriveFont(35f));
		lblNewLabel_8.setBounds(282, 25, 236, 65);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("by UrangAwak");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(newFont.deriveFont(15f));
		lblNewLabel_9.setBounds(335, 68, 125, 42);
		contentPane.add(lblNewLabel_9);
	}
}
