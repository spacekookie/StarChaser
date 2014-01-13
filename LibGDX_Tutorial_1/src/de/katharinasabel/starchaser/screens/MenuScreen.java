package de.katharinasabel.starchaser.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import de.katharinasabel.starchaser.util.ResPack;

public class MenuScreen implements Screen {

  private Stage stage;
  private Table table;
  private Label title;

  public MenuScreen() {
  }

  @Override
  public void render(float delta) {
	Gdx.gl20.glEnable(GL20.GL_BLEND);
	Gdx.gl20.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

	Gdx.gl20.glClearColor(0, 0, 0, 0.5f);
	Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
