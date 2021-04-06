package gui;

import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.*;

public class Button extends javafx.scene.control.Button {
	private final String FONT_PATH = "Bangers-Regular.ttf";
	private final String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('Button1.png');";

	public Button(String text) {
		setText(text);
//		setButtonFont();
		setPrefHeight(80);
		setPrefWidth(400);
		initializeButtonListeners();
//		setButtonStyle();

	}

	private void setButtonFont() {
		setFont(Font.loadFont(getClass().getClassLoader().getResource(FONT_PATH).toExternalForm(), 20));
	}

	private void setButtonStyle() {
		setStyle(BUTTON_STYLE);
		setPrefHeight(50);
		setLayoutX(50);
		setLayoutY(50);

	}

	public void initializeButtonListeners() {
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				setPrefHeight(100);
				setPrefWidth(420);
			}

		});
		setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				setPrefHeight(80);
				setPrefWidth(400);
			}
		});
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
