package components.zombie;

import components.character.GameCharacter;
import implement.Interactable;

public class ConeheadZombie extends GameCharacter implements Interactable {

	public ConeheadZombie(String img_path, int init_x, int init_y, int width, int height, int currentHP,
			int attackPoint) {
		super(img_path, init_x, init_y, width, height, 200, 35);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub

	}

}
