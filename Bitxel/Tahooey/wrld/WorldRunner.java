package wrld;

import java.awt.*;

import blcks.Block;
import def.*;

public class WorldRunner {

	int smallestOnscreenwd = 0, smallestOnscreenhd = 0;
	int largestOnscreenwd = 0, largestOnscreenhd = 0;
	
	int smallestOnscreenwu = 0, smallestOnscreenhu = 0;
	int largestOnscreenwu = 0, largestOnscreenhu = 0;

	public WorldRunner() {

	}

	public void drawBlocks(Graphics g) {
		
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
				
				Engine.mb.BLOCKS[finh][finw].draw(g);
			}
		}
	}

	public void UpdateBlocks() {
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
				
				Engine.mb.BLOCKS[finh][finw].Update();
			}
		}
	}

}
