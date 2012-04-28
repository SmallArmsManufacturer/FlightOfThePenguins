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
	
	private Sprite[][] terrain;
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
					player = new Entity(Entity.Type.PENGUIN, x * Sprite.SIZE, y * Sprite.SIZE);
					entities.add(player);
				}
				else if (colour.equals(Color.RED))
					entities.add(new Entity(Entity.Type.DOG, x * Sprite.SIZE, y * Sprite.SIZE));
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
		int offset_x = -(int) player.x + parent.getWidth() / 2 - Sprite.SIZE / 2;
		int offset_y = -(int) player.y + parent.getHeight() / 2 - Sprite.SIZE / 2;
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				getTile(x, y).paint(g, x * Sprite.SIZE + offset_x, y * Sprite.SIZE + offset_y, Sprite.SIZE);
			}
		}
		for (Entity entity : entities) {
			entity.animate(dt);
			entity.getSprite().paint(g, (int) entity.x + offset_x, (int) entity.y + offset_y, Sprite.SIZE);
		}
	}
	
}
