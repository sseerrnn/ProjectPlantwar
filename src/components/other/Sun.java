package components.other;

import java.util.Random;

import components.Entity;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Sun extends Entity {

	public Sun() {
		super(0, 0, 54, 50);
		// TODO Auto-generated constructor stub
		this.init_x = randomX();
		this.init_y = -100;
		this.width = 54;
		this.height = 50;
		img_path = "sun.png";
	}

	public void toFalling(ImageView imageView) {
		imageView.setVisible(true);
		TranslateTransition move = new TranslateTransition();
		move.setNode(imageView);
		imageView.setVisible(true);
		move.setDuration(Duration.millis(1500));
		move.setToY(randomY());
		move.play();
	}

	public int randomY() {
		Random random = new Random();
		int y = 200 + random.nextInt(860);
		return y;

	}

	public int randomX() {
		Random random = new Random();
		int x = 240 + random.nextInt(860);
		return x;
	}

	public void toImageView() {
		this.imageView = new ImageView(img_path);
		imageView.setLayoutX(init_x);
		imageView.setLayoutY(init_y);
	}

	public void moveOut(ImageView imageView) {
		TranslateTransition move = new TranslateTransition();
		move.setNode(imageView);
		move.setToX(21 - x);
		move.setToY(20 - y);
		move.play();
		imageView.setVisible(false);
	}

}
