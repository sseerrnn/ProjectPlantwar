package components.zombie;

import components.character.GameCharacter;
import components.character.Zombie;
import implement.Interactable;

public class BucketheadZombie extends Zombie implements Interactable {

	public BucketheadZombie(int init_x, int init_y) {
		super("bucketheadzombiesprite.png", init_x, init_y, 130, 100, 500, 35);
		// TODO Auto-generated constructor stub
		this.currentHP = maxHP;
		this.columns = 7;
		this.count = 7;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 130;
		this.width = 100;
		this.diffX = 0;
		this.diffY = -7;

		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub

	}

}
