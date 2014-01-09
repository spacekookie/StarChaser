package de.katharinasabel.libgdxtutorial.objects;

import java.util.HashSet;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {

  private Set<Entity> entities;

  public World() {
	entities = new HashSet<Entity>();
  }

  public Set<Entity> getEntities() {
	return entities;
  }

  public Entity getEntitityWithType(Entity.EntityType type) {
	for (Entity e : entities) {
	  if (e.getType() == type)
		return e;
	}
	return null;
  }

  public void addEntity(Entity e) {
	if (!entities.contains(e))
	  entities.add(e);
	else
	  Gdx.app.log("World", "Entity already in Set!");
  }

  public void removeEntitity(Entity e) {
	if (entities.contains(e))
	  entities.remove(e);
	else
	  Gdx.app.log("World", "Error! No such entity in world!");
  }

  public void update(SpriteBatch batch) {

	for (Entity e : entities) {
	  e.draw(batch);
	}

  }
}
