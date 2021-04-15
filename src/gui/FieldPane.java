package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;

public class FieldPane extends GridPane {
	private ObservableList<FieldCell> fieldCells = FXCollections.observableArrayList();

	public FieldPane() {
		this.setPrefWidth(855);
		this.setPrefHeight(500);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				FieldCell cell = new FieldCell();
				fieldCells.add(cell);
				
				this.add(cell, j, i);
			}
		}
	}
}
