package de.katharinasabel.libgdxtutorial;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import de.katharinasabel.libgdxtutorial.util.ResPack;

public class Entity {

  public static enum EntityType {
	PLAYER, ENEMY;
  }

  public static enum ShipState {
	IDLE, MOVING, DEAD;
  }

  private EntityType type;
  private Sprite self;

  private Vector2 moveVector = new Vector2(0f, 1f);
  private float speed = 5f;

  public Entity(EntityType type) {
	this.type = type;
	moveVector.scl(speed);
  }

  public void loadResources() {
	if (type.equals(EntityType.PLAYER)) {

	  self = new Sprite(ResPack.SHIP_IDLE);
	}
  }

  public void idle() {
	self.setRegion(ResPack.SHIP_IDLE);
  }

  public void fly() {
	int i = new Random().nextInt(2);
	if (i == 0)
	  self.setRegion(ResPack.SHIP_IDLE);
	else if (i == 1)
	  self.setRegion(ResPack.SHIP_FLY1);
	else if (i == 2)
	  self.setRegion(ResPack.SHIP_FLY2);
  }

  /** Used to get access to methods */
  public Sprite getSelfSprite() {
	return self;
  }

  public Vector2 getMovement() {
	return moveVector;
  }

  public void setMovement(Vector2 moveVector) {
	this.moveVector = moveVector;
  }

  /** Will be called in the @render() method */
  public void draw(SpriteBatch batch) {
	self.draw(batch);
  }

  public float getSpeed() {
	return speed;
  }

}