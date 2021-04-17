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
	private Plant plant;

	public PlantButton(String plantName) {
		// TODO Auto-generated constructor stub
		this.plant = new Plant(plantName);
		this.setPrefHeight(107);
		this.setPrefWidth(165);
		ImageView image = new ImageView(plant.getUrl());
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setGraphic(image);
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
