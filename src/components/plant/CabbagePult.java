package components.plant;

import components.character.GameCharacter;
import components.character.Zombie;
import implement.Interactable;
import javafx.scene.shape.Rectangle;

public class CabbagePult extends GameCharacter implements Interactable {

	public CabbagePult(int init_x, int init_y) {
		super("cabbagepultsprite.png", init_x, init_y, 90, 95, 100, 30);
		// TODO Auto-generated constructor stub
	this.currentHP=maxHP;
	this.columns=6;
	this.count=6;
	this.offsetX=0;
	this.offsetY=0;
	this.height=95;
	this.width=90;
	this.diffX=-28;
	this.diffY=-9;
	Rectangle hitbox=new Rectangle(95,100);
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
		}
	}


}
