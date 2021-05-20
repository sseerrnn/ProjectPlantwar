package components.other;

import components.Entity;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public abstract class Bullet extends Entity {

	protected String img_path;
	protected int damage;
	protected TranslateTransition move;
	protected TranslateTransition movebox;

	public Bullet(String img_path, int initX, int initY, int width, int height) {
		super(initX, initY, width, height);
		this.img_path = img_path;

		this.velocity_x = 40;
		this.imageView = new ImageView(img_path);

		box = new Rectangle(width, height);
		box.setFill(Color.TRANSPARENT);
		box.setLayoutX(getX());
		box.setLayoutY(getY());
		setBox(box);
	}

	public void shootRight() {
		move = new TranslateTransition();
		move.setNode(imageView);
		move.setToX(1200);
		move.setDuration(Duration.seconds(5));
		setX(1200);
		move.play();

		movebox = new TranslateTransition();
		movebox.setNode(box);
		movebox.setToX(1200);
		movebox.setDuration(Duration.seconds(5));

		movebox.play();
//		this.setX(getX() + this.velocity_x);
//		getImageView().setLayoutX(getX());
//		getBox().setLayoutX(getX());
	}

	public TranslateTransition getMove() {
		return move;
	}

	public void setMove(TranslateTransition move) {
		this.move = move;
	}

	public TranslateTransition getMovebox() {
		return movebox;
	}

	public void setMovebox(TranslateTransition movebox) {
		this.movebox = movebox;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}
