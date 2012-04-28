package alsoknownasthemanatees.flightofthepenguins;

import alsoknownasthemanatees.flightofthepenguins.graphics.Entity;
import alsoknownasthemanatees.flightofthepenguins.graphics.Sprite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;

public class MainGame extends GameState {
	
	Level level = new Level();
	
	public MainGame(Component parent) {
		super(parent);
	}

	@Override
	public void paint(double dt, Graphics2D g) {
		g.setBackground(Color.BLACK);
		g.clearRect(0, 0, parent.getWidth(), parent.getHeight());
		for (int x = 0; x < level.getWidth(); x++) {
			for (int y = 0; y < level.getHeight(); y++) {
				level.getTile(x, y).paint(g, x * Sprite.SIZE, y * Sprite.SIZE, Sprite.SIZE);
				Entity entity = level.getEntity(x, y);
				if (entity != null) {
					entity.animate(dt);
					entity.getSprite().paint(g, x * Sprite.SIZE, y * Sprite.SIZE, Sprite.SIZE);
				}
			}
		}
	}
	
}
