package de.katharinasabel.libgdxtutorial;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import de.katharinasabel.libgdxtutorial.core.TutorialLauncher;

public class Main {
  public static void main(String[] args) {
	LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
	cfg.title = "LibGDX_Tutorial_1";
	cfg.resizable = false;
	cfg.useGL20 = true;
	cfg.width = 1280;
	cfg.height = 720;

	new LwjglApplication(new TutorialLauncher(), cfg);
  }
}
