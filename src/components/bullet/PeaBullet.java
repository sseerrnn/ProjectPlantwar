package components.bullet;

import components.other.Bullet;

public class PeaBullet extends Bullet {

	public PeaBullet( int initX, int initY) {

		super("pea.png",  initX, initY, 18, 18);
		
		damage = 20;

	}

}
