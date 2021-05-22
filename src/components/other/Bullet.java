package components.other;

import components.Entity;
import components.bullet.SnowBullet;
import components.character.Zombie;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import scene.SceneController;

public abstract class Bullet extends Entity {

	protected String img_path;
	protected int damage;
	protected TranslateTransition move;
	protected TranslateTransition movebox;
	protected int Row;

	public int getRow() {
		return Row;
	}

	public void setRow(int row) {
		Row = row;
	}

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
//		move = new TranslateTransition();
//		move.setNode(imageView);
//		move.setToX(1200);
//		move.setDuration(Duration.seconds(5));
//		setX(1200);
//		move.play();
//
//		movebox = new TranslateTransition();
//		movebox.setNode(box);
//		movebox.setToX(1200);
//		movebox.setDuration(Duration.seconds(5));

//		movebox.play();
		
		this.setX(getX() + this.velocity_x);
		getImageView().setLayoutX(getX());
		getBox().setLayoutX(getX());
	}
//	public void projectileRight(Zombie zombie) {
//		move = new TranslateTransition();
//		move.setNode(imageView);
//		move.setToX(zombie.getX()-getX());
//		move.setDuration(Duration.seconds(timeCalculate(zombie)));
//		TranslateTransition move_y=new TranslateTransition();
//		move.play();
//		move_y.setNode(imageView);
//		move_y.setToY(-100);
//		move_y.setDuration(Duration.seconds(timeCalculate(zombie)/2));
//		move_y.play();
//		move_y.setOnFinished(e->{
//			move_y.setToY(0);
//			move_y.setDuration(Duration.seconds(timeCalculate(zombie)/2));
//			move_y.play();
//			
//		});
//		
//
//		movebox = new TranslateTransition();
//		movebox.setNode(box);
//		movebox.setToX(zombie.getX()-getX());
//		movebox.setDuration(Duration.seconds(timeCalculate(zombie)));
//
//		movebox.play();
//		setX(getX()+zombie.getX());
//	}
	public void projectileRight() {
		this.velocity_y+=10;
		this.setX(getX() + this.velocity_x);
		getImageView().setLayoutX(getX());
		getBox().setLayoutX(getX());
		
		
		this.setY(getY()+this.velocity_y);
		getImageView().setLayoutY(getY());
		System.out.println("Y :"+getY());
		System.out.println("inity :"+getInit_y());
		if (getY()-getInit_y()>100) {
			SceneController.getInstance().getMainPane().getChildren().remove(imageView);
			SceneController.getInstance().getMainPane().getChildren().remove(box);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public int timeCalculate(Zombie zombie) {
		int sx = ((zombie.getX() - getX())*2)/3;
		int vx = getVelocity_x() + zombie.getVelocity_x();

		return Math.abs(sx/vx);

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
