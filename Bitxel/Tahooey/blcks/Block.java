package blcks;

import java.awt.*;

import def.Camera;
import def.Engine;
import fil.ImageFileHandler;

public class Block {

	public int x = 0, y = 0;
	public int finalx = 0, finaly = 0;
	public static final int WIDTH = 16, HEIGHT = 16;
	public static int finalw, finalh;
	public Image IMG_TO_DRAW;
	public int ID;
	
	public Rectangle r = new Rectangle();

	public boolean isStable = true;

	public String name = "null";

	public boolean isVisible;
	public boolean isCollidable;

	public Block() {

	}
	
	public void setRect(){
		r.setSize(finalw,finalh);
		r.setLocation(finalx+Camera.x,finaly+Camera.y);
	}

	public void workInts() {
		finalx = (x * WIDTH) * def.Frame.SCALE;
		finaly = (y * HEIGHT) * def.Frame.SCALE;
		finalw = WIDTH * def.Frame.SCALE;
		finalh = HEIGHT * def.Frame.SCALE;

		if (name.equals("Dirt")) {
			if (getBlockAbove().equals("Air")) {
				IMG_TO_DRAW = ImageFileHandler.Grass;
			}
		}

		if (name.equals("TreeLog")) {
			if (getBlockBelow().equals("Air")) {
				Engine.mb.BLOCKS[y][x] = new Air();
			}
		}

		if (name.equals("Leaves")) {
			if (!BlockWithinRange("TreeLog", 5)) {
				Engine.mb.BLOCKS[y][x] = new Air();
			}
		}
	}

	public boolean BlockWithinRange(String n, int rad) {
		boolean i = false;
		for (int j = y - (rad)-1; j < y + rad; j++) {
			for (int k = x - (rad)-1; k < x + rad; k++) {
				if (k < Engine.mb.BLOCKS[0].length) {
					if (j < Engine.mb.BLOCKS.length) {
						if (n.equals(Engine.mb.BLOCKS[j][k].name)) {
							i = true;
						}
					}else{
						i=false;
					}
				} else {
					i=false;
				}

			}
		}
		return i;
	}

	public void Update() {
		setRect();
		workInts();
		
	}
	public boolean getStability(int dir) {
		boolean i = false;
		if (dir == def.Frame.UP) {
			if (y != 0) {
				if (Engine.mb.BLOCKS[y - 1][x] != null) {
					i = Engine.mb.BLOCKS[y - 1][x].isStable;
				} else {
					i = false;
				}
			}
		}
		if (dir == def.Frame.DOWN) {
			if (y != 0) {
				if (Engine.mb.BLOCKS[y + 1][x] != null) {
					i = Engine.mb.BLOCKS[y + 1][x].isStable;
				} else {
					i = false;
				}
			}
		}
		if (dir == def.Frame.LEFT) {
			if (y != 0) {
				if (Engine.mb.BLOCKS[y][x - 1] != null) {
					i = Engine.mb.BLOCKS[y][x - 1].isStable;
				} else {
					i = false;
				}
			}
		}
		if (dir == def.Frame.RIGHT) {
			if (y != 0) {
				if (Engine.mb.BLOCKS[y][x + 1] != null) {
					i = Engine.mb.BLOCKS[y][x + 1].isStable;
				} else {
					i = false;
				}
			}
		}

		return i;
	}

	public String getBlockBelow() {
		String i = "";
		if (y != 0) {
			if (Engine.mb.BLOCKS[y + 1][x] != null) {
				i = Engine.mb.BLOCKS[y + 1][x].name;
			} else {
				i = "null";
			}
		}

		return i;
	}

	public String getBlockAbove() {
		String i = "";
		if (y != 0) {
			if (Engine.mb.BLOCKS[y - 1][x] != null) {
				i = Engine.mb.BLOCKS[y - 1][x].name;
			} else {
				i = "null";
			}
		}

		return i;
	}

	public String getBlockLeft() {
		String i = "";
		if (y != 0) {
			if (Engine.mb.BLOCKS[y][x - 1] != null) {
				i = Engine.mb.BLOCKS[y][x - 1].name;
			} else {
				i = "null";
			}
		}

		return i;
	}

	public String getBlockRight() {
		String i = "";
		if (y != 0) {
			if (Engine.mb.BLOCKS[y][x + 1] != null) {
				i = Engine.mb.BLOCKS[y][x + 1].name;
			} else {
				i = "null";
			}
		}

		return i;
	}

	public void draw(Graphics g) {
		if (isVisible) {
			g.drawImage(IMG_TO_DRAW, finalx + Camera.x, finaly + Camera.y,
					finalw, finalh, null);
		}
	}

}
