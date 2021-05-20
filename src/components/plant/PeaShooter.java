package components.plant;

import components.bullet.PeaBullet;
import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import implement.Interactable;
import implement.Shootable;
import javafx.scene.shape.Rectangle;
import scene.SceneController;

public class PeaShooter extends GameCharacter implements Interactable, Shootable {

	public PeaShooter(int init_x, int init_y) {
		super("peashootersprite.png", init_x, init_y, 75, 75, 100, 20);

		this.currentHP = maxHP;
		this.columns = 8;
		this.count = 8;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 75;
		this.width = 75;
		this.diffX = -10;
		this.diffY = 13;
		
		Rectangle hitbox = new Rectangle(40, 100);
		setBox(hitbox);
		
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
	public Bullet shoot() {
		Bullet bullet = new PeaBullet(this.getX() + 70, this.getY() + 10);
		System.out.println(bullet);
		SceneController.getInstance().getMainPane().getChildren().add(bullet.getImageView());
		SceneController.getInstance().getMainPane().getChildren().add(bullet.getBox());
		this.shootZombie(3, 3);
		return bullet;
	}

	@Override
	public void interact(Bullet bullet) {

	}

}
