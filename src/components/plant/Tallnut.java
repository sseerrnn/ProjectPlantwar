package components.plant;

import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import implement.Interactable;
import javafx.scene.shape.Rectangle;

public class Tallnut extends GameCharacter implements Interactable {

	public Tallnut(int init_x, int init_y) {
		super("tallnutsprite.png", init_x, init_y, 60, 75, 500, 0);

		this.currentHP = maxHP;
		this.columns = 9;
		this.count = 9;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 75;
		this.width = 60;
		this.diffX = 1;
		this.diffY = 15;

		Rectangle hitBox = new Rectangle(40, 100);
		setBox(hitBox);

		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		if (gameCharacter instanceof Zombie && checkCollision(gameCharacter)) {
			gameCharacter.doEatPlant();
			((Zombie) gameCharacter).isEat = true;
			if (currentHP > 0) {
				this.setCurrentHP(currentHP - gameCharacter.getAttackPoint());
			}
		}
	}

	@Override
	public void interact(Bullet bullet) {

	}

}
