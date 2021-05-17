package components.plant;

import components.character.GameCharacter;
import components.character.Zombie;
import implement.Interactable;
import javafx.scene.shape.Rectangle;

public class CornPult extends GameCharacter implements Interactable {

	public CornPult(int init_x, int init_y) {
		super("cornpultsprite.png", init_x, init_y, 76, 105, 100, 15);
		// TODO Auto-generated constructor stub
		this.currentHP = maxHP;
		this.columns = 4;
		this.count = 4;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 105;
		this.width = 76;
		this.diffX = -15;
		this.diffY = -18;
		Rectangle hitbox = new Rectangle(40, 100);
		setBox(hitbox);
		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub
//		System.out.println(checkCollision(gameCharacter));
		if (gameCharacter instanceof Zombie && checkCollision(gameCharacter)) {

			((Zombie) gameCharacter).isEat = true;
			if (currentHP > 0) {
				this.setCurrentHP(currentHP - gameCharacter.getAttackPoint());
			}

		}
	}

}
