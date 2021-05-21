package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class FieldPane extends GridPane {

	private ObservableList<FieldCell> fieldCells = FXCollections.observableArrayList();

	public FieldPane() {
		this.setPrefWidth(855);
		this.setPrefHeight(500);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				FieldCell cell = new FieldCell();
				if ((i + j) % 2 == 0) {
					cell.getChildren().add(new ImageView("yardscale2.png"));
				}
				fieldCells.add(cell);
				this.add(cell, j, i);
			}
		}
	}

	public ObservableList<FieldCell> getFieldCells() {
		return fieldCells;
	}

	public void setFieldCells(ObservableList<FieldCell> fieldCells) {
		this.fieldCells = fieldCells;
	}
}
