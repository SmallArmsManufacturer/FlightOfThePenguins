package alsoknownasthemanatees.flightofthepenguins;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.util.Stack;

public abstract class GameState extends KeyAdapter {
	
	private static Stack<GameState> stack = new Stack<GameState>();
	
	protected Component parent;
	
	public GameState(Component parent) {
		this.parent = parent;
	}
	
	public abstract void paint(double dt, Graphics2D g);
	
	public static Stack<GameState> getStack() {
		return stack;
	}
	
}
