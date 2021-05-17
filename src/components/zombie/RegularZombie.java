package components.zombie;

import components.character.GameCharacter;
import components.character.Zombie;
import implement.Interactable;

public class RegularZombie extends Zombie implements Interactable {

	public RegularZombie(int init_x, int init_y) {
		super("regularzombiesprite.png", init_x, init_y, 130, 100, 100, 35);
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
