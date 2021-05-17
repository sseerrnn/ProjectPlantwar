package logic;

import java.util.ArrayList;

import gui.PlantButton;

public class LevelController {
	private ArrayList<PlantButton> plantButtonList;

	public LevelController() {
		// TODO Auto-generated constructor stub
		plantButtonList = new ArrayList<PlantButton>();
		setUpLevel1Button();
		setUpLevel2Button();
		setUpLevel3Button();
	}

	public void setUpLevel1Button() {
		plantButtonList.add(new PlantButton("PeaShooter"));
		plantButtonList.add(new PlantButton("Sunflower"));
		plantButtonList.add(new PlantButton("Wallnut"));
	}

	public void setUpLevel2Button() {
		plantButtonList.add(new PlantButton("PotatoBomb"));
		plantButtonList.add(new PlantButton("CabbagePult"));
		plantButtonList.add(new PlantButton("SnowPea"));
	

	}
	public void setUpLevel3Button() {
		plantButtonList.add(new PlantButton("TwinSunflower"));
		plantButtonList.add(new PlantButton("CornPult"));
		plantButtonList.add(new PlantButton("DoublePeaShooter"));
		plantButtonList.add(new PlantButton("Tallnut"));


	}

	public ArrayList<PlantButton> getPlantButtonList() {
		return plantButtonList;
	}

	public void setPlantButtonList(ArrayList<PlantButton> plantButtonList) {
		this.plantButtonList = plantButtonList;
	}
	
}
