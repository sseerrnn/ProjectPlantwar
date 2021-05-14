package logic;

import java.util.ArrayList;

import components.character.Plant;
import components.other.Sun;
import exception.ChooseCharacterFailException;
import exception.PlantNotEnoughFailException;
import gui.GameButton;
import gui.PlantButton;
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

	public GameController() {
		// TODO Auto-generated constructor stub
		isGameStart = false;
		setUpArrayLv3();
		energy = 5000;
		currentTime = 0;
		lastTimeTriggered = -1;
		isGameEnd=false;
		sunCount=0;
		canCreateSun=false;

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
						
					
						canCreateSun=false;

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

}
