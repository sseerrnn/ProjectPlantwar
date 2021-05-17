package components.character;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import scene.SceneController;

public class Zombie extends GameCharacter {
	public boolean isEat = false;

	public Zombie(String img_path, int init_x, int init_y, int width, int height, int currentHP, int attackPoint) {
		super(img_path, init_x, init_y, width, height, currentHP, attackPoint);
		// TODO Auto-generated constructor stub
		Rectangle hitBox = new Rectangle(100, 100);
		hitBox.setLayoutX(getX());
		hitBox.setLayoutY(getY() + 30);
		hitBox.setFill(Color.TRANSPARENT);
		this.setBox(hitBox);
		this.velocity_x = 20;

	}

	public void walkLeft() {
		if (!isEat) {

			// code more to change animation
			this.setX(getX() - this.velocity_x);
			getImageView().setLayoutX(getX());
			getBox().setLayoutX(getX());
		}

	}

	public boolean isEat() {
		return isEat;
	}

	public void setEat(boolean isEat) {
		this.isEat = isEat;
	}
	

}
