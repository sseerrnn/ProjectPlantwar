package components.character;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Zombie extends GameCharacter{

	public Zombie(String img_path, int init_x, int init_y, int width, int height, int currentHP, int attackPoint) {
		super(img_path, init_x, init_y, width, height, currentHP, attackPoint);
		// TODO Auto-generated constructor stub
		this.setBox(new Rectangle(100, 50));
		this.getBox().setFill(Color.BLACK);
		
	}
	public void walkleft() {
		TranslateTransition move = new TranslateTransition();
		//code more to change animation
		move.setNode(this.getImageView());
		move.setDuration(Duration.seconds(40));
		move.setToX(-1400);
		move.play();
		
	}
	

}
