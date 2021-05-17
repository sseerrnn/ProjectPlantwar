package components.plant;

import components.character.GameCharacter;
import components.character.Zombie;
import implement.Interactable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wallnut extends GameCharacter implements Interactable {

	public Wallnut(int init_x, int init_y) {
		super("wallnutstandby.png", init_x, init_y, 54, 64, 300, 0);
		// TODO Auto-generated constructor stub
		this.currentHP = maxHP;
		this.columns = 5;
		this.count = 5;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 64;
		this.width = 54;
		this.diffX = 1;
		this.diffY = 22;
		Rectangle hitbox = new Rectangle(95, 100);

		setBox(hitbox);

		createAnimation();

	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub
//		System.out.println(checkCollision(gameCharacter));
		if (gameCharacter instanceof Zombie && checkCollision(gameCharacter)) {
			gameCharacter.doEatPlant();
			((Zombie)gameCharacter).isEat=true;
			if(currentHP>0) {
			this.setCurrentHP(currentHP-gameCharacter.getAttackPoint());
			}
		}
	}

}
