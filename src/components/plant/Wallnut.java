package components.plant;

import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import implement.Interactable;
import javafx.scene.shape.Rectangle;

public class Wallnut extends GameCharacter implements Interactable {

	public Wallnut(int init_x, int init_y) {
		super("wallnutstandby.png", init_x, init_y, 54, 64, 300, 0);

		this.currentHP = maxHP;
		this.columns = 5;
		this.count = 5;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 64;
		this.width = 54;
		this.diffX = 1;
		this.diffY = 22;

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
