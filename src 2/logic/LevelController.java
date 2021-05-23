package logic;

import java.util.ArrayList;
import gui.PlantButton;

public class LevelController {

	private ArrayList<PlantButton> plantButtonList;
	private boolean level1;
	private boolean level2;
	private boolean level3;

	public LevelController() {
		plantButtonList = new ArrayList<PlantButton>();
		level1 = true;
		level2 = false;
		level3 = false;
		setUpLevel1Button();
//		setUpLevel2Button();
//		setUpLevel3Button();
	}

	public void resetGame() {
		plantButtonList = new ArrayList<PlantButton>();
		setUpLevel1Button();
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

	public boolean isLevel1() {
		return level1;
	}

	public void setLevel1(boolean level1) {
		this.level1 = level1;
	}

	public boolean isLevel2() {
		return level2;
	}

	public void setLevel2(boolean level2) {
		this.level2 = level2;
	}

	public boolean isLevel3() {
		return level3;
	}

	public void setLevel3(boolean level3) {
		this.level3 = level3;
	}

}
