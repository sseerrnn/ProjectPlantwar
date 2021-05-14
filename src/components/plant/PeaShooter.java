package components.plant;

import components.character.GameCharacter;
import implement.Interactable;

public class PeaShooter extends GameCharacter implements Interactable {

	public PeaShooter( int init_x, int init_y) {
		super("peashootersprite.png", init_x, init_y, 75, 75, 100, 20);
		// TODO Auto-generated constructor stub
		this.currentHP=maxHP;
		this.columns=8;
		this.count=8;
		this.offsetX=0;
		this.offsetY=0;
		this.height=75;
		this.width=75;
		this.diffX=-10;
		this.diffY=13;
		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub

	}

}
