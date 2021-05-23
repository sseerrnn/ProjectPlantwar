package components.bullet;

import components.other.Bullet;

public class PeaBullet extends Bullet {

	public PeaBullet(int initX, int initY) {
		super("pea.png", initX, initY, 18, 18);
		this.init_y = initY;
		this.init_x = initX;
		this.x = initX;
		this.y = initY;
		this.imageView.setLayoutY(getY());
		this.imageView.setLayoutX(getX());
		this.damage = 20;
	}

}
