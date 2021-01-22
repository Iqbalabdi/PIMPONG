package com.urangawak.pimpong;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import jdk.jshell.spi.ExecutionControl.ExecutionControlException;

public class NewSound {
	
	Clip clip;
	
	public void setFile(String fileName) {
		try {
			File file = new File (fileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(sound);
		} catch (Exception e) {};
	}
	
	public void play() {
		clip.setFramePosition(0);
		clip.start();
	}
}
