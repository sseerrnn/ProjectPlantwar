package gui;

import java.util.ArrayList;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameSubScene extends SubScene {

	protected static final String BACKGROUND_PATH = "board.png";
	protected static final int width = 983;
	protected static final int height = 520;
protected static final String[] PLANTBUTTON_OFF_PATH= {"peashooterbuttonoff.png","sunflowerbuttonoff.png","wallnutbuttonoff.png","potatobombbuttonoff.png","cabbagepultbuttonoff.png","snowpeabuttonoff.png","twinsunflowerbuttonoff.png","cornpultbuttonoff.png","doublepeashooterbuttonoff.png","tallnutbuttonoff.png"};

	public GameSubScene() {
		super(new AnchorPane(), width, height);

		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_PATH), null, null, null, null);
		AnchorPane root = (AnchorPane) this.getRoot();
//		root.setLayoutX(200);
//		root.setLayoutY(94);
		root.setBackground(new Background(image));
//		root.setPrefHeight(height);
//		root.setPrefWidth(width);
		this.setLayoutX(200);
		this.setLayoutY(-94);
		this.setVisible(false);
//		root.getChildren().add();

		for (int i = 0; i < 10; i++) {
//			Rectangle rect = new Rectangle(165, 107, Color.GRAY);
			ImageView pic= new ImageView(PLANTBUTTON_OFF_PATH[i]);
			
			if (i < 5) {

				pic.setLayoutX(55 + 177 * (i));
				pic.setLayoutY(146);
				
				root.getChildren().add(pic);
			} else {

				pic.setLayoutX(55 + 177 * (i - 5));
				pic.setLayoutY(272);
				

				root.getChildren().add(pic);
			}

		}

	}

	public AnchorPane getPane() {
		return (AnchorPane) this.getRoot();
	}

	public void moveSubSceneIn() {
		TranslateTransition move = new TranslateTransition();
        move.setNode(this);
        this.setVisible(true);
        move.setToY(94*2);
        move.play();
        
	}
	public void moveSubSceneOut() {
		TranslateTransition move = new TranslateTransition();
//		move.setDuration(Duration.millis(100));
        move.setNode(this);
        move.setToY(-94*2 -520);
        move.play();
//        this.setVisible(false);
	}
}
