package components.character;

public class Plant {
private String plantName;
private String url;
private int price;
public Plant(String plantName) {
	switch(plantName) {
	case "CabbagePult" :		url = "black.jpg"; 		price = 100;	break;
	case "CornPult" : 	url = "black.jpg"; 	price = 100;	break;
	case "DoublePeaShooter" : 	url = "black.jpg"; 	price = 200;	break;
	case "FireDragon" : url = "black.jpg"; price = 150;	break;
	case "PeaShooter" : 	url = "black.jpg"; 	price = 100;	break;
	case "PotatoBomb" : 	url = "black.jpg"; 	price = 25;	break;
	case "SnowPea" : 	url = "black.jpg"; 	price = 150;	break;
	case "Sunflower" : 	url = "black.jpg"; 	price = 50;	break;
	case "TwinSunflower" : 	url = "black.jpg"; 	price = 125;	break;
	case "Wallnut" : 	url = "black.jpg"; 	price = 50;	break;
	
	default : 			url = "black.jpg"; 	price = 0; plantName = "";
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

