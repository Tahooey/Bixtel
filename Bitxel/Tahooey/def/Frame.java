package def;

import java.awt.*;
import java.io.*;

import javax.swing.*;

import fil.*;

public class Frame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH=1024,HEIGHT=512;
	public static final int SCALE=1;
	public static final int SPEED=4;
	public static final String NAME="Bixtel";
	public static final Color BACKGROUND=Color.BLACK;
	
	public static final int UP=0,DOWN=1,LEFT=2,RIGHT=3,STILL=4;
	
	public static GamePanel gp;

	public Frame(){
		
		gp=new GamePanel();
		
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setTitle(NAME);
		setBackground(BACKGROUND);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		try {
			ImageFileHandler.loadImages();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		add(gp);
		
		setVisible(true);
	}

}
