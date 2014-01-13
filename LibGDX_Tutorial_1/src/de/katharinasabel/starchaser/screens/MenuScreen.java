package de.katharinasabel.starchaser.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import de.katharinasabel.libgdxtutorial.core.TutorialLauncher;
import de.katharinasabel.libgdxtutorial.util.ResPack;

public class MenuScreen implements Screen {

  private TutorialLauncher self;

  private Stage stage;
  private Table table;
  private Label title;

  public MenuScreen(TutorialLauncher self) {
	this.self = self;
  }

  @Override
  public void render(float delta) {
	Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

	stage.act();
	stage.draw();
  }

  @Override
  public void resize(int width, int height) {
	stage.setViewport(width, height);
  }

  @Override
  public void show() {
	stage = new Stage();
	table = new Table(ResPack._SKIN);
	title = new Label("MAIN MENU", ResPack._SKIN);
	table.add(title);
	table.setFillParent(true);
	table.center();
	stage.addActor(table);
  }

  @Override
  public void hide() {

  }

  @Override
  public void pause() {

  }

  @Override
  public void resume() {

  }

  @Override
  public void dispose() {

  }

}
