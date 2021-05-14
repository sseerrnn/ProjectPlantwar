package components.plant;

import components.character.GameCharacter;
import implement.Interactable;

public class Tallnut extends GameCharacter implements Interactable {

	public Tallnut(int init_x, int init_y) {
		super("tallnutsprite.png", init_x, init_y, 60, 75, 500, 0);
		// TODO Auto-generated constructor stub
		this.currentHP=maxHP;
		this.columns=9;
		this.count=9;
		this.offsetX=0;
		this.offsetY=0;
		this.height=75;
		this.width=60;
		this.diffX=1;
		this.diffY=15;
		
		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub

	}

}
