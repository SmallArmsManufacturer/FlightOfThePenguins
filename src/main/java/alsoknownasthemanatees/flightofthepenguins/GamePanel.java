package alsoknownasthemanatees.flightofthepenguins;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener {
	
	long prevTime = System.nanoTime();
	
	public GamePanel() {
		setPreferredSize(new Dimension(800, 600));
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Flight of the Penguins");
		final GamePanel panel = new GamePanel();
		
		GameState.getStack().push(new SplashScreen(panel));
		
		window.add(panel);
		window.addKeyListener(panel);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		new Timer(1, new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				panel.repaint();
			}
		
		}).start();
	}
	
	@Override
	public void paint(Graphics graphics) {
		long elapsedTime = System.nanoTime() - prevTime;
		double dt = elapsedTime / 1000000000.0;
		prevTime += elapsedTime;
		
		Graphics2D g = (Graphics2D) graphics;
		GameState.getStack().peek().paint(dt, g);
	}

	public void keyTyped(KeyEvent ke) {
		GameState.getStack().peek().keyTyped(ke);
	}

	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
			GameState.getStack().pop();
			if (GameState.getStack().empty())
				System.exit(0);
		} else {
			GameState.getStack().peek().keyPressed(ke);
		}
	}

	public void keyReleased(KeyEvent ke) {
		GameState.getStack().peek().keyReleased(ke);
	}
	
}
