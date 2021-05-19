package components.other;

import components.Entity;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Bullet extends Entity {

	protected String img_path;
	protected int damage;

	public Bullet(String img_path, int initX, int initY, int width, int height) {
		super(initX, initY, width, height);
		this.img_path = img_path;

		this.velocity_x = 40;
		this.imageView = new ImageView(img_path);

	}

	public void shootRight() {
		this.setX(getX() + this.velocity_x);
		getImageView().setLayoutX(getX());
		getBox().setLayoutX(getX());
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}
