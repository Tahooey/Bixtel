package blcks;

import fil.ImageFileHandler;

public class Leaves extends Block {
	
	public Leaves(){
		isVisible=true;
		isCollidable=true;
		ID=4;
		name="Leaves";
		//isStable=false;
		IMG_TO_DRAW=ImageFileHandler.Leaves;
	}

}
