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
	private boolean isClicked = false;

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

	public Plant getPlant() {
		return plant;
	}

	public void initializeButtonListeners() {
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				highlight();
			}

		});
		setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				
					setEffect(null);
				
			}
		});
		

	}
//	public void initializeButtonListeners2() {
//		setOnMouseEntered(getOnDragDetected());
//	}

	public void highlight() {
		DropShadow drop = new DropShadow();
		drop.setColor(Color.WHITE);
		setEffect(drop);
	}

}
