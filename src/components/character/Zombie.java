package components.character;

import components.zombie.BucketheadZombie;
import components.zombie.ConeheadZombie;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Zombie extends GameCharacter {

	public boolean isEat = false;
	public boolean hasHat;
	public boolean hasHead;

	public Zombie(String img_path, int init_x, int init_y, int width, int height, int currentHP, int attackPoint) {
		super(img_path, init_x, init_y, width, height, currentHP, attackPoint);

		Rectangle hitBox = new Rectangle(100, 90);
		hitBox.setLayoutX(getX());
		hitBox.setLayoutY(getY() + 35);
		hitBox.setFill(Color.TRANSPARENT);
		this.setBox(hitBox);

		this.velocity_x = 20;
		this.hasHead = true;

		if (this instanceof ConeheadZombie || this instanceof BucketheadZombie) {
			this.hasHat = true;
		}
	}

	public void walkLeft() {
		if (!isEat) {
			this.setX(getX() - this.velocity_x);
			getImageView().setLayoutX(getX());
			getBox().setLayoutX(getX());
		}
	}

	public boolean isHasHead() {
		return hasHead;
	}

	public void setHaveHead(boolean hasHead) {
		this.hasHead = hasHead;
	}

	public boolean isHasHat() {
		return hasHat;
	}

	public void setHasHat(boolean hasHat) {
		this.hasHat = hasHat;
	}

	public boolean isEat() {
		return isEat;
	}

	public void setEat(boolean isEat) {
		this.isEat = isEat;
	}

}
