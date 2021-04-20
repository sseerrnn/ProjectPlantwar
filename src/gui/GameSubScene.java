package gui;

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

public class GameSubScene extends SubScene {
	
	protected static final String BACKGROUND_PATH = "board.png";
	protected static final int width=983	;
	protected static final int height=520;

	public GameSubScene() {
		super(new AnchorPane(), width, height);

		
		
		BackgroundImage image =new BackgroundImage(new Image(BACKGROUND_PATH), null, null, null, null);
		AnchorPane root = (AnchorPane) this.getRoot();
//		root.setLayoutX(200);
//		root.setLayoutY(94);
		root.setBackground(new Background(image));
//		root.setPrefHeight(height);
//		root.setPrefWidth(width);
this.setLayoutX(200);
this.setLayoutY(94);
//		root.getChildren().add();

		for(int i=0;i<10;i++) {
			Rectangle rect = new Rectangle(165,107,Color.GRAY);
			if(i<5) {
			
				rect.setLayoutX(55+177*(i));
				rect.setLayoutY(146);
				root.getChildren().add(rect);
			}else {

				rect.setLayoutX(55+177*(i-5));
				rect.setLayoutY(272);
				root.getChildren().add(rect);
			}
			
			
		}
		
	}
	
public AnchorPane getPane() {
	 return (AnchorPane)this.getRoot();
}
}
