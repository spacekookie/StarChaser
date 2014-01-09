package de.katharinasabel.libgdxtutorial.objects;

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
	PLAYER, ENEMY, STATION, PLANET, STAR;
  }

  public static enum ShipState {
	IDLE, MOVING, DEAD;
  }

  private EntityType type;
  private Sprite self;

  private float speed = 5f;
  private Vector2 moveVector = new Vector2(0f, 1f);
  private Vector2 position;

  public Entity(EntityType type) {
	this.type = type;
	loadResources();
	moveVector.scl(speed);
	position = new Vector2(200, 200);
	updatePosition();
  }

  public Entity(EntityType type, Vector2 position) {
	this.type = type;
	loadResources();
	moveVector.scl(speed);
	this.position = position;
	updatePosition();
  }

  public void updatePosition() {
	self.setPosition(position.x, position.y);
  }

  public void loadResources() {
	switch (type) {
	case PLAYER:
	  self = new Sprite(ResPack.SHIP_IDLE);
	  break;
	case PLANET:
	  self = new Sprite(ResPack.WORLD_EARTH);
	  self.setScale(2f);
	  break;
	case STATION:
	  self = new Sprite(ResPack.WORLD_STATION1);
	  self.setScale(1.5f);
	  break;
	case STAR:
	  self = new Sprite(ResPack.WORLD_SUN);
	  self.setScale(2f);
	  break;

	default:
	  Gdx.app.log("Entity", "EntityType not found!");
	  break;
	}
  }

  public void idle() {
	self.setRegion(ResPack.SHIP_IDLE);
  }

  public void fly() {
	int i = new Random().nextInt(3);
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

  public EntityType getType() {
	return type;
  }

  private void setType(EntityType type) {
	this.type = type;
  }

  public Vector2 getPosition() {
	return position;
  }

  public void setPosition(Vector2 position) {
	this.position = position;
  }

}