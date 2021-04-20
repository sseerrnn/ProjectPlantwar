package logic;

import java.util.ArrayList;

import gui.PlantButton;

public class LevelController {
	private ArrayList<PlantButton> plantButtonList;

	public LevelController() {
		// TODO Auto-generated constructor stub
		plantButtonList = new ArrayList<PlantButton>();
		setUpLevel1Button();
	}

	public void setUpLevel1Button() {
		plantButtonList.add(new PlantButton("PeaShooter"));
		plantButtonList.add(new PlantButton("Sunflower"));
		plantButtonList.add(new PlantButton("PotatoBomb"));
		plantButtonList.add(new PlantButton("Wallnut"));
		plantButtonList.add(new PlantButton("PeaShooter"));
	}

	public void setUpLevel2Button() {
		plantButtonList.add(new PlantButton("PeaShooter"));
		plantButtonList.add(new PlantButton("PeaShooter"));
		plantButtonList.add(new PlantButton("PeaShooter"));

	}

	public ArrayList<PlantButton> getPlantButtonList() {
		return plantButtonList;
	}

	public void setPlantButtonList(ArrayList<PlantButton> plantButtonList) {
		this.plantButtonList = plantButtonList;
	}
}
