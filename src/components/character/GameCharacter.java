package components.character;

import gui.SpriteAnimation;
import components.Entity;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class GameCharacter extends Entity {
	protected int maxHP;
	protected int currentHP;
	protected int attackPoint;

	protected int count;
	protected int columns;
	protected int offsetX;
	protected int offsetY;
	protected int width;
	protected int height;

	public GameCharacter(String img_path, int init_x, int init_y, int width, int height, int currentHP,
			int attackPoint) {
		super(init_x, init_y, width, height);
		this.currentHP = currentHP;
		this.maxHP = currentHP;
		this.attackPoint = attackPoint;
		this.img_path = img_path;

	}

	public void createAnimation() {
		imageView = new ImageView(img_path);
		imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
		animation = new SpriteAnimation(imageView, Duration.millis(1000), count, columns, offsetX, offsetY, width,
				height);
		animation.setCycleCount(Animation.INDEFINITE);
		imageView.setLayoutX(init_x);
		imageView.setLayoutY(init_y);
		animation.play();
	}

}