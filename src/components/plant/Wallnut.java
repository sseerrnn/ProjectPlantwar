package components.plant;

import components.character.GameCharacter;
import implement.Interactable;

public class Wallnut extends GameCharacter implements Interactable {

	public Wallnut(int init_x, int init_y) {
		super("wallnutstandby.png", init_x, init_y, 54, 64, 300, 0);
		// TODO Auto-generated constructor stub
		this.currentHP=maxHP;
		this.columns=5;
		this.count=5;
		this.offsetX=0;
		this.offsetY=0;
		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub

	}

}
