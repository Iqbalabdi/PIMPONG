package com.urangawak.pimpong;

import java.awt.*;
import java.awt.event.*;

public class Pad extends Rectangle {

	int tag;
	int speedY;
	int speed = 10;
	
	Pad(int x, int y, int width, int height, int tag){
		super(x,y,width,height);
		this.tag=tag;
		
		if (tag == 3) {
			setYDirection(4);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		switch(tag) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(speed);
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(speed);
			}
			break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		switch(tag) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(0);
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(0);
			}
			break;
		}
	}
	
	public void setYDirection(int yDirection) {
		speedY = yDirection;
	}
	
	public void move() {
		y = y + speedY;
	}
	
	public void draw(Graphics g) {
		if(tag==1)
			g.setColor(Color.white);
		else
			g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}
}
