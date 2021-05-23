package components.plant;

import components.bullet.PeaBullet;
import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import implement.Interactable;
import implement.Shootable;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import scene.SceneController;

public class DoublePeaShooter extends GameCharacter implements Interactable, Shootable {

	public DoublePeaShooter(int init_x, int init_y) {
		super("doublepeashootersprite.png", init_x, init_y, 80, 80, 100, 20);

		this.currentHP = maxHP;
		this.columns = 5;
		this.count = 5;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 80;
		this.width = 80;
		this.diffX = -10;
		this.diffY = 11;

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
	public Bullet shoot() {
		Bullet bullet = new PeaBullet(this.getX() + 70, this.getY() + 13);
		System.out.println(bullet);
		SceneController.getInstance().getMainPane().getChildren().add(bullet.getImageView());
		SceneController.getInstance().getMainPane().getChildren().add(bullet.getBox());

		TranslateTransition move1 = new TranslateTransition();
		move1.setOnFinished(e -> this.shootZombie(2, 2));

		SequentialTransition seq = new SequentialTransition();
		seq.getChildren().addAll(move1);
		seq.play();

		return bullet;
	}

	@Override
	public void interact(Bullet bullet) {

	}

}
