package scene;



import exception.ChooseCharacterFailException;
import exception.PlantNotEnoughFailException;
import gui.FieldCell;
import gui.FieldPane;
import gui.GameButton;
import gui.GameSubScene;
import gui.PlantButton;
import gui.SpriteAnimation;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Camera;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.GameController;
import logic.LevelController;
import javafx.scene.input.MouseEvent;

public class SceneController {
	protected static final int Height = 674;
	protected static final int Width = 1200;
	protected Scene mainScene;
	protected Stage mainStage;
	protected VBox buttonPane;
	protected AnchorPane mainPane;

	private GameController gameController;
	private LevelController levelController;
	private GameSubScene chooseChar;

	public SceneController() {
		mainStage = new Stage();
		mainStage.setTitle("PlantWar");
		setUpMainStage();

		mainStage.setScene(mainScene);
		mainStage.setResizable(false);

	}

	public Stage getMainstage() {
		return mainStage;
	}

	public void setUpMainStage() {
		createButtonPane();
		createMenuButtons();
		createBackgroundPane();
		createLogo();
		mainScene = new Scene(mainPane, Width, Height);
	}

	public void setMainstage(Stage mainstage) {
		this.mainStage = mainstage;
	}

	public void createStartButton() {
		GameButton StartButton = new GameButton("Start Game");
		buttonPane.getChildren().add(StartButton);
		StartButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setUpChooseMapScene();
				mainStage.setScene(mainScene);

			}
		});
	}

	public void createExitButton() {
		GameButton ExitButton = new GameButton("Exit Game");
		buttonPane.getChildren().add(ExitButton);
		ExitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mainStage.close();
			}

		});
	}

	public void createMenuButtons() {
		createStartButton();
		createExitButton();
	}

	public void createButtonPane() {
		buttonPane = new VBox();
		buttonPane.setSpacing(20);
		buttonPane.setLayoutX(223);
		buttonPane.setLayoutY(340);
	}

	public void createLogo() {
		ImageView Logo = new ImageView("Logo.png");
		Logo.setLayoutX(125);
		Logo.setLayoutY(105);
		mainPane.getChildren().add(Logo);
	}

	public void createBackgroundPane() {
		mainPane = new AnchorPane();
		mainPane.getChildren().addAll(new ImageView("Background.jpg"), buttonPane);

	}

	public void setUpChooseMapScene() {
		setUpChooseMapPane();
		createChooseMapButtons();
		createMapTopic();
		createMapPicture();
		mainScene = new Scene(mainPane, Width, Height);

	}

	public void setUpChooseMapPane() {
		mainPane = new AnchorPane();
		mainPane.getChildren().add(new ImageView("blue green.jpg"));

	}

	public void createBackButton() {
		GameButton back = new GameButton("");
		back.setUpButtonStyle3();
		mainPane.getChildren().add(back);
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setUpMainStage();
				mainStage.setScene(mainScene);
			}
		});
		back.setLayoutX(38);
		back.setLayoutY(36);
	}

	public void createChooseMapButton1() {
		GameButton map1 = new GameButton("ENTER");
		map1.setUpButtonStyle2();
		mainPane.getChildren().add(map1);
		map1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

				setUpGameScene();
				mainStage.setScene(mainScene);
				createChooseCharSubScene();
				chooseChar.moveSubSceneIn();

			}
		});
		map1.setLayoutX(166.5);
		map1.setLayoutY(510);
	}

	public void createChooseMapButton2() {
		GameButton map2 = new GameButton("ENTER");
		map2.setUpButtonStyle2();
		mainPane.getChildren().add(map2);
		map2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		map2.setLayoutX(474.5);
		map2.setLayoutY(510);
	}

	public void createChooseMapButton3() {
		GameButton map3 = new GameButton("ENTER");
		map3.setUpButtonStyle2();
		mainPane.getChildren().add(map3);
		map3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		map3.setLayoutX(782.5);
		map3.setLayoutY(510);
	}

	public void createChooseMapButtons() {
		createChooseMapButton1();
		createChooseMapButton2();
		createChooseMapButton3();
		createBackButton();
	}

	public void createMapTopic() {
		ImageView maps = new ImageView("Maps.png");
		maps.setLayoutX(444);
		maps.setLayoutY(58);
		mainPane.getChildren().add(maps);

	}

	public void createMapPicture() {
		ImageView mapPic1 = new ImageView("black.jpg");
		ImageView mapPic2 = new ImageView("black.jpg");
		ImageView mapPic3 = new ImageView("black.jpg");

		mapPic1.setLayoutX(180);
		mapPic1.setLayoutY(216);
		mapPic2.setLayoutX(489);
		mapPic2.setLayoutY(216);
		mapPic3.setLayoutX(797);
		mapPic3.setLayoutY(216);

		mainPane.getChildren().addAll(mapPic1, mapPic2, mapPic3);

		ImageView mapLock2 = new ImageView("lock.png");
		ImageView mapLock3 = new ImageView("lock.png");

		mapLock2.setLayoutX(548);
		mapLock2.setLayoutY(269);
		mapLock3.setLayoutX(857);
		mapLock3.setLayoutY(269);

		mainPane.getChildren().addAll(mapLock2, mapLock3);

	}

	public void setUpGameScene() {
		setUpGamePane();
		setUpFieldPane();
		createGameButtons();
		mainScene = new Scene(mainPane, Width, Height);

	}

	public void setUpGamePane() {
		mainPane = new AnchorPane();
		mainPane.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));// color background

	}

	public void createSubmitButton() {
		GameButton submit = new GameButton("Submit");
		submit.setUpSubmitButtonStyle();
		submit.setLayoutX(691);
		submit.setLayoutY(437);
		chooseChar.getPane().getChildren().add(submit);
		submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					gameController.checkPlantEnough();
					gameController.setGameStart(true);
					setUpInGamePlantButtons();
					chooseChar.moveSubSceneOut();
				} catch (PlantNotEnoughFailException e) {
					System.out.println("Submit failed, " + e.getMessage());
				}
			}
		});

	}

	public void createChooseCharSubScene() {
		initializeLevelController();
		initializeGameController();
		chooseChar = new GameSubScene();

		mainPane.getChildren().add(chooseChar);

		createSubmitButton();

		for (int i = 0; i < levelController.getPlantButtonList().size(); i++) {
			if (i < 5) {
				PlantButton chooseCharButton = levelController.getPlantButtonList().get(i);
				chooseCharButton.setLayoutX(55 + 177 * (i));
				chooseCharButton.setLayoutY(146);
				chooseChar.getPane().getChildren().add(chooseCharButton);
				chooseCharButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {

						try {
							gameController.checkSpaceInselectedPlantButtons();
							chooseCharButton.setVisible(false);
							PlantButton charButton = new PlantButton(chooseCharButton.getPlant().getPlantName());
							gameController.setSelectedPlantButton(charButton);
							gameController.getSelectedPlantButtons().set(gameController.getSpaceIndex(), charButton);
							mainPane.getChildren().add(charButton);

							moveCharacterButton(chooseCharButton, charButton);

							setUpUnselectButtonListener(charButton, chooseCharButton);

						} catch (ChooseCharacterFailException e) {
							System.out.println("Choose character failed, " + e.getMessage());
						}
					}
				});

			} else {
				PlantButton chooseCharButton = levelController.getPlantButtonList().get(i);
				int j = i - 5;
				chooseCharButton.setLayoutX(55 + 177 * (j));
				chooseCharButton.setLayoutY(272);
				chooseChar.getPane().getChildren().add(chooseCharButton);
				chooseCharButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {

						try {
							gameController.checkSpaceInselectedPlantButtons();
							chooseCharButton.setVisible(false);
							PlantButton charButton = new PlantButton(chooseCharButton.getPlant().getPlantName());
							gameController.setSelectedPlantButton(charButton);
							gameController.getSelectedPlantButtons().set(gameController.getSpaceIndex(), charButton);
							mainPane.getChildren().add(charButton);

							moveCharacterButton(chooseCharButton, charButton);

							setUpUnselectButtonListener(charButton, chooseCharButton);

						} catch (ChooseCharacterFailException e) {

							System.out.println("Choose character failed, " + e.getMessage());
						}

					}
				});

			}
		}
	}
	public void initializeFieldCellListeners(FieldCell cell) {
		cell.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				onClickHandler(cell);
			}
		});
			
		
		
	}
	public void onClickHandler(FieldCell cell) {
		if(gameController.getSelectedPlant()!=null) {
			if(cell.getPlant()==null) {
				cell.setPlant(gameController.getSelectedPlant());
				gameController.reduceEneryToBuyPlant();
//				SpriteAnimation sprite=new SpriteAnimation(null, null, Height, Height, Height, Height, Width, Height)
			}
		}
	}

	public void setUpInGamePlantButtons() {
		for (PlantButton charButton : gameController.getSelectedPlantButtons()) {
			setUpPlantButton(charButton);
		}
	}

	public void setUpPlantButton(PlantButton charButton) {

		charButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(0);
				gameController.setSelectedPlant(charButton.getPlant());
			}
		});
	}

	public void setUpUnselectButtonListener(PlantButton charButton, PlantButton chooseCharButton) {
		charButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				chooseCharButton.setVisible(true);
				charButton.setVisible(false);

				gameController.getSelectedPlantButtons()
						.set(gameController.getSelectedPlantButtons().indexOf(charButton), new PlantButton(""));
			}

		});

	}

	public void moveCharacterButton(PlantButton input, PlantButton output) {
		TranslateTransition transition = new TranslateTransition();
		transition.setNode(output);
		transition.setDuration(Duration.millis(100));

		output.setLayoutX(input.getLayoutX() + 199);
		output.setLayoutY(input.getLayoutY() + 96);

		transition.setToX(19 - output.getLayoutX());
		transition.setToY(+91 + gameController.getSpaceIndex() * 105 - output.getLayoutY());
		transition.play();
	}

	public void initializeLevelController() {
		levelController = new LevelController();
	}

	public void initializeGameController() {
		gameController = new GameController();
	}

	public void setUpFieldPane() {
		FieldPane field = new FieldPane();
		mainPane.getChildren().add(field);
		field.setLayoutX(300);
		field.setLayoutY(100);
	}

	public void createPauseButton() {
		GameButton pause = new GameButton("");
		pause.setUpPauseButtonStyle();
		mainPane.getChildren().add(pause);
		pause.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// pop up Pause menu
			}

		});
		pause.setLayoutX(1112);
		pause.setLayoutY(17);

	}

	public void createGameButtons() {
		createPauseButton();
	}
}
