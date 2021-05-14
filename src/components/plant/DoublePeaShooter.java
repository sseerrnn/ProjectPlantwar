package components.plant;

import components.character.GameCharacter;
import implement.Interactable;

public class DoublePeaShooter extends GameCharacter implements Interactable {

	public DoublePeaShooter(int init_x, int init_y) {
		super("doublepeashootersprite.png", init_x, init_y, 80, 80, 100, 20);
		// TODO Auto-generated constructor stub
		this.currentHP=maxHP;
		this.columns=5;
		this.count=5;
		this.offsetX=0;
		this.offsetY=0;
		this.height=80;
		this.width=80;
		this.diffX=-10;
		this.diffY=11;
		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub

	}

}
