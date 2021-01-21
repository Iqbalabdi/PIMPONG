package com.urangawak.pimpong;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Score {

	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int player1 = 0;
	int player2 = 0;
	String str = "Start";
	
	Score(int width, int height){
		this.GAME_WIDTH = width;
		this.GAME_HEIGHT = height;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Consolas", Font.BOLD, 40));
		Graphics2D g2d = (Graphics2D) g;
		float[] dash1 = {10f,0f,2f};
		BasicStroke bs1 = new BasicStroke(1,  BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash1,2f);
		g2d.setStroke(bs1);
		g2d.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
		g2d.drawOval(GAME_WIDTH/2-100, GAME_HEIGHT/2-100, 200, 200);
		g.drawString(String.valueOf(player1), GAME_WIDTH/4, 50);
		g.drawString(String.valueOf(player2), GAME_WIDTH*3/4, 50);
		g.setFont(new Font("Consolas", Font.PLAIN, 15));
		g.drawString("Click to "+str, GAME_WIDTH-150, 20);
	}
}
