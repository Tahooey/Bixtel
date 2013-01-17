package wrld;

import java.awt.*;
import java.util.*;

import def.Frame;
import fil.ImageFileHandler;

public class Sky {
	
	public static Cloud[] c;
	public static Random r = new Random();
	
	public static void startup(){
		c = new Cloud[8];
		start();
	}
	
	public static void start(){
		for(int i=0;i<c.length;i++){
			c[i]=new Cloud(r.nextInt(4)+2);
		}
	}
	
	public static void update(){
		for(int i=0;i<c.length;i++){
			c[i].update();
			if(c[i].x>=def.Frame.WIDTH){
				c[i]=new Cloud(r.nextInt(def.Frame.SPEED));
			}
		}
	}
	
	public static void draw(Graphics g){
		g.drawImage(ImageFileHandler.BACKDROP, 0, 0, Frame.WIDTH, Frame.HEIGHT, 0, 0, Frame.WIDTH/Frame.SCALE, Frame.HEIGHT/Frame.SCALE, null);
		for(int i=0;i<c.length;i++){
			c[i].draw(g);
		}
	}

}
