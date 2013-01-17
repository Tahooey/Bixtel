package blcks;

import fil.ImageFileHandler;

public class TreeLog extends Block {
	
	public TreeLog(){
		isVisible=true;
		isCollidable=true;
		ID=3;
		name="TreeLog";
		IMG_TO_DRAW=ImageFileHandler.Log;
	}

}
