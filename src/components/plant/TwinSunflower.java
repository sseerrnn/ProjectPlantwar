package components.plant;

import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import implement.Interactable;
import implement.Producable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TwinSunflower extends GameCharacter implements Interactable, Producable {

	public TwinSunflower(int init_x, int init_y) {
		super("twinsunflowersprite.png", init_x, init_y, 90, 75, 100, 0);
		// TODO Auto-generated constructor stub
		this.currentHP = maxHP;
		this.columns = 8;
		this.count = 8;
		this.offsetX = 0;
		this.offsetY = 0;
		this.width = 90;
		this.height = 75;
		this.diffX = -15;
		this.diffY = 13;
		Rectangle hitbox = new Rectangle(40, 100);

		setBox(hitbox);
		createAnimation();
	}

	@Override
	public void produce() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub
//		System.out.println(checkCollision(gameCharacter));
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
		// TODO Auto-generated method stub
		
	}

}
