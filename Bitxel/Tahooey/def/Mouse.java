package def;

import java.awt.*;

import blcks.*;

public class Mouse {
	
	static int smallestOnscreenwd = 0, smallestOnscreenhd = 0;
	static int largestOnscreenwd = 0, largestOnscreenhd = 0;
	
	static int smallestOnscreenwu = 0, smallestOnscreenhu = 0;
	static int largestOnscreenwu = 0, largestOnscreenhu = 0;
	
	public static boolean isPressed=false;
	public static boolean isReleased=true;
	
	static int x=0,y=0;
	
	public static Rectangle r = new Rectangle();
	
	public static void update(){
		setRect();
		if(isPressed){
			BreakBlock();
		}
	}
	
	public static void setRect(){
		r.setSize(1,1);
		r.setLocation(x,y);
	}
	
	public static void BreakBlock(){
		int finw=0,finh=0;
		
		smallestOnscreenwd=Camera.x/(Block.WIDTH*def.Frame.SCALE)*-1;
		largestOnscreenwd=smallestOnscreenwd+(def.Frame.WIDTH/(Block.WIDTH*def.Frame.SCALE))+1;
		smallestOnscreenhd=Camera.y/(Block.HEIGHT*def.Frame.SCALE)*-1;
		largestOnscreenhd=smallestOnscreenhd+(def.Frame.HEIGHT/(Block.HEIGHT*def.Frame.SCALE))+1;
		
		for(int h=smallestOnscreenhd;h<largestOnscreenhd;h++){
			for(int w=smallestOnscreenwd;w<largestOnscreenwd;w++){
				finw=w;
				finh=h;
				if(h<=-1){
					finh=0;
				}
				if(w<=-1){
					finw=0;
				}
				if(h>=Engine.mb.BLOCKS.length){
					finh=Engine.mb.BLOCKS.length-1;
				}
				if(w>=Engine.mb.BLOCKS[0].length){
					finw=Engine.mb.BLOCKS[0].length-1;
				}
				if(r.intersects(Engine.mb.BLOCKS[finh][finw].r)){
					Engine.mb.BLOCKS[finh][finw]=new Air();
				}
			}
		}
	}

}
