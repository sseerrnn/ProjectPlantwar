package components.other;

import components.Entity;
import components.character.Zombie;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import scene.SceneController;

public abstract class Bullet extends Entity {

	protected String img_path;
	protected int damage;
	protected TranslateTransition move;
	protected TranslateTransition moveBox;
	protected int row;

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
		this.setX(getX() + this.velocity_x);
		getImageView().setLayoutX(getX());
		getBox().setLayoutX(getX());
	}

	public void projectileRight() {
		this.velocity_y += 10;
		this.setX(getX() + this.velocity_x);
		getImageView().setLayoutX(getX());
		getBox().setLayoutX(getX());

		this.setY(getY() + this.velocity_y);
		getImageView().setLayoutY(getY());
		System.out.println("Y :" + getY());
		System.out.println("inity :" + getInit_y());
		if (getY() - getInit_y() > 100) {
			SceneController.getInstance().getMainPane().getChildren().remove(imageView);
			SceneController.getInstance().getMainPane().getChildren().remove(box);
		}
	}

	public int timeCalculate(Zombie zombie) {
		int sx = ((zombie.getX() - getX()) * 2) / 3;
		int vx = getVelocity_x() + zombie.getVelocity_x();

		return Math.abs(sx / vx);
	}

	public TranslateTransition getMove() {
		return move;
	}

	public void setMove(TranslateTransition move) {
		this.move = move;
	}

	public TranslateTransition getMovebox() {
		return moveBox;
	}

	public void setMovebox(TranslateTransition moveBox) {
		this.moveBox = moveBox;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

}
