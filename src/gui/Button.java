package gui;

import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.*;

public class Button extends javafx.scene.control.Button {
	private final String FONT_PATH = "Bangers-Regular.ttf";
	private final String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('Button1.png');";
	private final String BUTTON_STYLE_BIG = "-fx-background-color: transparent; -fx-background-image: url('BigButton2.png');";

	public Button(String text) {
		
		setText(text);
		setButtonFont();
		setButtonStyle();

		initializeButtonListeners();

	}

	private void setButtonFont() {
		setFont(Font.loadFont(getClass().getClassLoader().getResource(FONT_PATH).toExternalForm(), 40));
	}

	private void setButtonStyle() {
		setStyle(BUTTON_STYLE);
		setPrefHeight(50);
		setPrefHeight(80);
		setPrefWidth(400);

	}

	private void setButtonStyleBig() {
		setStyle(BUTTON_STYLE_BIG);
		setPrefHeight(50);
		setPrefHeight(80);
		setPrefWidth(420);
	}

	public void initializeButtonListeners() {
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub

				setButtonStyleBig();
			}

		});
		setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub

				setButtonStyle();
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
