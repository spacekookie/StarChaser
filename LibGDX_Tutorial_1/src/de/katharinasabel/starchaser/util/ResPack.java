package de.katharinasabel.starchaser.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/** Class to load all assets for the game */
public class ResPack {

  private static final TextureAtlas _PIXEL = new TextureAtlas(
	  Gdx.files.internal("graphics/USS_Pixel/packed/USS_Pixel.atlas"));
  private static final TextureAtlas _WORLD = new TextureAtlas(
	  Gdx.files.internal("graphics/world/packed/world.atlas"));

  /** UI SKIN */
  public static final Skin _SKIN = new Skin(Gdx.files.internal("data/skin/uiskin.json"));

  /** Ship textures */
  public static final TextureRegion SHIP_IDLE = _PIXEL.findRegion("ship_idle");
  public static final TextureRegion SHIP_FLY1 = _PIXEL.findRegion("ship_fly1");
  public static final TextureRegion SHIP_FLY2 = _PIXEL.findRegion("ship_fly2");

  /** Environment textures */

  public static final TextureRegion WORLD_BACKGROUND = _WORLD.findRegion("space");
  public static final TextureRegion WORLD_STATION1 = _WORLD.findRegion("deep_pixel_nine");
  public static final TextureRegion WORLD_SUN = _WORLD.findRegion("pixel_star");
  public static final TextureRegion WORLD_EARTH = _WORLD.findRegion("pixel_earth");

}
