package de.katharinasabel.starchaser.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class CameraController extends InputAdapter {
  final OrthographicCamera camera;

  /* x = min, y = max */
  private final Vector2 zoomBounds = new Vector2(0.45f, 0.75f);
  private final Vector3 current = new Vector3();
  private final Vector3 mouse = new Vector3(-1, -1, -1);
  private final Vector3 last = new Vector3(-1, -1, -1);
  private final Vector3 delta = new Vector3();

  public CameraController(OrthographicCamera camera) {
	this.camera = camera;
	camera.zoom = 0.55f;
  }

  @Override
  public boolean touchDragged(int x, int y, int pointer) {
	camera.unproject(current.set(x, y, 0));

	if (!(last.x == -1 && last.y == -1 && last.z == -1)) {
	  camera.unproject(delta.set(last.x, last.y, 0));
	  delta.sub(current);
	  camera.position.add(delta.x, delta.y, 0);
	}
	last.set(x, y, 0);
	return false;
  }

  public void changeZoom(float zoom, float x, float y) {

	Vector3 before = new Vector3(x, y, 0);
	camera.unproject(before);

	if (zoom <= zoomBounds.x || zoom >= zoomBounds.y) {
	  return;
	}
	camera.zoom = zoom;
	camera.update();
	Vector3 after = new Vector3(x, y, 0);
	camera.unproject(after);

	camera.translate(before.x - after.x, before.y - after.y, 0);
  }

  @Override
  public boolean mouseMoved(int screenX, int screenY) {
	mouse.set(screenX, screenY, 0);
	return false;
  }

  @Override
  public boolean scrolled(int amount) {
	float newZoom = camera.zoom * (1 + (amount < 0 ? 0.1f : -0.1f));
	changeZoom(newZoom, mouse.x, mouse.y);
	return true;
  }

  @Override
  public boolean touchUp(int x, int y, int pointer, int button) {
	last.set(-1, -1, -1);
	return false;
  }

  public void panCamera(Vector2 pan) {
	Vector3 temp = new Vector3(pan, 0);
	camera.position.set(temp);
  }

  public void update() {
	camera.position.x = MathUtils.clamp(camera.position.x, (Gdx.graphics.getWidth() * camera.zoom) / 2,
		ResPack.WORLD_BACKGROUND.getRegionWidth() - (Gdx.graphics.getWidth() * camera.zoom) / 2);
	camera.position.y = MathUtils.clamp(camera.position.y, (Gdx.graphics.getHeight() * camera.zoom) / 2,
		ResPack.WORLD_BACKGROUND.getRegionHeight() - (Gdx.graphics.getHeight() * camera.zoom) / 2);
	camera.update();
  }
}