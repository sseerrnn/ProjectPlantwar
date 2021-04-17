package gui;

import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameSubScene extends SubScene {
	private AnchorPane root;
	protected final String BACKGROUND_PATH = "board.png";

	public GameSubScene(AnchorPane pane,double width, double height) {
		super(new AnchorPane(), width, height);
		root = (AnchorPane) this.getRoot();

		root.setLayoutX(200);
		root.setLayoutY(94);
		
		ImageView board = new ImageView(BACKGROUND_PATH);
		root.setBackground(null);
		root.getChildren().add(board);

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
	

}
