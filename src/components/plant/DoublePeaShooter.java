package components.plant;

import components.character.GameCharacter;
import components.character.Zombie;
import implement.Interactable;
import javafx.scene.shape.Rectangle;

public class DoublePeaShooter extends GameCharacter implements Interactable {

	public DoublePeaShooter(int init_x, int init_y) {
		super("doublepeashootersprite.png", init_x, init_y, 80, 80, 100, 20);
		// TODO Auto-generated constructor stub
		this.currentHP = maxHP;
		this.columns = 5;
		this.count = 5;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 80;
		this.width = 80;
		this.diffX = -10;
		this.diffY = 11;
		Rectangle hitbox = new Rectangle(40, 100);
		setBox(hitbox);
		createAnimation();
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub
//		System.out.println(checkCollision(gameCharacter));
		if (gameCharacter instanceof Zombie && checkCollision(gameCharacter)) {
			gameCharacter.doEatPlant();
<<<<<<< Updated upstream
			((Zombie)gameCharacter).isEat=true;
			if(currentHP>0) {
				this.setCurrentHP(currentHP-gameCharacter.getAttackPoint());
				}
||||||| ancestor
			((Zombie)gameCharacter).isEat=true;
=======
			((Zombie) gameCharacter).isEat = true;
>>>>>>> Stashed changes
		}
	}

}
