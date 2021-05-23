package gui;

import components.character.Plant;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class FieldCell extends Pane {

	private Plant plant;

	public FieldCell() {
		this.setPrefWidth(95);
		this.setPrefHeight(100);
		this.setMinWidth(95);
		this.setMinHeight(100);
		this.getChildren().add(new ImageView("yardscale1.png"));
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

}
