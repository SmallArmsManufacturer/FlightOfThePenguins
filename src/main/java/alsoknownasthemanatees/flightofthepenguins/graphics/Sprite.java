package alsoknownasthemanatees.flightofthepenguins.graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {
	
	public static final int SIZE = 32;
	private static BufferedImage spriteSheet;
	
	private int x, y;
	
	public Sprite(Type type) {
		int width = spriteSheet.getWidth() / SIZE;
		int col = type.ordinal() % width;
		int row = type.ordinal() / width;
		x = col * SIZE;
		y = row * SIZE;
	}
	
	public enum Type {
		PENGUIN_LEFT1, PENGUIN_LEFT2, PENGUIN_LEFT3,
		PENGUIN_RIGHT1, PENGUIN_RIGHT2, PENGUIN_RIGHT3
	}
	
	static {
		try {
			spriteSheet = ImageIO.read(Sprite.class.getResource("/spriteSheet.png"));
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
	public void paint(Graphics2D g, int x, int y, int size) {
		g.drawImage(spriteSheet,
					x,      y,      x + size,      y + size,      // Destination
					this.x, this.y, this.x + SIZE, this.y + SIZE, // Source
					null);
	}
	
}
