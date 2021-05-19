package components.zombie;

import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import implement.Interactable;

public class ConeheadZombie extends Zombie implements Interactable {

	public ConeheadZombie(int init_x, int init_y) {
		super("coneheadzombiesprite.png", init_x, init_y, 130, 100, 200, 35);
		// TODO Auto-generated constructor stub
		this.currentHP = maxHP;
		this.columns = 7;
		this.count = 7;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 130;
		this.width = 100;
		this.diffX = 0;
		this.diffY = -7;

		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		
	}

	@Override
	public void interact(Bullet bullet) {
		if (checkCollision(bullet)) {
			this.shootZombie();
			if (currentHP > 0) {
				this.setCurrentHP(currentHP - bullet.getDamage());
			}
		}
	}

}
