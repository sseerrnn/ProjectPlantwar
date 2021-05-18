package components.bullet;

import components.other.Bullet;

public class PeaBullet extends Bullet {

	public PeaBullet(boolean isRight, int initX, int initY) {

		super("pea.png", isRight, initX, initY, 18, 18);
		this.imageView.setScaleX(12);
		this.imageView.setScaleY(12);
		damage = 20;

	}

}
