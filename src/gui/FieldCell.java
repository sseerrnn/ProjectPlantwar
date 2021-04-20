package gui;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class FieldCell extends Pane {

	public FieldCell() {
		this.setPrefWidth(95);
		this.setPrefHeight(100);
		this.setMinWidth(95);
		this.setMinHeight(100);
		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, getInsets())));
	}
}
