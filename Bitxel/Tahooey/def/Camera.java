package def;

public class Camera {

	public static int x = 0, y=0;
	public static int dx = 0, dy = 0;

	public static void update() {
		x = x + dx;
		y = y + dy;
	}

	public static void move(int dir) {
		if (dir == Frame.STILL) {
			setDX(0);
			setDY(0);
		}
		if (dir == Frame.LEFT) {
			setDY(0);
			setDX(1);
		}
		if (dir == Frame.UP) {
			setDX(0);
			setDY(1);
		}
		if (dir == Frame.RIGHT) {
			setDX(-1);
			setDY(0);
		}
		if (dir == Frame.DOWN) {
			setDX(0);
			setDY(-1);
		}
	}
	
	public static void setX(int i){
		x=i;
	}
	public static void setY(int i){
		y=i;
	}

	public static void setDX(int i) {
		dx = i*Frame.SPEED;
	}

	public static void setDY(int i) {
		dy = i*Frame.SPEED;
	}

}
