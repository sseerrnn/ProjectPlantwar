package components;

import javafx.animation.Animation;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Entity {
	protected int x;
	protected int y;

	protected Rectangle box;
	protected int width;
	protected int height;

	protected int init_x;
	protected int init_y;

	protected int velocity_x;
	protected int velocity_y;

	protected ImageView imageView;
	protected Animation animation;
	protected String img_path;

	public Entity(int init_x, int init_y, int width, int height) {
		this.init_x = init_x;
		this.init_y = init_y;
		
		box = new Rectangle(width, height);
		this.box.setFill(Color.TRANSPARENT);
		this.width = width;
		this.height = height;
		setX(init_x);
		setY(init_y);

	}

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle getBox() {
		return box;
	}

	public void setBox(Rectangle box) {
		this.box = box;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getInit_x() {
		return init_x;
	}

	public void setInit_x(int init_x) {
		this.init_x = init_x;
	}

	public int getInit_y() {
		return init_y;
	}

	public void setInit_y(int init_y) {
		this.init_y = init_y;
	}

	public int getVelocity_x() {
		return velocity_x;
	}

	public void setVelocity_x(int velocity_x) {
		this.velocity_x = velocity_x;
	}

	public int getVelocity_y() {
		return velocity_y;
	}

	public void setVelocity_y(int velocity_y) {
		this.velocity_y = velocity_y;
	}

}
