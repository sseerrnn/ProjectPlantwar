package components.other;

import components.Entity;
import components.character.GameCharacter;
import implement.Interactable;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import scene.SceneController;

public class Lawnmower extends Entity implements Interactable{

	public Lawnmower(int init_x, int init_y, int width, int height) {
		super(init_x, init_y, width, height);
		// TODO Auto-generated constructor stub
		this.imageView =new ImageView("lawnmower.png");
		this.imageView.setLayoutX(init_x);
		this.imageView.setLayoutY(init_y);
		this.getBox().setHeight(height-30);
		this.getBox().setLayoutY(getY()+30);
		SceneController.getInstance().getMainPane().getChildren().add(this.imageView);
		SceneController.getInstance().getMainPane().getChildren().add(this.box);
		
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub
		if (this.getBox().getBoundsInParent().intersects(gameCharacter.getBox().getBoundsInParent())) {
			TranslateTransition move = new TranslateTransition();
			move.setNode(imageView);
			move.setToX(1200);
			move.play();
			move.setOnFinished( e->{
				SceneController.getInstance().getMainPane().getChildren().remove(this.imageView);
				SceneController.getInstance().getMainPane().getChildren().remove(this.box);
			});
			
		}
		
	}

	@Override
	public void interact(Bullet bullet) {
		// TODO Auto-generated method stub
		
	}

}
