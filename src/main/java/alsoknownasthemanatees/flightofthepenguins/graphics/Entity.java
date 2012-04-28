package alsoknownasthemanatees.flightofthepenguins.graphics;

import java.awt.Graphics2D;

public class Entity {
	
	private Direction direction = Direction.DOWN;
	private Sprite[] up = new Sprite[4];
	private Sprite[] down = new Sprite[4];
	private Sprite[] left = new Sprite[4];
	private Sprite[] right = new Sprite[4];
	
	public Entity(Type type) {
		switch (type) {
			case PENGUIN:
				up[0] = new Sprite(Sprite.Type.PENGUIN_UP1);
				up[1] = new Sprite(Sprite.Type.PENGUIN_UP2);
				up[2] = new Sprite(Sprite.Type.PENGUIN_UP3);
				up[3] = new Sprite(Sprite.Type.PENGUIN_UP2);
				down[0] = new Sprite(Sprite.Type.PENGUIN_DOWN1);
				down[1] = new Sprite(Sprite.Type.PENGUIN_DOWN2);
				down[2] = new Sprite(Sprite.Type.PENGUIN_DOWN3);
				down[3] = new Sprite(Sprite.Type.PENGUIN_DOWN2);
				left[0] = new Sprite(Sprite.Type.PENGUIN_LEFT1);
				left[1] = new Sprite(Sprite.Type.PENGUIN_LEFT2);
				left[2] = new Sprite(Sprite.Type.PENGUIN_LEFT3);
				left[3] = new Sprite(Sprite.Type.PENGUIN_LEFT2);
				right[0] = new Sprite(Sprite.Type.PENGUIN_RIGHT1);
				right[1] = new Sprite(Sprite.Type.PENGUIN_RIGHT2);
				right[2] = new Sprite(Sprite.Type.PENGUIN_RIGHT3);
				right[3] = new Sprite(Sprite.Type.PENGUIN_RIGHT2);
				break;
			case DOG:
				up[0] = new Sprite(Sprite.Type.DOG_UP1);
				up[1] = new Sprite(Sprite.Type.DOG_UP2);
				up[2] = new Sprite(Sprite.Type.DOG_UP3);
				up[3] = new Sprite(Sprite.Type.DOG_UP2);
				down[0] = new Sprite(Sprite.Type.DOG_DOWN1);
				down[1] = new Sprite(Sprite.Type.DOG_DOWN2);
				down[2] = new Sprite(Sprite.Type.DOG_DOWN3);
				down[3] = new Sprite(Sprite.Type.DOG_DOWN2);
				left[0] = new Sprite(Sprite.Type.DOG_LEFT1);
				left[1] = new Sprite(Sprite.Type.DOG_LEFT2);
				left[2] = new Sprite(Sprite.Type.DOG_LEFT3);
				left[3] = new Sprite(Sprite.Type.DOG_LEFT2);
				right[0] = new Sprite(Sprite.Type.DOG_RIGHT1);
				right[1] = new Sprite(Sprite.Type.DOG_RIGHT2);
				right[2] = new Sprite(Sprite.Type.DOG_RIGHT3);
				right[3] = new Sprite(Sprite.Type.DOG_RIGHT2);
				break;
		}
	}
	
	public void paint(Graphics2D g, int x, int y, int size) {
		down[0].paint(g, x, y, size);
	}
	
	public enum Type {
		PENGUIN, DOG
	}
	
	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
}
