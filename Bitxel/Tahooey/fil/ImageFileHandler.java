package fil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;

public class ImageFileHandler {
	
	static ImageFileHandler loader = new ImageFileHandler();
	public static BufferedImage BLOCKS;
	public static BufferedImage BACKDROP;
	public static BufferedImage CLOUDS;
	
	public static BufferedImage Dirt;
	public static BufferedImage Grass;
	public static BufferedImage Stone;
	public static BufferedImage Log;
	public static BufferedImage Leaves;
	
	public static BufferedImage cloud1;
	
	public static Image darknessOverlay;

	public static void loadImages() throws IOException{		
		BLOCKS=loadImage("images/blocks.png");
		BACKDROP=loadImage("images/skyBackDrop.png");
		CLOUDS=loadImage("images/clouds.png");
		
		Dirt=getBLOCK(0,0);
		Grass=getBLOCK(1,0);
		Stone=getBLOCK(2,0);
		Log=getBLOCK(3,0);
		Leaves=getBLOCK(4,0);
		
		cloud1=SplitImage(CLOUDS,64,16,0,0);
	}
	
	public static BufferedImage SplitImage(BufferedImage i,int w,int h,int x,int y){
		BufferedImage j=i.getSubimage(x*w, y*h, w, h);
		
		return j;
	}

	public static BufferedImage getBLOCK(int across, int down) {
		BufferedImage i;

		i = BLOCKS.getSubimage(across * 16, down * 16, 16, 16);

		return i;
	}

	public static BufferedImage loadImage(String path) throws IOException {
		URL url = loader.getClass().getResource(path);
		return ImageIO.read(url);
	}

}
