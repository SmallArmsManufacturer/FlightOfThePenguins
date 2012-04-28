package alsoknownasthemanatees.flightofthepenguins;

import alsoknownasthemanatees.flightofthepenguins.graphics.Entity;
import alsoknownasthemanatees.flightofthepenguins.graphics.Sprite;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Level {
	
	private Sprite[][] terrain;
	private Entity[][] entities;
	
	public Level() {
		BufferedImage terrainImage = null;
		BufferedImage entitiesImage = null;
		try {
			terrainImage = ImageIO.read(Level.class.getResource("/level1terrain.png"));
			entitiesImage = ImageIO.read(Level.class.getResource("/level1entities.png"));
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
			System.exit(1);
		}
		terrain = new Sprite[terrainImage.getWidth()][terrainImage.getHeight()];
		for (int x = 0; x < terrainImage.getWidth(); x++) {
			for (int y = 0; y < terrainImage.getHeight(); y++) {
				Color colour = new Color(terrainImage.getRGB(x, y));
				if (colour.equals(Color.GREEN))
					terrain[x][y] = new Sprite(Sprite.Type.GRASS);
				else if (colour.equals(Color.BLACK))
					terrain[x][y] = new Sprite(Sprite.Type.GRAVEL);
				else if (colour.equals(Color.WHITE))
					terrain[x][y] = new Sprite(Sprite.Type.SNOW);
			}
		}
		entities = new Entity[entitiesImage.getWidth()][entitiesImage.getHeight()];
		for (int x = 0; x < entitiesImage.getWidth(); x++) {
			for (int y = 0; y < entitiesImage.getHeight(); y++) {
				Color colour = new Color(entitiesImage.getRGB(x, y));
				if (colour.equals(Color.BLUE))
					entities[x][y] = new Entity(Entity.Type.PENGUIN);
				else if (colour.equals(Color.RED))
					entities[x][y] = new Entity(Entity.Type.DOG);
			}
		}
	}
	
	public int getWidth() {
		return Math.max(terrain.length, entities.length);
	}
	
	public int getHeight() {
		return Math.max(terrain[0].length, entities[0].length);
	}
	
	public Sprite getTile(int x, int y) {
		return terrain[x][y];
	}
	
	public Entity getEntity(int x, int y) {
		return entities[x][y];
	}
	
}
