package components.plant;

import components.character.GameCharacter;
import implement.Interactable;

public class SnowPea extends GameCharacter implements Interactable {

	public SnowPea(int init_x, int init_y) {
		super("snowpeasprite.png", init_x, init_y, 80, 75, 100, 20);
		// TODO Auto-generated constructor stub
		this.currentHP=maxHP;
		this.columns=8;
		this.count=8;
		this.offsetX=0;
		this.offsetY=0;
		this.width=80;
		this.height=75;
		this.diffX=-15;
		this.diffY=15;
		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub

	}

}
