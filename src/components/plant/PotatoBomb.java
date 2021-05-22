package components.plant;

import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import gui.SpriteAnimation;
import implement.Explodable;
import implement.Interactable;
import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PotatoBomb extends GameCharacter implements Interactable, Explodable {

	private int time;
	private int timeCount = 10;

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public PotatoBomb(int init_x, int init_y) {
		super("potatobombsprite.png", init_x, init_y, 100, 70, 100, 500);

		this.currentHP = maxHP;
		this.columns = 5;
		this.count = 5;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 70;
		this.width = 100;
		this.diffX = -22;
		this.diffY = 15;

		Rectangle hitbox = new Rectangle(40, 100);
		setBox(hitbox);

		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		if (gameCharacter instanceof Zombie && checkCollision(gameCharacter)) {
			this.animation.stop();
			gameCharacter.doEatPlant();
			((Zombie) gameCharacter).isEat = true;

			if (currentHP > 0) {
				this.setCurrentHP(currentHP - gameCharacter.getAttackPoint());
			}
		}
	}

	@Override
	public void explode(GameCharacter gameCharacter) {
		if (gameCharacter instanceof Zombie && checkCollision(gameCharacter)) {
			
			TranslateTransition explosion = new TranslateTransition();
			explosion.setOnFinished(e -> this.explodeAnimation());
			
			TranslateTransition delete = new TranslateTransition();
			delete.setOnFinished(e -> {
				gameCharacter.setCurrentHP(0);
				this.currentHP = 0;
});
			
			SequentialTransition seq = new SequentialTransition();
			seq.getChildren().addAll(explosion,delete);
			seq.play();
			
		}
	}

	public void createAnimation() {
		imageView = new ImageView(img_path);
		imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
		animation = new SpriteAnimation(imageView, Duration.seconds(10), count, columns, offsetX, offsetY, width,
				height);

		imageView.setLayoutX(init_x);
		imageView.setLayoutY(init_y);
		animation.play();
	}

	public int getTimeCount() {
		return timeCount;
	}

	public void setTimeCount(int timeCount) {
		this.timeCount = timeCount;
	}

	@Override
	public void interact(Bullet bullet) {

	}



}
