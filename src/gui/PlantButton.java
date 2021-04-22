package gui;

import components.character.Plant;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class PlantButton extends Button {
	private String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('WoodButton.png');";
	private Plant plant;

	public PlantButton(String plantName) {
		// TODO Auto-generated constructor stub
		this.plant = new Plant(plantName);
		ImageView image = new ImageView(plant.getUrl());
		this.setPrefHeight(107);
		this.setPrefWidth(165);
		BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('" + plant.getUrl() + "');";
		this.setStyle(BUTTON_STYLE);
		initializeButtonListeners();

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

	public Plant getPlant() {
		return plant;
	}
	public void initializeButtonListeners() {
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				DropShadow drop = new DropShadow();
				drop.setColor(Color.WHITE);
				setEffect(drop);
			}

		});
		setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				setEffect(null);

			}
		});
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				DropShadow drop = new DropShadow();
				drop.setColor(Color.WHITE);
				setEffect(drop);
			}
		});
	}

}
