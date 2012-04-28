package alsoknownasthemanatees.flightofthepenguins.graphics;

public class Entity {
	
	private Direction direction = Direction.DOWN;
	private Sprite[][] sprites = new Sprite[4][4];
	private int frame;
	private double elapsedTime;
	
	public Entity(Type type) {
		Sprite.Type base = null;
		switch(type) {
			case PENGUIN:
				base = Sprite.Type.PENGUIN_LEFT1;
				break;
			case DOG:
				base = Sprite.Type.DOG_LEFT1;
				break;
		}
		for (int dir = 0; dir < 4; dir++) {
			int[] frames = new int[] { 0, 1, 2, 1 };
			for (int i = 0; i < frames.length; i++) {
				sprites[dir][i] = new Sprite(Sprite.Type.values()[base.ordinal() + 3 * dir + frames[i]]);
			}
		}
	}
	
	public Sprite getSprite() {
		return sprites[direction.ordinal()][frame];
	}
	
	public void animate(double dt) {
		if ((int) (elapsedTime + dt) != (int) elapsedTime)
			frame++;
		if (frame > 3)
			frame = 0;
		elapsedTime += dt;
	}
	
	public enum Type {
		PENGUIN, DOG
	}
	
	public enum Direction {
		LEFT, RIGHT, DOWN, UP
	}
	
}
