package components.plant;

import components.bullet.CornBullet;
import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import implement.Interactable;
import implement.Shootable;
import javafx.scene.shape.Rectangle;
import scene.SceneController;

public class CornPult extends GameCharacter implements Interactable, Shootable {

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

	@Override
	public Bullet shoot() {
		Bullet bullet = new CornBullet(this.getX() + 10, this.getY() + 10);
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
