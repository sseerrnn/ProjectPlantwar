package components.zombie;

import components.character.GameCharacter;
import implement.Interactable;

public class RegularZombie extends GameCharacter implements Interactable {

	public RegularZombie(int init_x, int init_y) {
		super("zombiewalk1.png", init_x, init_y, 100, 100, 100, 35);
		// TODO Auto-generated constructor stub
		this.currentHP=maxHP;
		this.columns=7;
		this.count=7;
		this.offsetX=0;
		this.offsetY=0;
		this.height=100;
		this.width=100;
		this.diffX=0;
		this.diffY=0;
		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub

	}

}
