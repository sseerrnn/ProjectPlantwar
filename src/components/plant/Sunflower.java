package components.plant;

import components.character.GameCharacter;
import implement.Interactable;
import implement.Producable;
import javafx.scene.shape.Rectangle;

public class Sunflower extends GameCharacter implements Interactable, Producable {
	protected double time_count = 0;

	public Sunflower(int init_x, int init_y) {
		super("sunflowersprite.png", init_x, init_y, 75, 75, 100, 0);
		// TODO Auto-generated constructor stub
		this.currentHP=maxHP;
		this.columns=8;
		this.count=8;
		this.offsetX=0;
		this.offsetY=0;
		this.height=75;
		this.width=75;
		this.diffX=-10;
		this.diffY=12;
		Rectangle hitbox=new Rectangle(95,100);
		setBox(hitbox);
		createAnimation();
	}

	@Override
	public void produce() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		// TODO Auto-generated method stub

	}

}
