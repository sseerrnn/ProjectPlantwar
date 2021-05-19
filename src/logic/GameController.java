package logic;

import java.util.ArrayList;
import java.util.Random;

import components.character.GameCharacter;
import components.character.Plant;
import components.character.Zombie;
import components.other.Bullet;
import components.other.Sun;
import components.plant.PeaShooter;
import components.zombie.BucketheadZombie;
import components.zombie.ConeheadZombie;
import components.zombie.RegularZombie;
import exception.ChooseCharacterFailException;
import exception.PlantNotEnoughFailException;
import gui.GameButton;
import gui.PlantButton;
import implement.Interactable;
import implement.Shootable;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import scene.SceneController;

public class GameController {
	private ArrayList<PlantButton> selectedPlantButtons;
	private PlantButton selectedPlantButton;// for choose plant in choose menu
	private int spaceIndex;

	private Plant selectedPlant;// for chooseplant in game
	private int energy;
	private int sunCount;
	private boolean canCreateSun;

	private boolean isGameStart;
	private boolean isGameEnd;

	private int currentTime;
	private AnimationTimer animationTimer;
	private long lastTimeTriggered;

	private ArrayList<Zombie> zombieInGame;
	private ArrayList<GameCharacter> inGameCharacter;
	private ArrayList<GameCharacter> plantInGame;
	private ArrayList<Bullet> bullets;
	private ArrayList<Zombie> zombies;

	public GameController() {
		// TODO Auto-generated constructor stub
		isGameStart = false;
		setUpArrayLv3();
		energy = 5000;
		currentTime = 0;
		lastTimeTriggered = -1;
		isGameEnd = false;
		sunCount = 0;
		canCreateSun = false;
		zombieInGame = new ArrayList<Zombie>();
		inGameCharacter = new ArrayList<GameCharacter>();
		plantInGame = new ArrayList<GameCharacter>();
		bullets = new ArrayList<Bullet>();
		zombies = new ArrayList<Zombie>(5);
	}

	public int getSunCount() {
		return sunCount;
	}

