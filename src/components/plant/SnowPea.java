package components.plant;

import components.bullet.SnowBullet;
import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import implement.Interactable;
import implement.Shootable;
import javafx.scene.shape.Rectangle;
import scene.SceneController;

public class SnowPea extends GameCharacter implements Interactable, Shootable {

	public SnowPea(int init_x, int init_y) {
		super("snowpeasprite.png", init_x, init_y, 80, 75, 100, 20);
		// TODO Auto-generated constructor stub
		this.currentHP = maxHP;
		this.columns = 8;
		this.count = 8;
		this.offsetX = 0;
		this.offsetY = 0;
		this.width = 80;
		this.height = 75;
		this.diffX = -15;
		this.diffY = 15;
		Rectangle hitbox = new Rectangle(40, 100);
		setBox(hitbox);
		createAnimation();
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
	public Bullet shoot() {
		Bullet bullet = new SnowBullet(this.getX() + 15, this.getY() + 12);
		System.out.println(bullet);
		SceneController.getInstance().getMainPane().getChildren().add(bullet.getImageView());
		SceneController.getInstance().getMainPane().getChildren().add(bullet.getBox());
		return bullet;
	}

	@Override
	public void interact(Bullet bullet) {
		// TODO Auto-generated method stub
		
	}

}
