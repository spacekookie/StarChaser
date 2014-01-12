package de.katharinasabel.libgdxtutorial.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import de.katharinasabel.libgdxtutorial.objects.Entity;
import de.katharinasabel.libgdxtutorial.objects.Entity.EntityType;
import de.katharinasabel.libgdxtutorial.objects.World;
import de.katharinasabel.libgdxtutorial.util.CameraController;
import de.katharinasabel.libgdxtutorial.util.InputHandler;
import de.katharinasabel.libgdxtutorial.util.ResPack;

public class TutorialLauncher implements ApplicationListener {

  private Entity player;
  private World world;

  private static OrthographicCamera camera;
  private SpriteBatch batch;
  private Sprite space;

  private InputHandler handler;
  private CameraController camController;
  private InputMultiplexer plex;

  /** UI */
  private Stage stage;
  private TextButton menu, inventory;
  private Table buttons;

  @Override
  public void create() {

	/** Creating and populating the world */
	world = new World();
	world.addEntity(new Entity(EntityType.PLAYER, new Vector2(200, 150)));
	world.addEntity(new Entity(EntityType.STATION, new Vector2(600, 300)));
	world.addEntity(new Entity(EntityType.PLANET, new Vector2(1200, 600)));
	world.addEntity(new Entity(EntityType.STAR, new Vector2(650, 750)));

	/** Setting up the camera */
	camera = new OrthographicCamera();
	camera.position.set(0, 0, 0);
	camera.update();

	/** Setting up the UI */
	stage = new Stage();
	buttons = new Table(ResPack._SKIN);

	buttons.setFillParent(true);
	buttons.top().right();

	menu = new TextButton("Menu", ResPack._SKIN);
	inventory = new TextButton("Inventory", ResPack._SKIN);
	buttons.add(inventory);
	buttons.add(menu);

	stage.addActor(buttons);

	/** Batch renderer, Input and background */
	batch = new SpriteBatch();
	plex = new InputMultiplexer();

	space = new Sprite(ResPack.WORLD_BACKGROUND);

	handler = new InputHandler(world);
	camController = new CameraController(camera);

	/** Input Controllers */
	plex.addProcessor(stage);
	plex.addProcessor(camController);
	plex.addProcessor(handler);
	Gdx.input.setInputProcessor(plex);
  }

  public static OrthographicCamera getCameraInstance() {
	return camera;
  }

  @Override
  public void dispose() {
	batch.dispose();
  }

  @Override
  public void render() {
	Gdx.gl.glClearColor(1, 1, 1, 1);
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

	handler.update();
	camController.update();
	camController.panCamera(world.getEntitityWithType(EntityType.PLAYER).getPosition());

	batch.setProjectionMatrix(camera.combined);
	batch.begin();
	space.draw(batch);
	world.update(batch);
	batch.end();

	stage.act();
	stage.draw();
  }

  @Override
  public void resize(int width, int height) {
	stage.setViewport(width, height);
	camera.setToOrtho(false, width, height);
  }

  @Override
  public void pause() {
  }

  @Override
  public void resume() {
  }

  private void setupListeners() {
	menu.addListener(new ClickListener() {

	});
  }
}
