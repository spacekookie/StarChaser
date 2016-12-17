package de.spacekookie.starchaser.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.spacekookie.starchaser.StarChaser;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		// config.width = 2560;
		// config.height = 1440;

		new LwjglApplication(new StarChaser(), config);
	}
}
