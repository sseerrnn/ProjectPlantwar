package components.character;

import components.Entity;

public class GameCharacter extends Entity {
	protected int maxHP;
	protected int currentHP;
	protected int attackPoint;

	public GameCharacter(String img_path, int init_x, int init_y, int width, int height, int currentHP,
			int attackPoint) {
		super(init_x, init_y, width, height);
		this.currentHP = currentHP;
		this.maxHP = currentHP;
		this.attackPoint = attackPoint;

	}

}
