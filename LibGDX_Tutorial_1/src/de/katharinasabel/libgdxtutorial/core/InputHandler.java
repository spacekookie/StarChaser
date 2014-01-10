package de.katharinasabel.libgdxtutorial.core;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import de.katharinasabel.libgdxtutorial.objects.Entity;
import de.katharinasabel.libgdxtutorial.objects.Entity.EntityType;
import de.katharinasabel.libgdxtutorial.objects.World;

public class InputHandler extends InputAdapter {

  private World world;
  private Entity e;
  private boolean moving, clock, counterClock, clicked;
  private Vector3 vec;
  private Vector3 target;
  private boolean shooting;

  public InputHandler(Object o) {

	if (o instanceof World && o != null)
	  this.world = (World) o;

	if (o instanceof Entity && o != null) {
	  this.e = (Entity) o;
	  return;
	}

	for (Entity e : world.getEntities()) {
	  if (e.getType() == EntityType.PLAYER) {
		this.e = e;
	  }
	  else {
		Gdx.app.log("InputHandler", "NO PLAYER IN WORLD!");
	  }
	}
  }

  public InputHandler(Entity e) {
	this.e = e;
  }

  @Override
  public boolean keyDown(int keycode) {
	if (keycode == Keys.W) {
	  moving = true;
	}
	if (keycode == Keys.A) {
	  counterClock = true;
	}
	if (keycode == Keys.D) {
	  clock = true;
	}
	if (keycode == Keys.SPACE) {
	  shooting = true;
	}
	return true;
  }

  @Override
  public boolean keyUp(int keycode) {
	if (keycode == Keys.W) {
	  moving = false;
	}
	if (keycode == Keys.A) {
	  counterClock = false;
	}
	if (keycode == Keys.D) {
	  clock = false;
	}
	return true;
  }

  // @Override
  // public boolean mouseMoved(int screenX, int screenY) {
  // Vector3 point = new Vector3(screenX, screenY, 0);
  // TutorialLauncher.getCameraInstance().unproject(point);
  //
  // float angle = new Vector2(point.x, point.y).angle() - 90;
  //
  // entity.getSelfSprite().setRotation(angle);
  // entity.getMovement().setAngle(angle + 90f);
  // return false;
  // }

  // @Override
  // public boolean touchDown(int x, int y, int pointer, int button) {
  // if (pointer == 0) {
  // if (button == 0) {
  // vec = new Vector3(x, y, 0);
  // TutorialLauncher.getCameraInstance().unproject(vec);
  // target = new Vector3(vec);
  // clicked = true;
  // return true;
  // }
  // }
  // return false;
  // }

  public void update() {

	if (moving) {
	  Vector2 temp = new Vector2(e.getPosition().x, e.getPosition().y);
	  temp.add(e.getMovement());
	  e.setPosition(temp);
	  e.updatePosition();
	  e.fly();
	}
	else {
	  e.idle();
	}
	if (counterClock) {
	  e.getMovement().rotate(5f);
	  e.getSelfSprite().rotate(5f);
	}
	if (clock) {
	  e.getMovement().rotate(-5f);
	  e.getSelfSprite().rotate(-5f);
	}
	if (shooting) {

	}
	// }

	// if (clicked) {
	// entity.fly();
	// Vector2 temp = new Vector2(entity.getSelfSprite().getX(), entity
	// .getSelfSprite().getY());
	// temp.lerp(new Vector2(vec.x, vec.y), 0.1f);
	//
	// entity.getSelfSprite().setPosition(temp.x, temp.y);
	//
	// if (target.dst(temp.x, temp.y, 0) < 2)
	// clicked = false;
	//
	// } else {
	// entity.idle();
	// }
  }
}