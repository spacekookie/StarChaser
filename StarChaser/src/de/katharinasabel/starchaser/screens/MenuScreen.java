package de.katharinasabel.starchaser.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import de.katharinasabel.starchaser.core.StarChaser;
import de.katharinasabel.starchaser.util.ResPack;

public class MenuScreen implements Screen {

  /** Actual UI */
  private Stage stage;
  private Table table;
  private Label title;
  private TextButton options, exit, resume;

  private StarChaser parent;
  private Camera camera;
  private ShapeRenderer render;

  public MenuScreen(StarChaser self) {
	this.camera = StarChaser.getCameraInstance();
	this.parent = self;
  }

  @Override
  public void render(float delta) {

	Gdx.gl20.glEnable(GL20.GL_BLEND);
	render.setProjectionMatrix(camera.combined);
	render.begin(ShapeType.Filled);
	render.setColor(0, 0, 0, 0.5f);
	render.rect(-10, -10, Gdx.graphics.getWidth() + 20, Gdx.graphics.getHeight() + 20);
	render.end();

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
	render = new ShapeRenderer();

	table = new Table(ResPack._SKIN);

	table.setFillParent(true);
	table.center();

	title = new Label("MAIN MENU", ResPack._SKIN);
	title.setFontScale(2.5f);

	resume = new TextButton("RESUME GAME", ResPack._SKIN);
	options = new TextButton("OPTIONS", ResPack._SKIN);
	exit = new TextButton("RAGE QUIT", ResPack._SKIN);

	table.add(title).center().pad(25f);
	table.row().height(75);
	table.add(resume).center().width(500).pad(5f);
	table.row().height(75);
	table.add(options).center().width(500).pad(5f);
	table.row().height(75);
	table.add(exit).center().width(500).pad(5f);
	stage.addActor(table);
	Gdx.input.setInputProcessor(stage);

	resume.addListener(new ClickListener() {

	  public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
		parent.setupInput();
		parent.setScreen(null);
	  }
	});
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
