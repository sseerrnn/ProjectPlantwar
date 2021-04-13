package gui;

import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class GameButton extends javafx.scene.control.Button {
	private final String FONT_PATH = "Bangers-Regular.ttf";
	private final String BUTTON_STYLE = "-fx-background-color: transparent; -fx-background-image: url('WoodButton.png');";
	private final String BUTTON_STYLE_BIG = "-fx-background-color: transparent; -fx-background-image: url('BigWoodButton.png');";
	private final String BUTTON_STYLE_2 = "-fx-background-color: transparent; -fx-background-image: url('MapButton.png');";
	private final String BUTTON_STYLE_3 = "-fx-background-color: transparent; -fx-background-image: url('back.png');";

	public GameButton(String text) {

		setText(text);

		setButtonFont();
		setButtonStyle();

		initializeButtonListeners();

	}

	private void setButtonFont() {
		setFont(Font.loadFont(getClass().getClassLoader().getResource(FONT_PATH).toExternalForm(), 40));
		setTextFill(Color.CORNSILK);
	}

	private void setButtonStyle() {
		setStyle(BUTTON_STYLE);

		setPrefHeight(80);
		setPrefWidth(400);

	}

	private void setButtonStyleBig() {
		setStyle(BUTTON_STYLE_BIG);

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
				DropShadow drop = new DropShadow();
				drop.setColor(Color.WHITE);
				setEffect(drop);
			}

		});
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setEffect(null);
			}

		});
	}

	public void setUpButtonStyle2() {
		setStyle(BUTTON_STYLE_2);
		setPrefHeight(92);
		setPrefWidth(251);
		initializeButtonListeners2();

	}

	public void initializeButtonListeners2() {
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

			}

		});
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}
	public void setUpButtonStyle3() {
		setStyle(BUTTON_STYLE_3);
		setPrefHeight(77);
		setPrefWidth(82);
		initializeButtonListeners3();

	}
	public void initializeButtonListeners3() {
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
