package logic;

import java.util.ArrayList;

import components.character.GameCharacter;
import components.character.Plant;
import components.character.Zombie;
import components.other.Sun;
import components.zombie.BucketheadZombie;
import components.zombie.ConeheadZombie;
import components.zombie.RegularZombie;
import exception.ChooseCharacterFailException;
import exception.PlantNotEnoughFailException;
import gui.GameButton;
import gui.PlantButton;
import implement.Interactable;
import javafx.animation.AnimationTimer;
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
					generateRegularZombie(1200, 470);
					generateConeheadZombie(1200, 370);
					generateBucketheadZombie(1200, 270);
					generateRegularZombie(1200, 170);
					generateBucketheadZombie(1200, 70);
					for (Zombie zombie : zombieInGame) {
						zombie.walkLeft();
					}
					System.out.println("Zombie : " + zombieInGame.size());
					canCreateSun = false;
					checkCollision();

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

	public void generateRegularZombie(int initx, int inity) {
		if (zombieInGame.size() < 5 && currentTime % 4 == 0) {
			RegularZombie zombie = new RegularZombie(initx, inity);
			zombie.setY(zombie.getY() + zombie.getDiffY());
			zombie.getImageView().setLayoutY(zombie.getY());
			zombieInGame.add(zombie);
			inGameCharacter.add(zombie);
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getBox());
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getImageView());

		}
	}

	public void generateConeheadZombie(int initx, int inity) {
		if (zombieInGame.size() < 5 && currentTime % 4 == 0) {
			ConeheadZombie zombie = new ConeheadZombie(initx, inity);
			zombie.setY(zombie.getY() + zombie.getDiffY());
			zombie.getImageView().setLayoutY(zombie.getY());
			zombieInGame.add(zombie);
			inGameCharacter.add(zombie);
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getBox());
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getImageView());

		}
	}

	public void generateBucketheadZombie(int initx, int inity) {
		if (zombieInGame.size() < 5 && currentTime % 4 == 0) {
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
			}
		}

	}

	public void checkCollision() {
		for (GameCharacter plant : plantInGame) {
			for (Zombie zombie : zombieInGame) {
				if (plant instanceof Interactable) {
					((Interactable) plant).interact(zombie);

					System.out.println("plant hp: " + plant.getCurrentHP());
					checkDie();

				}
			}
		}
	}
}