	public void setSunCount(int sunCount) {
		this.sunCount = sunCount;
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public boolean isGameEnd() {
		return isGameEnd;
	}

	public void setGameEnd(boolean isGameEnd) {
		this.isGameEnd = isGameEnd;
	}

	public void Startgame() {
		isGameStart = true;
		timecount();

	}

	public void timecount() {
		this.animationTimer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub

				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);

				if (now - lastTimeTriggered >= 1000000000) {
					currentTime++;

					lastTimeTriggered = now;
					System.out.println(currentTime);

//						canCreateSun=true;
					SceneController.getInstance().toFallSun();
//					generateRegularZombie(1200, 470);
//					generateConeheadZombie(1200, 370);
//					generateBucketheadZombie(1200, 270);
//					generateRegularZombie(1200, 170);
//					generateBucketheadZombie(1200, 70);
					generateZombieLv1();
					for (Zombie zombie : zombieInGame) {
						zombie.walkLeft();
					}
					System.out.println("Zombie : " + zombieInGame.size());
					canCreateSun = false;
					checkCollision();
					checkDie();
					shootBullet();
					addEnergy();

				}
			}
		};
		this.animationTimer.start();
	}

	public boolean isCanCreateSun() {
		return canCreateSun;
	}

	public ArrayList<PlantButton> getSelectedPlantButtons() {
		return selectedPlantButtons;
	}

	public void setSelectedPlantButtons(ArrayList<PlantButton> selectedPlantButtons) {
		this.selectedPlantButtons = selectedPlantButtons;
	}

	public PlantButton getSelectedPlantButton() {
		return selectedPlantButton;
	}

	public void setSelectedPlantButton(PlantButton selectedPlantButton) {
		this.selectedPlantButton = selectedPlantButton;
	}

	public void checkSpaceInselectedPlantButtons() throws ChooseCharacterFailException {
		int count = 0;
		for (PlantButton button : selectedPlantButtons) {
			if (button.getPlant().getPlantName().isEmpty()) {
				break;
			}
			count += 1;

		}
		this.spaceIndex = count;
		if (spaceIndex == selectedPlantButtons.size()) {
			throw new ChooseCharacterFailException(
					"Cannot choose more than " + selectedPlantButtons.size() + " plants.");
		}
	}

	public int getSpaceIndex() {
		return spaceIndex;
	}

	public void setSpaceIndex(int spaceIndex) {
		this.spaceIndex = spaceIndex;
	}

	public void setUpArrayLv1() {
		selectedPlantButtons = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			selectedPlantButtons.add(new PlantButton(""));
		}
	}

	public void setUpArrayLv2() {
		selectedPlantButtons = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			selectedPlantButtons.add(new PlantButton(""));
		}
	}

	public void setUpArrayLv3() {
		selectedPlantButtons = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			selectedPlantButtons.add(new PlantButton(""));
		}
	}

	public boolean isGameStart() {
		return isGameStart;
	}

	public void setGameStart(boolean isGameStart) {
		this.isGameStart = isGameStart;
	}

	public void checkPlantEnough() throws PlantNotEnoughFailException {
		int count = 0;
		for (PlantButton button : selectedPlantButtons) {
			if (button.getPlant().getPlantName().isEmpty()) {
				break;
			}
			count += 1;
		}
		this.spaceIndex = count;
		if (spaceIndex != selectedPlantButtons.size()) {
			throw new PlantNotEnoughFailException("Plant not enough.");
		}
	}

	public Plant getSelectedPlant() {
		return selectedPlant;
	}

	public void setSelectedPlant(Plant selectedPlant) {
		this.selectedPlant = selectedPlant;
	}

	public void reduceEneryToBuyPlant() {
		if (energy >= selectedPlant.getPrice()) {
			energy -= selectedPlant.getPrice();
		}
	}

	public void increaseEnegy() {
		energy += 50;
	}

	public void generateRegularZombie(int initx, int inity, int timeSpawn, int row) {
		if (zombieInGame.size() < 20 && currentTime % timeSpawn == 0) {
			RegularZombie zombie = new RegularZombie(initx, inity);
			zombie.setY(zombie.getY() + zombie.getDiffY());
			zombie.getImageView().setLayoutY(zombie.getY());
			zombieInGame.add(zombie);
			inGameCharacter.add(zombie);
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getBox());
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getImageView());

		}

	}

	public void generateConeheadZombie(int initx, int inity, int timeSpawn, int row) {
		if (zombieInGame.size() < 5 && currentTime % 7 == 0) {
			ConeheadZombie zombie = new ConeheadZombie(initx, inity);
			zombie.setY(zombie.getY() + zombie.getDiffY());
			zombie.getImageView().setLayoutY(zombie.getY());
			zombieInGame.add(zombie);
			inGameCharacter.add(zombie);
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getBox());
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getImageView());
		}
	}

	public void generateBucketheadZombie(int initx, int inity, int timeSpawn, int row) {
		if (zombieInGame.size() < 5 && currentTime % 9 == 0) {
			BucketheadZombie zombie = new BucketheadZombie(initx, inity);
			zombie.setY(zombie.getY() + zombie.getDiffY());
			zombie.getImageView().setLayoutY(zombie.getY());
			zombieInGame.add(zombie);
			inGameCharacter.add(zombie);
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getBox());
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getImageView());
		}
	}

	public ArrayList<Zombie> getZombieInGame() {
		return zombieInGame;
	}

	public void setZombieInGame(ArrayList<Zombie> zombieInGame) {
		this.zombieInGame = zombieInGame;
	}

	public ArrayList<GameCharacter> getInGameCharacter() {
		return inGameCharacter;
	}

	public void setInGameCharacter(ArrayList<GameCharacter> inGameCharacter) {
		this.inGameCharacter = inGameCharacter;
	}

	public ArrayList<GameCharacter> getPlantInGame() {
		return plantInGame;
	}

	public void setPlantInGame(ArrayList<GameCharacter> plantInGame) {
		this.plantInGame = plantInGame;
	}

	public void checkDie() {
		ArrayList<GameCharacter> deadPlants = new ArrayList<GameCharacter>();
		for (GameCharacter plant : plantInGame) {
			if (plant.getCurrentHP() < 0) {
				System.out.println("plantdie : " + plant);
				for (Zombie zombie : zombieInGame) {
					if (plant.getBox().getBoundsInParent().intersects(zombie.getBox().getBoundsInParent())) {
						zombie.setEat(false);
//						System.out.println(zombie.isEat());
						zombie.resetAnimation();
					}
				}
				SceneController.getInstance().getMainPane().getChildren().remove(plant.getImageView());
				SceneController.getInstance().getMainPane().getChildren().remove(plant.getBox());
				deadPlants.add(plant);
			}

		}
		for (GameCharacter plant : deadPlants) {
			plantInGame.remove(plant);
			plant.getFieldCell().setPlant(null);
		}

	}

	public void checkCollision() {
		for (GameCharacter plant : plantInGame) {
			for (Zombie zombie : zombieInGame) {
				if (plant instanceof Interactable) {
					((Interactable) plant).interact(zombie);

					System.out.println("plant hp: " + plant.getCurrentHP());

				}
			}
		}
	}

	public void shootBullet() {
		for (GameCharacter plant : plantInGame) {
			if (plant instanceof Shootable) {
				bullets.add(((Shootable) plant).shoot());

			}
		}

		for (Bullet bullet : bullets) {
			bullet.shootRight();
		}

	}

	public void checkBulletCollision() {
		for (Zombie zombie : zombieInGame) {
			for (Bullet bullet : bullets) {
				if (zombie instanceof Interactable) {
					((Interactable) zombie).interact(bullet);

					System.out.println("zombie hp: " + zombie.getCurrentHP());
				}
			}
		}
	}

	public void generateZombieLv1() {
		Random random = new Random();
		int row = random.nextInt(5);
		int timeSpawn = 4 + random.nextInt(4);
		generateRegularZombie(1200, 70 + 100 * row, timeSpawn, row);
	}

	public void generateZombieLv2() {
		Random random = new Random();
		int row = random.nextInt(5);
		int timeSpawn = 5 + random.nextInt(4);
		generateConeheadZombie(1200, 70 + 100 * row, timeSpawn, row);

	}

	public void generateZombieLv3() {

		Random random = new Random();
		int row = random.nextInt(5);
		int timeSpawn = 6 + random.nextInt(4);
		generateConeheadZombie(1200, 70 + 100 * row, timeSpawn, row);

	}

	public void addEnergy() {
		Canvas canvas = SceneController.getInstance().getCanvas();
		GraphicsContext gc = SceneController.getInstance().getGc();
		gc.setFill(Color.BLACK);
		gc.setFont(new Font(40));
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.fillText(energy + "", canvas.getWidth() / 2, canvas.getHeight() / 2);
	}

	public int checkPlantRow(GameCharacter plant) {
		int y = (int) plant.getBox().getLayoutY();
		int row = 0;
		switch (y) {
		case 100: {

			row = 1;
			break;
		}
		case 200:
			row = 2;
			break;
		case 300:
			row = 3;
			break;
		case 400:
			row = 4;
			break;
		case 500:
			row = 5;
			break;

		}
		System.out.println("row : "+row);
		return row;
	}
}
