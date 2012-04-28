package alsoknownasthemanatees.flightofthepenguins;

import alsoknownasthemanatees.flightofthepenguins.graphics.Entity;
import alsoknownasthemanatees.flightofthepenguins.graphics.Sprite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class MainGame extends GameState {
	
	Level level;
	Entity.Direction movementDirection = null;
	
	public MainGame(Component parent) {
		super(parent);
		level = new Level(parent);
	}

	@Override
	public void paint(double dt, Graphics2D g) {
		g.setBackground(Color.BLACK);
		g.clearRect(0, 0, parent.getWidth(), parent.getHeight());
		level.paint(dt, g);
		
		if (movementDirection != null)
		switch (movementDirection) {
			case UP:
				level.player.y -= dt * 2 * Sprite.SIZE;
				break;
			case DOWN:
				level.player.y += dt * 2 * Sprite.SIZE;
				break;
			case LEFT:
				level.player.x -= dt * 2 * Sprite.SIZE;
				break;
			case RIGHT:
				level.player.x += dt * 2 * Sprite.SIZE;
				break;
		}
                
	}
        
	
	@Override
	public void keyPressed(KeyEvent ke) {
		switch (ke.getKeyCode()) {
			case KeyEvent.VK_UP:
				movementDirection = Entity.Direction.UP;
				break;
			case KeyEvent.VK_DOWN:
				movementDirection = Entity.Direction.DOWN;
				break;
			case KeyEvent.VK_LEFT:
				movementDirection = Entity.Direction.LEFT;
				break;
			case KeyEvent.VK_RIGHT:
				movementDirection = Entity.Direction.RIGHT;
				break;
			default:
				movementDirection = null;
		}
		if (movementDirection != null) {
			level.player.direction = movementDirection;
			level.player.isMoving = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			movementDirection = null;
			level.player.isMoving = false;
		}
	}
	
}
