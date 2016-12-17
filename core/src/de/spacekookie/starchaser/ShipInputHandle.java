package de.spacekookie.starchaser;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class ShipInputHandle extends InputAdapter {
	Vector2 shipPosition;

	enum TS {
		POS, NEG, NEUT
	};

	TS x = TS.NEUT, y = TS.NEUT;
	TS rotation = TS.NEUT;

	public ShipInputHandle(Vector2 shipPosition) {
		this.shipPosition = shipPosition;
	}

	public boolean keyDown(int keycode) {

		switch (keycode) {
		case Keys.W:
			y = TS.POS;
			break;
		case Keys.S:
			y = TS.NEG;
			break;
		case Keys.A:
			x = TS.NEG;
			break;
		case Keys.D:
			x = TS.POS;
			break;
		}

		return true;
	}

	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Keys.W:
			if (y == TS.POS)
				y = TS.NEUT;
			break;

		case Keys.S:
			if (y == TS.NEG)
				y = TS.NEUT;
			break;

		case Keys.A:
			if (x == TS.NEG)
				x = TS.NEUT;
			break;

		case Keys.D:
			if (x == TS.POS)
				x = TS.NEUT;
			break;
		}
		return true;
	}

	public void update() {
		if (x != TS.NEUT)
			shipPosition.x += (x == TS.POS) ? 1 : -1;
		if (y != TS.NEUT)
			shipPosition.y += (y == TS.POS) ? 1 : -1;
	}
}
