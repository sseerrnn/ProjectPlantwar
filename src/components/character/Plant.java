package components.character;

import components.plant.CabbagePult;
import components.plant.CornPult;
import components.plant.DoublePeaShooter;
import components.plant.PeaShooter;
import components.plant.SnowPea;
import components.plant.Sunflower;
import components.plant.TwinSunflower;
import components.plant.Wallnut;

public class Plant {
	private String plantName;
	private String url;
	private int price;
	private GameCharacter gameChar;
	private int initX;
	private int initY;

	public Plant(String plantName) {
		switch (plantName) {
		case "CabbagePult":
			url = "cabbagepultbutton1.png";
			price = 100;

			break;
		case "CornPult":
			url = "cornpultbutton1.png";
			price = 100;
			break;
		case "DoublePeaShooter":
			url = "doublepeashooterbutton1.png";
			price = 200;
			break;
		case "Tallnut":
			url = "tallnutbutton1.png";
			price = 150;
			break;
		case "PeaShooter":
			url = "peashooterbutton1.png";
			price = 100;

			break;
		case "PotatoBomb":
			url = "potatobombbutton1.png";
			price = 25;
			break;
		case "SnowPea":
			url = "snowpeabutton1.png";
			price = 150;
			break;
		case "Sunflower":
			url = "sunflowerbutton1.png";
			price = 50;
			break;
		case "TwinSunflower":
			url = "twinsunflowerbutton1.png";
			price = 125;
			break;
		case "Wallnut":
			url = "wallnutbutton1.png";
			price = 50;

			break;

		default:
			url = "plantbutton.png";
			price = 0;
			plantName = "";
		}
		this.plantName = plantName;
	}

	public void setUp() {
		switch (plantName) {
		case "CabbagePult":
			gameChar = new CabbagePult(initX, initY);

			break;
		case "CornPult":
			gameChar = new CornPult(initX, initY);

			break;
		case "DoublePeaShooter":
			gameChar = new DoublePeaShooter(initX, initY);
			break;
		case "Tallnut":

			break;
		case "PeaShooter":
			gameChar = new PeaShooter(initX, initY);
			break;
		case "PotatoBomb":
			break;
		case "SnowPea":
			gameChar = new SnowPea(initX, initY);
			break;
		case "Sunflower":
			gameChar = new Sunflower(initX, initY);

			break;
		case "TwinSunflower":
			gameChar = new TwinSunflower(initX, initY);
			break;
		case "Wallnut":
			gameChar = new Wallnut(initX, initY);

			break;

		}
	}

	public GameCharacter getGameChar() {
		return gameChar;
	}

	public int getInitX() {
		return initX;
	}

	public void setInitX(int initX) {
		this.initX = initX;
	}

	public int getInitY() {
		return initY;
	}

	public void setInitY(int initY) {
		this.initY = initY;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPriceText() {
		if (price > 0) {
			return "\nPrice: " + price;
		}
		return "";
	}

}
