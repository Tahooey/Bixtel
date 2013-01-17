package blcks;

import fil.ImageFileHandler;

public class Stone extends Block {
	
	public Stone(){
		isVisible=true;
		isCollidable=true;
		ID=2;
		name="Stone";
		IMG_TO_DRAW=ImageFileHandler.Stone;
	}

}
