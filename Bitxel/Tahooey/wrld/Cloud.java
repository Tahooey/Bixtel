package wrld;

import java.awt.*;
import java.util.*;

import fil.ImageFileHandler;

public class Cloud {
	
	public int s;
	public int x=-256,y=0;
	public int w,h;
	
	public Random r = new Random();
	
	public Cloud(int speed){
		s=speed;
		if(speed==0){
			s=1;
		}
		y=r.nextInt(def.Frame.HEIGHT-64);
	}
	
	public void update(){
		x=x+s;
		w=64*def.Frame.SCALE;
		h=16*def.Frame.SCALE;
	}
	
	public void draw(Graphics g){
		g.drawImage(ImageFileHandler.cloud1, x, y, w, h, null);
	}

}
