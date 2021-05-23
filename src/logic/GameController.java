package logic;

import java.util.ArrayList;
import java.util.Random;
import components.bullet.CabbageBullet;
import components.bullet.CornBullet;
import components.bullet.SnowBullet;
import components.character.GameCharacter;
import components.character.Plant;
import components.character.Zombie;
import components.other.Bullet;
import components.other.LawnMower;
import components.other.Sun;
import components.plant.PotatoBomb;
import components.zombie.BucketheadZombie;
import components.zombie.ConeheadZombie;
import components.zombie.RegularZombie;
import element.Audio;
import exception.ChooseCharacterFailedException;
import exception.PlantNotEnoughFailedException;
import gui.PlantButton;
import implement.Explodable;
import implement.Interactable;
import implement.Producable;
import implement.Shootable;
import implement.Throwable;
import javafx.animation.AnimationTimer;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import scene.SceneController;

public class GameController {

	private LevelController levelController;

	private ArrayList<PlantButton> selectedPlantButtons;
	private PlantButton selectedPlantButton;// for choose plant in choose menu
	private int spaceIndex;

	private Plant selectedPlant;// for chooseplant in game
	private int energy;
	private int sunCount;
	private boolean canCreateSun;

	private boolean isGameStart;
	private boolean isGameEnd;
	private boolean isWin;

	private int currentTime;
	private AnimationTimer animationTimer;
	private long lastTimeTriggered;
	private ImageView goal;
	private int level;
	private int countZombieDie;

	private ArrayList<Zombie> zombieInGame;
	private ArrayList<GameCharacter> inGameCharacter;
	private ArrayList<GameCharacter> plantInGame;
	private ArrayList<Bullet> bullets;
	private ArrayList<ArrayList<Zombie>> zombies;
	private ArrayList<Sun> producedSun;
	private ArrayList<LawnMower> lawnMowerInGame;
	private ArrayList<Zombie> countZombie;

	public GameController() {
		isGameStart = false;
		setUpArrayLv1();
		countZombieDie = 0;
		energy = 500;
		currentTime = 0;
		lastTimeTriggered = -1;
		isGameEnd = false;
		sunCount = 0;
		canCreateSun = false;
		zombieInGame = new ArrayList<Zombie>();
		countZombie = new ArrayList<Zombie>();
		inGameCharacter = new ArrayList<GameCharacter>();
		plantInGame = new ArrayList<GameCharacter>();
		bullets = new ArrayList<Bullet>();
		zombies = new ArrayList<ArrayList<Zombie>>(5);
		producedSun = new ArrayList<Sun>();

		for (int i = 0; i < 5; i++) {
			zombies.add(new ArrayList<Zombie>());
		}
		lawnMowerInGame = new ArrayList<LawnMower>();
		createLawnmower();
		createGoalZombie();
		levelController = new LevelController();
	}

	public void createLawnmower() {
		for (int i = 0; i < 5; i++) {
			LawnMower mower = new LawnMower(216, 95 + 100 * i, 94, 80);
			lawnMowerInGame.add(mower);
		}
	}

	public void Startgame() {
		isGameStart = true;
		timecount();
	}

