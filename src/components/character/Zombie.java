package components.character;

import components.zombie.BucketheadZombie;
import components.zombie.ConeheadZombie;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Zombie extends GameCharacter {

	public boolean isEat = false;
	public int slowUntil;
	public boolean haveHat;
	public boolean haveHead;

	public Zombie(String img_path, int init_x, int init_y, int width, int height, int currentHP, int attackPoint) {
		super(img_path, init_x, init_y, width, height, currentHP, attackPoint);

		Rectangle hitBox = new Rectangle(100, 90);
		hitBox.setLayoutX(getX());
		hitBox.setLayoutY(getY() + 35);
		hitBox.setFill(Color.TRANSPARENT);
		this.setBox(hitBox);

		this.velocity_x = 20;
		this.slowUntil = 0;
		this.haveHead = true;
		if (this instanceof ConeheadZombie || this instanceof BucketheadZombie) {
			this.haveHat = true;
		}
	}

	public void walkLeft() {
		if (!isEat) {
			this.setX(getX() - this.velocity_x);
			getImageView().setLayoutX(getX());
			getBox().setLayoutX(getX());
		}
	}

	public boolean isHaveHead() {
		return haveHead;
	}

	public void setHaveHead(boolean haveHead) {
		this.haveHead = haveHead;
	}

	public boolean isHaveHat() {
		return haveHat;
	}

	public void setHaveHat(boolean haveHat) {
		this.haveHat = haveHat;
	}

	public int getSlowUntil() {
		return slowUntil;
	}

	public void setSlowUntil(int slowUntil) {
		this.slowUntil = slowUntil;
	}

	public boolean isEat() {
		return isEat;
	}

	public void setEat(boolean isEat) {
		this.isEat = isEat;
	}

}
