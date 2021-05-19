package components.plant;

import components.bullet.CabbageBullet;
import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import implement.Interactable;
import implement.Shootable;
import javafx.scene.shape.Rectangle;
import scene.SceneController;

public class CabbagePult extends GameCharacter implements Interactable, Shootable {

	public CabbagePult(int init_x, int init_y) {
		super("cabbagepultsprite.png", init_x, init_y, 90, 95, 100, 30);
		// TODO Auto-generated constructor stub
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
		Bullet bullet = new CabbageBullet(this.getX() + 10, this.getY() + 10);
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
