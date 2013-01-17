package blcks;

import fil.ImageFileHandler;

public class Dirt extends Block {
	
	public Dirt(){
		isVisible=true;
		isCollidable=true;
		ID=1;
		name="Dirt";
		IMG_TO_DRAW=ImageFileHandler.Dirt;
	}

}
