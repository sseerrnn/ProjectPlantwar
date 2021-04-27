package logic;

import java.util.ArrayList;

import components.character.Plant;
import exception.ChooseCharacterFailException;
import exception.PlantNotEnoughFailException;
import gui.GameButton;
import gui.PlantButton;

public class GameController {
	private ArrayList<PlantButton> selectedPlantButtons;
	private PlantButton selectedPlantButton;// for choose plant in choose menu
	private int spaceIndex;

	private Plant selectedPlant;// for chooseplant in game
	private int energy;
	private boolean isGameStart;

	public GameController() {
		// TODO Auto-generated constructor stub
		isGameStart = false;

		setUpArrayLv1();
		energy=5000;
		
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
		if(energy>=selectedPlant.getPrice()) {
			energy-=selectedPlant.getPrice();
			
		}
	}

}
