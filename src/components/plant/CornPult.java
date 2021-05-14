package components.plant;

import components.character.GameCharacter;
import implement.Interactable;

public class CornPult extends GameCharacter implements Interactable {

	public CornPult(int init_x, int init_y) {
		super("cornpultsprite.png", init_x, init_y, 76, 105, 100, 15);
		// TODO Auto-generated constructor stub
		this.currentHP=maxHP;
		this.columns=4;
		this.count=4;
		this.offsetX=0;
		this.offsetY=0;
		this.height=105;
		this.width=76;
		this.diffX=-15;
		this.diffY=-18;
		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub

	}

}
