package components.other;

import components.Entity;
import components.character.GameCharacter;
import implement.Interactable;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import scene.SceneController;

public class LawnMower extends Entity implements Interactable {

	private boolean isActive;

	public LawnMower(int init_x, int init_y, int width, int height) {
		super(init_x, init_y, width, height);

		this.imageView = new ImageView("lawnmower.png");
		this.imageView.setLayoutX(init_x);
		this.imageView.setLayoutY(init_y);
		this.getBox().setHeight(height - 30);
		this.getBox().setLayoutY(getY() + 30);
		SceneController.getInstance().getMainPane().getChildren().add(this.imageView);
		SceneController.getInstance().getMainPane().getChildren().add(this.box);
		isActive = true;
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		TranslateTransition move = new TranslateTransition();
		move.setNode(imageView);
		move.setToX(1200);
		move.play();
		move.setOnFinished(e -> {
			SceneController.getInstance().getMainPane().getChildren().remove(this.box);
			SceneController.getInstance().getMainPane().getChildren().remove(this.imageView);
		});
	}

	@Override
	public void interact(Bullet bullet) {

	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
