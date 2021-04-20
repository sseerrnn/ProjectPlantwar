package logic;

import java.util.ArrayList;

import gui.GameButton;
import gui.PlantButton;

public class GameController {
private ArrayList<PlantButton> selectedPlantButtons= new ArrayList<>();
private PlantButton selectedPlantButton;
private boolean isGameStart;
public GameController() {
	// TODO Auto-generated constructor stub
isGameStart=false;
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

}
