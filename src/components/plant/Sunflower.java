package components.plant;

import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import implement.Interactable;
import implement.Producable;
import javafx.scene.shape.Rectangle;

public class Sunflower extends GameCharacter implements Interactable, Producable {
	protected double time_count = 0;

	public Sunflower(int init_x, int init_y) {
		super("sunflowersprite.png", init_x, init_y, 75, 75, 100, 0);

		this.currentHP = maxHP;
		this.columns = 8;
		this.count = 8;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 75;
		this.width = 75;
		this.diffX = -10;
		this.diffY = 12;
		
		Rectangle hitbox = new Rectangle(40, 100);
		setBox(hitbox);
		
		createAnimation();
	}

	@Override
	public void produce() {

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
