package com.urangawak.pimpong;
 
import javax.swing.*;
 
import java.awt.*;
import java.util.*;
import java.awt.event.*;
 
public class GamePanel extends JPanel implements Runnable {
 
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.55556));
	static final int BALL_RADIUS = 10;
	static final int PADDLE_WIDTH = 15;
	static final int PADDLE_HEIGHT = 100;
 
	Random random;
	Ball ball;
	Pad Paddle1, Paddle2;
	Score score;
	Image image;
	Graphics graphics;
	JButton backButton;
	JButton restartButton;
	Thread gameThread;
	int tag;
	int flag = -1;
	boolean running = false;
 
	GamePanel(int tag){
		
		this.tag = tag;
		this.addMouseListener(new MouseHandler());
		this.setBorder(BorderFactory.createLineBorder(Color.BLUE , 2));
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
		this.addKeyListener(new KeyHandler());
		this.setFocusable(true);
 
		newPad();
		newBall();
		newScore();	
 
		gameThread = new Thread(this);
	}
 
	public void newBall() {
		//random = new Random();
		ball = new Ball((GAME_WIDTH/2)-BALL_RADIUS, (GAME_HEIGHT/2)-BALL_RADIUS, BALL_RADIUS, BALL_RADIUS);
	}
 
	public void newPad() {
 
		Paddle1 = new Pad(10,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		Paddle2 = new Pad(GAME_WIDTH-PADDLE_WIDTH-10,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,tag);
	}
 
	public void newScore() {
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
	}
 
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
 
		Paddle1.draw(g);
		Paddle2.draw(g);
		score.draw(g);
		ball.draw(g);
	}
 
	public void checkCollision() {
 
		//stops paddle at windows edges
		if(Paddle1.y<=0) {
			Paddle1.y=0;
		}
		if(Paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT)) {
			Paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
		}
 
		if (tag == 2) {
			if(Paddle2.y<=0) {
				Paddle2.y=0;
			}
			if(Paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT)) {
				Paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
			}
		}else if (tag == 3) {
			if(Paddle2.y<=0) {
				Paddle2.setYDirection(-Paddle2.speedY);
			}
			if(Paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT)) {
				Paddle2.setYDirection(-Paddle2.speedY);
			}
		}
 
		//bounce ball at top and bottom edges
		if (ball.y<=0) {
			ball.setDirectionY(-ball.speedY);
		}
		if (ball.y >= (GAME_HEIGHT-BALL_RADIUS*2)) {
			ball.setDirectionY(-ball.speedY);
		}
 
		//bounce ball at pad
		if (ball.intersects(Paddle1)) {
			ball.speedX = Math.abs(ball.speedX);
			ball.speedX++;
			if (ball.speedY>0) {
				ball.speedY++;
			} else {
				ball.speedY--;
			}
			ball.setDirectionX(ball.speedX);
			ball.setDirectionY(ball.speedY);
		}
 
		if (ball.intersects(Paddle2)) {
			ball.speedX = Math.abs(ball.speedX);
			ball.speedX++;
			if (ball.speedY>0) {
				ball.speedY++;
			} else {
				ball.speedY--;
			}
			ball.setDirectionX(-ball.speedX);
			ball.setDirectionY(ball.speedY);
		}
 
		//score for player
		if (ball.x <= 0) {
			score.player2++;
			newPad();
			newBall();
		}
		if (ball.x >= GAME_WIDTH-(BALL_RADIUS*2)) {
			score.player1++;
			newPad();
			newBall();
		}
	}
 
	public void move() {
		Paddle1.move();
		Paddle2.move();
		ball.move();
	}
 
	@Override
	public void run() {
		try {
			while(true) {
				move();
				checkCollision();
				repaint();
				Thread.sleep(8);
			}
		} catch(Exception e) { System.err.println(e.getMessage()); }
	}
 
	public class KeyHandler extends KeyAdapter {
 
		@Override
		public void keyPressed(KeyEvent e) {
			Paddle1.keyPressed(e);
			Paddle2.keyPressed(e);
		}
 
		@Override
		public void keyReleased(KeyEvent e) {
			Paddle1.keyReleased(e);
			Paddle2.keyReleased(e);
		}
	}
	
 
	public class MouseHandler extends MouseAdapter{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if (flag == -1) {
				gameThread.start();
				score.str = "Pause";
				flag = 1;
			}
			else if (flag == 1) {
				score.str = "Start";
				gameThread.suspend();
				flag = 2;
			}
			else if (flag ==2) {
				score.str = "Pause";
				gameThread.resume();
				flag = 1;
			}
			
			repaint();
		}
	}
 
}