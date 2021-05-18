package components.bullet;

import components.other.Bullet;

public class CornBullet extends Bullet {

	public CornBullet(int initX, int initY) {

		super("butter2.png", initX, initY, 20, 21);
		this.init_y = initY;
		this.init_x = initX;
		this.x = initX;
		this.y = initY;
		this.imageView.setLayoutY(initY);
		this.imageView.setLayoutX(initX);
		damage = 15;

	}

}
