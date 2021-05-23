package components.bullet;

import components.other.Bullet;

public class CabbageBullet extends Bullet {

	public CabbageBullet(int initX, int initY) {
		super("cabbage.png", initX, initY, 25, 25);
		this.init_y = initY;
		this.init_x = initX;
		this.x = initX;
		this.y = initY;
		this.imageView.setLayoutY(initY);
		this.imageView.setLayoutX(initX);
		this.damage = 30;
	}

}
