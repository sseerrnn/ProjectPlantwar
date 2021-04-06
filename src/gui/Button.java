package gui;

import javafx.scene.control.*;
import javafx.scene.text.*;

public class Button extends javafx.scene.control.Button {
	private final String FONT_PATH = "Bangers-Regular.ttf";
	private final String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('Button1.png');";

	public Button(String text) {
		setText(text);
//		setButtonFont();
		setPrefHeight(50);
		setPrefWidth(100);
		setButtonStyle();
		

	}

	private void setButtonFont() {
		setFont(Font.loadFont(getClass().getClassLoader().getResource(FONT_PATH).toExternalForm(), 20));
	}
	private void setButtonStyle(){
		setStyle(BUTTON_STYLE);
		setPrefHeight(50);
		setLayoutX(50);
		setLayoutY(50);
		
	}
}