	public void timecount() {
		this.animationTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				lastTimeTriggered = (lastTimeTriggered < 0 ? now : lastTimeTriggered);

				if (now - lastTimeTriggered >= 1000000000) {
					currentTime++;

					lastTimeTriggered = now;
					System.out.println(currentTime);

					update();
				}
			}
		};
		if (isGameStart == true) {
			this.animationTimer.start();
		}
		if (isGameStart == false) {
			this.animationTimer.stop();
		}
	}

	public void selectLevel(int level) {
		setLevel(level);

		switch (level) {
		case 1:
			setUpArrayLv1();
			generateZombieLv1();
			break;
		case 2:
			levelController.setUpLevel2Button();
			setUpArrayLv2();
			generateZombieLv1();
			generateZombieLv2();
			break;
		case 3:
			levelController.setUpLevel2Button();
			levelController.setUpLevel3Button();
			setUpArrayLv3();
			generateZombieLv1();
			generateZombieLv2();
			generateZombieLv3();
			break;
		}
	}

	public void update() {
		checkIsGoal();
		checkWin();
		SceneController.getInstance().toFallSun();
		selectLevel(level);

		for (Zombie zombie : zombieInGame) {
			zombie.walkLeft();
		}

		System.out.println("Zombie : " + zombieInGame.size());
		canCreateSun = false;
		checkMowerCollision();
		checkDie();
		checkBulletCollision();
		checkCollision();
		checkPlantShoot();
		addEnergy();
		checkZombieDie();
		produceSun();
		shootBullet();
	}

	public void resetGameStatus() {
		isGameStart = false;
		setUpArrayLv1();
		countZombieDie = 0;
		energy = 500;
		currentTime = 0;
		lastTimeTriggered = -1;

		isGameEnd = false;
		sunCount = 0;
		canCreateSun = false;
		zombieInGame = new ArrayList<Zombie>();
		countZombie = new ArrayList<Zombie>();
		inGameCharacter = new ArrayList<GameCharacter>();
		plantInGame = new ArrayList<GameCharacter>();
		bullets = new ArrayList<Bullet>();
		zombies = new ArrayList<ArrayList<Zombie>>(5);
		producedSun = new ArrayList<Sun>();
		for (int i = 0; i < 5; i++) {
			zombies.add(new ArrayList<Zombie>());
		}
		lawnMowerInGame = new ArrayList<LawnMower>();
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public void resetGame() {
		isGameStart = false;
		setUpArrayLv1();
		countZombieDie = 0;
		energy = 500;
		currentTime = 0;
		lastTimeTriggered = -1;

		isGameEnd = false;
		sunCount = 0;
		canCreateSun = false;
		zombieInGame = new ArrayList<Zombie>();
		countZombie = new ArrayList<Zombie>();
		inGameCharacter = new ArrayList<GameCharacter>();
		plantInGame = new ArrayList<GameCharacter>();
		bullets = new ArrayList<Bullet>();
		zombies = new ArrayList<ArrayList<Zombie>>(5);
		producedSun = new ArrayList<Sun>();
		for (int i = 0; i < 5; i++) {
			zombies.add(new ArrayList<Zombie>());
		}
		lawnMowerInGame = new ArrayList<LawnMower>();
		createLawnmower();
		createGoalZombie();
	}

	public void checkWin() {
		switch (getLevel()) {
		case 1:
			if (countZombieDie == 20) {
				setGameStart(false);
				setGameEnd(true);
				setWin(true);
				levelController.setLevel2(true);
				animationTimer.stop();
				SceneController.getInstance().setUpGameEnding(isWin());
				SceneController.getInstance().getMainstage().setScene(SceneController.getInstance().getMainScene());
				break;
			}
		case 2:
			if (countZombieDie == 30) {
				setGameStart(false);
				setGameEnd(true);
				setWin(true);
				levelController.setLevel3(true);
				animationTimer.stop();
				SceneController.getInstance().setUpGameEnding(isWin());

				SceneController.getInstance().getMainstage().setScene(SceneController.getInstance().getMainScene());

				break;
			}
		case 3:
			if (countZombieDie == 40) {
				setGameStart(false);
				setGameEnd(true);
				setWin(true);
				animationTimer.stop();
				SceneController.getInstance().setUpGameEnding(isWin());
				SceneController.getInstance().getMainstage().setScene(SceneController.getInstance().getMainScene());
				break;
			}
		}
	}

	public void checkMowerCollision() {
		ArrayList<LawnMower> removedMower = new ArrayList<LawnMower>();
		ArrayList<ArrayList<Zombie>> deadZombie = new ArrayList<ArrayList<Zombie>>();
		for (ArrayList<Zombie> zombieList : zombies) {
			for (Zombie zombie : zombieList) {
				for (LawnMower mower : lawnMowerInGame) {
					if (mower.getBox().getBoundsInParent().intersects(zombie.getBox().getBoundsInParent())
							&& mower.isActive()) {
						mower.interact(zombie);
						Audio.createMowerSound();
						System.out.println();
						mower.setActive(false);

						if (!deadZombie.contains(zombieList)) {
							deadZombie.add(zombieList);
						}
					}
				}
			}
		}
		for (LawnMower mower : removedMower) {
			lawnMowerInGame.remove(mower);
		}
		for (ArrayList<Zombie> deadZombieList : deadZombie) {
			for (Zombie zombie : deadZombieList) {
				zombie.setCurrentHP(0);
			}
		}
	}

	public void dropSun() {
		for (Sun sun : producedSun) {
			if (-sun.getInit_y() + sun.getY() < 20)
				sun.getImageView().setTranslateY(sun.getY() + 10);
			sun.setY(sun.getY() + 10);
		}
	}

	public void checkSpaceInselectedPlantButtons() throws ChooseCharacterFailedException {
		int count = 0;
		for (PlantButton button : selectedPlantButtons) {
			if (button.getPlant().getPlantName().isEmpty()) {
				break;
			}
			count += 1;
		}
		this.spaceIndex = count;
		if (spaceIndex == selectedPlantButtons.size()) {
			throw new ChooseCharacterFailedException(
					"Cannot choose more than " + selectedPlantButtons.size() + " plants.");
		}
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

	public void checkPlantEnough() throws PlantNotEnoughFailedException {
		int count = 0;

		for (PlantButton button : selectedPlantButtons) {
			if (button.getPlant().getPlantName().isEmpty()) {
				break;
			}
			count += 1;
		}
		this.spaceIndex = count;

		if (spaceIndex != selectedPlantButtons.size()) {
			System.out.println(spaceIndex);
			System.out.println(selectedPlantButtons.size());
			throw new PlantNotEnoughFailedException("Plant not enough.");
		}
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
		if (countZombie.size() < 20 && currentTime % timeSpawn == 0) {
			RegularZombie zombie = new RegularZombie(initx, inity);
			zombie.setY(zombie.getY() + zombie.getDiffY());
			zombie.getImageView().setLayoutY(zombie.getY());
			zombieInGame.add(zombie);
			inGameCharacter.add(zombie);
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getBox());
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getImageView());
			zombies.get(row).add(zombie);
			countZombie.add(zombie);
		}
	}

	public void generateConeheadZombie(int initx, int inity, int timeSpawn, int row) {
		if (countZombie.size() < 30 && currentTime % timeSpawn == 0) {
			ConeheadZombie zombie = new ConeheadZombie(initx, inity);
			zombie.setY(zombie.getY() + zombie.getDiffY());
			zombie.getImageView().setLayoutY(zombie.getY());
			zombieInGame.add(zombie);
			inGameCharacter.add(zombie);
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getBox());
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getImageView());
			zombies.get(row).add(zombie);
			countZombie.add(zombie);
		}
	}

	public void generateBucketheadZombie(int initx, int inity, int timeSpawn, int row) {
		if (countZombie.size() < 40 && currentTime % timeSpawn == 0) {
			BucketheadZombie zombie = new BucketheadZombie(initx, inity);
			zombie.setY(zombie.getY() + zombie.getDiffY());
			zombie.getImageView().setLayoutY(zombie.getY());
			zombieInGame.add(zombie);
			inGameCharacter.add(zombie);
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getBox());
			SceneController.getInstance().getMainPane().getChildren().add(zombie.getImageView());
			zombies.get(row).add(zombie);
			countZombie.add(zombie);
		}
	}

	public void checkDie() {
		ArrayList<GameCharacter> deadPlants = new ArrayList<GameCharacter>();
		for (GameCharacter plant : plantInGame) {
			if (plant.getCurrentHP() <= 0) {
				System.out.println("plantdie : " + plant);
				for (Zombie zombie : zombieInGame) {
					if (plant.getBox().getBoundsInParent().intersects(zombie.getBox().getBoundsInParent())) {
						zombie.setEat(false);
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

	public void checkZombieDie() {
		ArrayList<Zombie> deadZombies = new ArrayList<Zombie>();
		for (Zombie zombie : zombieInGame) {
			if (zombie.getCurrentHP() <= 0) {
				deadZombies.add(zombie);
				countZombieDie += 1;

				TranslateTransition move1 = new TranslateTransition();
				move1.setOnFinished(e -> zombie.killRegularZombie());

				TranslateTransition move2 = new TranslateTransition();
				move2.setOnFinished(e -> {
					SceneController.getInstance().getMainPane().getChildren().remove(zombie.getImageView());
					SceneController.getInstance().getMainPane().getChildren().remove(zombie.getBox());

				});

				SequentialTransition seq = new SequentialTransition();
				seq.getChildren().addAll(move1, move2);
				seq.play();
			}
		}
		for (GameCharacter zombie : deadZombies) {
			zombieInGame.remove(zombie);
			for (ArrayList<Zombie> arr : zombies) {
				arr.remove(zombie);
			}
		}
	}

	public void checkCollision() {
		for (GameCharacter plant : plantInGame) {
			for (Zombie zombie : zombieInGame) {
				if (plant instanceof Explodable) {
					if (plant.getBox().getBoundsInParent().intersects(zombie.getBox().getBoundsInParent())
							&& ((PotatoBomb) plant).getTime() < this.getCurrentTime()) {
						((Explodable) plant).explode(zombie);
					}
				}
				if (plant instanceof Interactable) {
					((Interactable) plant).interact(zombie);
					System.out.println("plant hp: " + plant.getCurrentHP());
				}
			}
		}
	}

	public void checkBulletCollision() {
		ArrayList<Bullet> removedBullet = new ArrayList<Bullet>();
		for (Zombie zombie : zombieInGame) {
			for (Bullet bullet : bullets) {
				if (zombie instanceof Interactable
						&& zombie.getBox().getBoundsInParent().intersects(bullet.getBox().getBoundsInParent())) {
					((Interactable) zombie).interact(bullet);
					removedBullet.add(bullet);
					System.out.println("zombie hp: " + zombie.getCurrentHP());

					Audio.createCrashSound();
				}
				if (((zombie instanceof BucketheadZombie) || (zombie instanceof ConeheadZombie))
						&& zombie.getCurrentHP() < 100 && zombie.getCurrentHP() > 30 && zombie.isHaveHat()) {
					TranslateTransition move1 = new TranslateTransition();
					move1.setOnFinished(e -> zombie.destroyZombieHat());

					TranslateTransition move2 = new TranslateTransition();
					move2.setOnFinished(e -> zombie.backToRegularZombie());

					SequentialTransition seq = new SequentialTransition();
					seq.getChildren().addAll(move1, move2);
					seq.play();
					zombie.setHaveHat(false);

					Audio.createCrashSound();
				}
				if (zombie.getCurrentHP() < 30 && zombie.getCurrentHP() > 0 && zombie.isHaveHead()) {
					TranslateTransition move1 = new TranslateTransition();
					move1.setOnFinished(e -> zombie.destroyRegularZombieBody());

					TranslateTransition move2 = new TranslateTransition();
					move2.setOnFinished(e -> zombie.brokenRegularZombieWalk());

					SequentialTransition seq = new SequentialTransition();
					seq.getChildren().addAll(move1, move2);
					seq.play();
					zombie.setHaveHead(false);

					Audio.createCrashSound();
				}
			}
		}
		for (Bullet bullet : removedBullet) {
			bullets.remove(bullet);
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
		gc.setFill(Color.WHEAT);
		gc.setFont(Font.loadFont(getClass().getClassLoader().getResource("Bangers-Regular.ttf").toExternalForm(), 40));
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.fillText(energy + "", canvas.getWidth() / 2, canvas.getHeight() / 2);
	}

	public int checkPlantRow(GameCharacter plant) {
		int y = (int) plant.getBox().getLayoutY();
		int row = 0;

		switch (y) {
		case 100:
			row = 1;
			break;
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

		System.out.println("row : " + row);
		return row;
	}

	public void checkPlantShoot() {
		for (GameCharacter plant : plantInGame) {
			if (plant instanceof Shootable) {
				if (zombies.get(checkPlantRow(plant) - 1).size() > 0 && currentTime % 5 == 0) {
					Bullet bullet = ((Shootable) plant).shoot();
					bullets.add(bullet);
					plant.setShoot(true);
				}
			}
			if (plant instanceof Throwable) {
				if (zombies.get(checkPlantRow(plant) - 1).size() > 0 && currentTime % 5 == 0) {
					Bullet bullet = ((Throwable) plant).projectile();
					bullet.setRow(checkPlantRow(plant) - 1);
					bullets.add(bullet);
					bullet.setVelocity_y(-10 * bullet.timeCalculate(zombies.get(bullet.getRow()).get(0)));
					plant.setShoot(true);
				}
			}
		}
	}

	public void doSlowZombie(Bullet bullet, Zombie zombie) {
		if (bullet instanceof SnowBullet) {
			zombie.setVelocity_x(20);
			zombie.setSlowUntil(currentTime + 5);
		}
	}

	public void shootBullet() {
		for (Bullet bullet : bullets) {
			if (bullet instanceof CabbageBullet || bullet instanceof CornBullet) {
				bullet.projectileRight();
			} else {
				bullet.shootRight();
			}
		}
	}

	public void setUpGameResult() {
		if (zombieInGame.size() == 0) {
			SceneController.getInstance().setUpGameEnding(true);
		}
//		else if() {
//		SceneController.getInstance().setUpGameEnding(false);
//		}
	}

	public void createGoalZombie() {
		goal = new ImageView("line.png");
		goal.setLayoutX(166);
		goal.setLayoutY(95);
		SceneController.getInstance().getMainPane().getChildren().add(goal);
	}

	public void checkIsGoal() {
		for (Zombie zombie : zombieInGame) {
			if (zombie.getBox().getBoundsInParent().intersects(goal.getBoundsInParent())) {
				setGameEnd(true);
				setGameStart(false);
				setGameEnd(true);
				setWin(false);
				animationTimer.stop();
				
				SceneController.getInstance().setUpGameEnding(isWin());
				SceneController.getInstance().getMainstage().setScene(SceneController.getInstance().getMainScene());
			}
		}
	}

	public void produceSun() {
		for (GameCharacter plant : plantInGame) {
			if (plant instanceof Producable && currentTime % 5 == 0) {
				for (Sun sun : ((Producable) plant).produce()) {
					sun.getImageView().setOnMouseClicked(new EventHandler<Event>() {
						@Override
						public void handle(Event arg0) {
							sun.moveOut(sun.getImageView());
							increaseEnegy();
						}
					});
					producedSun.add(sun);
					SceneController.getInstance().getMainPane().getChildren().add(sun.getImageView());
				}
			}
		}
	}

	public boolean isGameStart() {
		return isGameStart;
	}

	public void setGameStart(boolean isGameStart) {
		this.isGameStart = isGameStart;
	}

	public Plant getSelectedPlant() {
		return selectedPlant;
	}

	public void setSelectedPlant(Plant selectedPlant) {
		this.selectedPlant = selectedPlant;
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

	public int getSunCount() {
		return sunCount;
	}

	public void setSunCount(int sunCount) {
		this.sunCount = sunCount;
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public AnimationTimer getAnimationTimer() {
		return animationTimer;
	}

	public void setAnimationTimer(AnimationTimer animationTimer) {
		this.animationTimer = animationTimer;
	}

	public int getSpaceIndex() {
		return spaceIndex;
	}

	public void setSpaceIndex(int spaceIndex) {
		this.spaceIndex = spaceIndex;
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

	public boolean isGameEnd() {
		return isGameEnd;
	}

	public void setGameEnd(boolean isGameEnd) {
		this.isGameEnd = isGameEnd;
	}

	public LevelController getLevelController() {
		return levelController;
	}

	public void setLevelController(LevelController levelController) {
		this.levelController = levelController;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

}
