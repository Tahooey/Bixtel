package wrld;

import blcks.*;
import def.*;

public class Mapbuilder {
	
	public Block[][] BLOCKS;
	
	public Mapbuilder(){
		BuildBlocks();
	}
	
	public void BuildBlocks(){
		BLOCKS = new Block[Engine.wfh.ID.length][];
		for(int h=0;h<Engine.wfh.ID.length;h++){
			BLOCKS[h]=new Block[Engine.wfh.ID[h].length];
			for(int w=0;w<Engine.wfh.ID[h].length;w++){
				if(Engine.wfh.ID[h][w]==0){
					BLOCKS[h][w]=new Air();
				}else if(Engine.wfh.ID[h][w]==1){
					BLOCKS[h][w]=new Dirt();
				}else if(Engine.wfh.ID[h][w]==2){
					BLOCKS[h][w]=new Stone();
				}else if(Engine.wfh.ID[h][w]==3){
					BLOCKS[h][w]=new TreeLog();
				}else if(Engine.wfh.ID[h][w]==4){
					BLOCKS[h][w]=new Leaves();
				}else{
					BLOCKS[h][w]=new Air();
				}
				BLOCKS[h][w].x=w;
				BLOCKS[h][w].y=h;
			}
		}
	}

}
