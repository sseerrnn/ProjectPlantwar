package components.plant;

import components.bullet.CabbageBullet;
import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import implement.Interactable;
import implement.Shootable;
import implement.Throwable;
import javafx.scene.shape.Rectangle;
import scene.SceneController;

public class CabbagePult extends GameCharacter implements Interactable, Throwable {

	public CabbagePult(int init_x, int init_y) {
		super("cabbagepultsprite.png", init_x, init_y, 90, 95, 100, 30);

		this.currentHP = maxHP;
		this.columns = 6;
		this.count = 6;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 95;
		this.width = 90;
		this.diffX = -28;
		this.diffY = -9;
		
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
	public void interact(Bullet bullet) {
		
	}

	@Override
	public Bullet projectile() {
		Bullet bullet = new CabbageBullet(this.getX() + 10, this.getY() + 10);
		System.out.println(bullet);
		SceneController.getInstance().getMainPane().getChildren().add(bullet.getImageView());
		SceneController.getInstance().getMainPane().getChildren().add(bullet.getBox());
		this.shootZombie(9, 9);
		return bullet;
	}

}
