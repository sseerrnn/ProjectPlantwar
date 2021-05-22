package components.zombie;

import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import implement.Interactable;
import javafx.application.Platform;
import scene.SceneController;

public class RegularZombie extends Zombie implements Interactable {

	public RegularZombie(int init_x, int init_y) {
		super("regularzombiesprite.png", init_x, init_y, 130, 100, 100, 35);

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
			
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					SceneController.getInstance().getMainPane().getChildren().remove(bullet.getImageView());
					SceneController.getInstance().getMainPane().getChildren().remove(bullet.getBox());
					
				}
			});
			if (currentHP > 0) {
				this.setCurrentHP(currentHP - bullet.getDamage());
			}
		}
	}

}
