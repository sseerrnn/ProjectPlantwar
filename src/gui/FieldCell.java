package gui;

import components.character.Plant;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameController;

public class FieldCell extends Pane {

	private Plant plant;
	private int layoutx;
	private int layouty;

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
