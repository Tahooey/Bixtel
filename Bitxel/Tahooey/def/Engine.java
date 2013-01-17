package def;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import wrld.*;

import fil.*;

public class Engine {
	
	public static int time=0;
	
	public static WorldFileHandler wfh = new WorldFileHandler();
	public static Mapbuilder mb = new Mapbuilder();
	public static WorldRunner wr = new WorldRunner();
	
	public static void drawSquare(Graphics g,int x,int y,int w,int h){
		g.setColor(Color.WHITE);
		g.fillRect(x, y, w, h);
	}
	
	public static void boot(){
		Sky.startup();
		Camera.setY(-((1024-64)*Frame.SCALE));
		Camera.setX(-(512*Frame.SCALE));
	}
	
	public static void drawGame(Graphics g){
		Sky.draw(g);
		wr.drawBlocks(g);
		g.drawString(time+"!", 30, 20);
	}
	
	static Thread clock = new Thread(){
		public void run(){
			if(time>=0){
				time++;
				if(time==10000){
					time=0;
				}
			}
		}
	};
	
	public static void UpdateGame(){
		BlockUpdater.run();
		CamUpdater.run();
		MouseUpdater.run();
		SkyUpdater.run();
		clock.run();
	}
	
	static Thread SkyUpdater = new Thread(){
		public void run(){
			Sky.update();
		}
	};
	
	static Thread BlockUpdater = new Thread() {
		public void run() {
			wr.UpdateBlocks();
		}
	};
	static Thread CamUpdater = new Thread() {
		public void run() {
			Camera.update();
		}
	};
	static Thread MouseUpdater = new Thread() {
		public void run() {
			Mouse.update();
		}
	};
	
	public static void keyPressed(KeyEvent e){
		int KeyCode=e.getKeyCode();
		if(KeyCode==KeyEvent.VK_W){
			Camera.move(Frame.UP);
		}
		if(KeyCode==KeyEvent.VK_S){
			Camera.move(Frame.DOWN);
		}
		if(KeyCode==KeyEvent.VK_A){
			Camera.move(Frame.LEFT);
		}
		if(KeyCode==KeyEvent.VK_D){
			Camera.move(Frame.RIGHT);
		}
		if(KeyCode==KeyEvent.VK_ESCAPE){
			try {
				wfh.save();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public static void keyReleased(KeyEvent e){
		//int KeyCode=e.getKeyCode();
		Camera.move(Frame.STILL);
	}

}
