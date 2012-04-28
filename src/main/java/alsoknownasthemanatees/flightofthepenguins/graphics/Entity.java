package alsoknownasthemanatees.flightofthepenguins.graphics;

public class Entity {
	
	public Direction direction = Direction.DOWN;
	private Sprite[][] sprites = new Sprite[4][4];
	private int frame;
	private double elapsedTime;
	public double x, y;
	public boolean isMoving = false;
	
	public Entity(Type type, double x, double y) {
		this.x = x;
		this.y = y;
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
		return isMoving ? sprites[direction.ordinal()][frame] : sprites[direction.ordinal()][1];
	}
	
	public void animate(double dt) {
		if ((elapsedTime + dt) % 0.5 < elapsedTime % 0.5)
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
