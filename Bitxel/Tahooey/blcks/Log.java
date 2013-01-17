package blcks;

import fil.ImageFileHandler;

public class Log extends Block {
	
	public Log(){
		isVisible=true;
		isCollidable=true;
		ID=5;
		name="Log";
		IMG_TO_DRAW=ImageFileHandler.Log;
	}

}
