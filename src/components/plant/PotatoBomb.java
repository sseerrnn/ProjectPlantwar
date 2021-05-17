package components.plant;

import components.character.GameCharacter;
import components.character.Zombie;
import gui.SpriteAnimation;
import implement.Explodable;
import implement.Interactable;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class PotatoBomb extends GameCharacter implements Interactable, Explodable {

	public PotatoBomb(int init_x, int init_y) {
		super("potatobombsprite.png", init_x, init_y, 100, 70, 100, 500);
		// TODO Auto-generated constructor stub
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
	public void explode() {
		// TODO Auto-generated method stub

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

}
