package alsoknownasthemanatees.flightofthepenguins;

import alsoknownasthemanatees.flightofthepenguins.graphics.Sprite;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SplashScreen extends GameState {
	
	double elapsedTime;
	Sprite[] penguin = new Sprite[4];
	int x = -128;
	BufferedImage logo, pressAnyKey;
	AudioClip clip;
	
	public SplashScreen(Component parent) {
		super(parent);
		try {
			logo = ImageIO.read(SplashScreen.class.getResource("/logo.png"));
			pressAnyKey = ImageIO.read(SplashScreen.class.getResource("/pressAnyKey.png"));
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
			System.exit(1);
		}
		penguin[0] = new Sprite(Sprite.Type.PENGUIN_LEFT1);
		penguin[1] = new Sprite(Sprite.Type.PENGUIN_LEFT2);
		penguin[2] = new Sprite(Sprite.Type.PENGUIN_LEFT3);
		penguin[3] = new Sprite(Sprite.Type.PENGUIN_LEFT2);
		clip = Applet.newAudioClip(SplashScreen.class.getResource("/partyRock.wav"));
		clip.loop();
	}

	@Override
	public void paint(double dt, Graphics2D g) {
		if ((elapsedTime + dt) % 0.1 < elapsedTime % 0.1)
			x += 4;
		if (x > parent.getWidth()) x = -128;
		g.setBackground(Color.getHSBColor((float) elapsedTime, 1.0f, 1.0f));
		g.clearRect(0, 0, parent.getWidth(), parent.getHeight());
		elapsedTime += dt;
		penguin[(int) (elapsedTime * 4) % 4].paint(g, x, parent.getHeight() / 2 + 24, 128);
		g.drawImage(logo, parent.getWidth() / 2 - logo.getWidth() / 2, parent.getHeight() / 2 - logo.getHeight(), null);
		if ((int) elapsedTime % 2 == 0)
			g.drawImage(pressAnyKey, parent.getWidth() / 2 - pressAnyKey.getWidth() / 2, parent.getHeight() / 2 + 128, null);
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		GameState.getStack().push(new MainGame(parent));
	}
	
}
