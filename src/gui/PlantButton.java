package gui;

import components.character.Plant;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class PlantButton extends Button {
	private  String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('WoodButton.png');";
	private Plant plant;

	public PlantButton(String plantName) {
		// TODO Auto-generated constructor stub
		this.plant = new Plant(plantName);
		ImageView image = new ImageView(plant.getUrl());
		this.setPrefHeight(107);
		this.setPrefWidth(165);
BUTTON_STYLE="-fx-background-color: transparent; -fx-background-image: url('"+plant.getUrl()+"');";
		this.setStyle(BUTTON_STYLE);
	}





	private void setTooltip() {
		Tooltip tooltip = new Tooltip();
		tooltip.setText(plant.getPlantName() + plant.getPriceText());
		this.setOnMouseMoved((MouseEvent e) -> {
			if (plant != null)
				tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});

	}
}
