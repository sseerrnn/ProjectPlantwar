package components.character;

import gui.FieldCell;
import gui.SpriteAnimation;
import components.Entity;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class GameCharacter extends Entity {
	protected int maxHP;
	protected int currentHP;
	protected int attackPoint;

	protected int count;
	protected int columns;
	protected int offsetX;
	protected int offsetY;
	protected int width;
	protected int height;

	protected int diffX;
	protected int diffY;

	protected FieldCell fieldCell;
	public int getDiffX() {
		return diffX;
	}

	public int getDiffY() {
		return diffY;
	}

	public GameCharacter(String img_path, int init_x, int init_y, int width, int height, int currentHP,
			int attackPoint) {
		super(init_x, init_y, width, height);
		this.currentHP = currentHP;
		this.maxHP = currentHP;
		this.attackPoint = attackPoint;
		this.img_path = img_path;

	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getAttackPoint() {
		return attackPoint;
	}

	public void setAttackPoint(int attackPoint) {
		this.attackPoint = attackPoint;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getOffsetX() {
		return offsetX;
	}

	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	public int getOffsetY() {
		return offsetY;
	}

	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setDiffX(int diffX) {
		this.diffX = diffX;
	}

	public void setDiffY(int diffY) {
		this.diffY = diffY;
	}

	public boolean checkCollision(GameCharacter gameCharacter) {
//		System.out.println(this.getBox().getBoundsInLocal());
//		System.out.println(gameCharacter.getBox().getBoundsInParent());
		return this.getBox().getBoundsInParent().intersects(gameCharacter.getBox().getBoundsInParent());
	}

	public void createAnimation() {
		imageView = new ImageView(img_path);
		imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
		animation = new SpriteAnimation(imageView, Duration.millis(1000), count, columns, offsetX, offsetY, width,
				height);
		animation.setCycleCount(Animation.INDEFINITE);
		imageView.setLayoutX(init_x);
		imageView.setLayoutY(init_y);
		animation.play();
	}

	public void doEatPlant() {
		if (this.getCurrentHP() < 30) {

		} else {

			imageView.setViewport(new Rectangle2D(offsetX, offsetY + 130, width, height));
			animation = new SpriteAnimation(imageView, Duration.millis(1000), count, columns, offsetX, offsetY + 130,
					width, height);
			animation.setCycleCount(Animation.INDEFINITE);
			imageView.setLayoutX(getX());
			imageView.setLayoutY(getY());
			animation.play();

		}
	}

	public void resetAnimation() {
		imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
		animation = new SpriteAnimation(imageView, Duration.millis(1000), count, columns, offsetX, offsetY, width,
				height);
		animation.setCycleCount(Animation.INDEFINITE);
		imageView.setLayoutX(getX());
		imageView.setLayoutY(getY());
		animation.play();
	}

	public FieldCell getFieldCell() {
		return fieldCell;
	}

	public void setFieldCell(FieldCell fieldCell) {
		this.fieldCell = fieldCell;
	}

}