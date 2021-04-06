package components.plant;

import components.character.GameCharacter;
import implement.Interactable;
import implement.Producable;

public class TwinSunflower extends GameCharacter implements Interactable, Producable {

	public TwinSunflower(String img_path, int init_x, int init_y, int width, int height, int currentHP,
			int attackPoint) {
		super(img_path, init_x, init_y, width, height, 100, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void produce() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub

	}

}
