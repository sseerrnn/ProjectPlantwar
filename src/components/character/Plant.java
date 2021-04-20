package components.character;

public class Plant {
private String plantName;
private String url;
private int price;
public Plant(String plantName) {
	switch(plantName) {
	case "CabbagePult" :		url = "plantbutton.png"; 		price = 100;	break;
	case "CornPult" : 	url = "plantbutton.png"; 	price = 100;	break;
	case "DoublePeaShooter" : 	url = "plantbutton.png"; 	price = 200;	break;
	case "FireDragon" : url = "plantbutton.png"; price = 150;	break;
	case "PeaShooter" : 	url = "plantbutton.png"; 	price = 100;	break;
	case "PotatoBomb" : 	url = "plantbutton.png"; 	price = 25;	break;
	case "SnowPea" : 	url = "plantbutton.png"; 	price = 150;	break;
	case "Sunflower" : 	url = "plantbutton.png"; 	price = 50;	break;
	case "TwinSunflower" : 	url = "plantbutton.png"; 	price = 125;	break;
	case "Wallnut" : 	url = "plantbutton.png"; 	price = 50;	break;
	
	default : 			url = "plantbutton.png"; 	price = 0; plantName = "";
}
this.plantName=plantName;
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
	if(price > 0 ) {
		return "\nPrice: "+ price;			
	}
	return "";
}



}

