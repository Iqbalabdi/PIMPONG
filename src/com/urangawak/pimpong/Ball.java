package com.urangawak.pimpong;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Ball extends Rectangle {
	
	Random random;
	double speedX, speedY;
	double speed =  1.55;
	
	Ball (int x, int y, int width, int height){
		super(x,y,width*2, height*2);
		
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if(randomXDirection==0) {
			randomXDirection--;
		}
		setDirectionX(randomXDirection*speed);
		
		int randomYDirection = random.nextInt(2);
		if(randomYDirection==0) {
			randomYDirection--;
		}
		setDirectionY(randomYDirection*speed);
		
	}
	
	public void setDirectionX(double randomXDirection) {
		speedX = randomXDirection;
	}
	
	public void setDirectionY(double randomYDirection) {
		speedY = randomYDirection;
	}
	
	public void move() {
		x += speedX;
		y += speedY;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, width, height);
	}
}
