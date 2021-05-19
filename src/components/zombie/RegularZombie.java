package components.zombie;

import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import gui.SpriteAnimation;
import implement.Interactable;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;

public class RegularZombie extends Zombie implements Interactable {

	public RegularZombie(int init_x, int init_y) {
		super("regularzombiesprite.png", init_x, init_y, 130, 100, 100, 35);
		// TODO Auto-generated constructor stub
		this.currentHP = maxHP;
		this.columns = 7;
		this.count = 7;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 130;
		this.width = 100;
		this.diffX = 0;
		this.diffY = -7;

		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		
	}

	@Override
	public void interact(Bullet bullet) {
		if (checkCollision(bullet)) {
			
			if (currentHP > 0) {
				this.setCurrentHP(currentHP - bullet.getDamage());
			}
			
			
		}
	}
	public void dokillZombie() {
		 if(this.getCurrentHP()<=0) {
			 imageView.setViewport(new Rectangle2D(offsetX, offsetY + 650, width, height));
				animation = new SpriteAnimation(imageView, Duration.millis(1000), 6, 6, offsetX, offsetY + 650,
						width, height);
				animation.setCycleCount(Animation.INDEFINITE);
				imageView.setLayoutX(getX());
				imageView.setLayoutY(getY());
				animation.play();
		 }
	 }

}
