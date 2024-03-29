package alsoknownasthemanatees.flightofthepenguins;

import alsoknownasthemanatees.flightofthepenguins.graphics.Entity;
import alsoknownasthemanatees.flightofthepenguins.graphics.Sprite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class Level {
	
	public Sprite[][] terrain;
	private List<Entity> entities = new ArrayList<Entity>();
	public Entity player;
	private Component parent;
	
	public Level(Component parent) {
		this.parent = parent;
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
		for (int x = 0; x < entitiesImage.getWidth(); x++) {
			for (int y = 0; y < entitiesImage.getHeight(); y++) {
				Color colour = new Color(entitiesImage.getRGB(x, y));
				if (colour.equals(Color.BLUE)) {
					player = new Entity(Entity.Type.PENGUIN, x * Sprite.SIZE , y * Sprite.SIZE, this);
					entities.add(player);
				}
				else if (colour.equals(Color.RED))
					entities.add(new Dog(x * Sprite.SIZE, y * Sprite.SIZE, this));
			}
		}
	}
	
	public int getWidth() {
		return terrain.length;
	}
	
	public int getHeight() {
		return terrain[0].length;
	}
	
	public Sprite getTile(int x, int y) {
		return terrain[x][y];
	}
	
	public List<Entity> getEntites() {
		return entities;
	}
	
	public void paint(double dt, Graphics2D g) {
		int offset_x = -(int) player.x * 2 + parent.getWidth() / 2 - Sprite.SIZE;
		int offset_y = -(int) player.y * 2 + parent.getHeight() / 2 - Sprite.SIZE;
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				getTile(x, y).paint(g, x * Sprite.SIZE * 2 + offset_x, y * Sprite.SIZE * 2 + offset_y, Sprite.SIZE * 2);
			}
		}
		for (Entity entity : entities) {
			entity.update(dt);
			entity.getSprite().paint(g, (int) entity.x * 2 + offset_x, (int) entity.y * 2 + offset_y, Sprite.SIZE * 2);
		}
	}
	
}
