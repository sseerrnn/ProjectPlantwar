package components.bullet;

import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;

public class SnowBullet extends Bullet {

	public SnowBullet(int initX, int initY) {
		super("snow.png", initX, initY, 19, 19);
		this.init_y = initY;
		this.init_x = initX;
		this.x = initX;
		this.y = initY;
		this.imageView.setLayoutY(initY);
		this.imageView.setLayoutX(initX);
		damage = 20;
	}

}
