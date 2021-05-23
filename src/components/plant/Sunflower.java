package components.plant;

import java.util.ArrayList;
import components.character.GameCharacter;
import components.character.Zombie;
import components.other.Bullet;
import components.other.Sun;
import implement.Interactable;
import implement.Producable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Sunflower extends GameCharacter implements Interactable, Producable {
	protected double time_count = 0;

	public Sunflower(int init_x, int init_y) {
		super("sunflowersprite.png", init_x, init_y, 75, 75, 100, 0);

		this.currentHP = maxHP;
		this.columns = 8;
		this.count = 8;
		this.offsetX = 0;
		this.offsetY = 0;
		this.height = 75;
		this.width = 75;
		this.diffX = -10;
		this.diffY = 12;

		Rectangle hitBox = new Rectangle(40, 100);
		setBox(hitBox);

		createAnimation();
	}

	@Override
	public ArrayList<Sun> produce() {
		ArrayList<Sun> sunArrayList = new ArrayList<Sun>();

		for (int i = 0; i < 1; i++) {
			Sun sun = new Sun();
			sun.toImageView();
			ImageView image = sun.getImageView();
			image.setLayoutX(this.getX() - 50 + 100 * i);
			image.setLayoutY(this.getY());
			sunArrayList.add(sun);
		}
		return sunArrayList;
	}

	@Override
	public void interact(GameCharacter gameCharacter) {
		if (gameCharacter instanceof Zombie && checkCollision(gameCharacter)) {
			gameCharacter.doEatPlant();
			((Zombie) gameCharacter).isEat = true;
			if (currentHP > 0) {
				this.setCurrentHP(currentHP - gameCharacter.getAttackPoint());
			}
		}
	}

	@Override
	public void interact(Bullet bullet) {

	}

}
