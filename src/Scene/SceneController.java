package scene;

import components.character.GameCharacter;
import components.other.Sun;
import exception.ChooseCharacterFailedException;
import exception.PlantNotEnoughFailedException;
import gui.FieldCell;
import gui.FieldPane;
import gui.GameButton;
import gui.GameEnding;
import gui.GameSubScene;
import gui.PlantButton;
import gui.SpriteAnimation;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.GameController;
import logic.LevelController;
import javafx.scene.input.MouseEvent;

public class SceneController {

	private static SceneController instance = null;

	protected static final int HEIGHT = 674;
	protected static final int WIDTH = 1200;

	protected Scene mainScene;
	protected Stage mainStage;
	protected VBox buttonPane;
	protected AnchorPane mainPane;

	private GameController gameController;
	private LevelController levelController;
	private GameSubScene chooseChar;
	private Canvas canvas;
	private GraphicsContext gc;

	private SceneController() {
		mainStage = new Stage();
		mainStage.setTitle("PlantWar");
		setUpMainStage();

		mainStage.setScene(mainScene);
		mainStage.setResizable(false);
	}

	public static SceneController getInstance() {
		if (instance == null)
			instance = new SceneController();
		return instance;
	}

	public void setUpMainStage() {
		createButtonPane();
		createMenuButtons();
		createBackgroundPane();
		createLogo();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
	}

	public void createStartButton() {
		GameButton StartButton = new GameButton("Start Game");
		buttonPane.getChildren().add(StartButton);
		StartButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
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
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
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
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
	}

	public void setUpGamePane() {
		mainPane = new AnchorPane();
		ImageView yardBorder = new ImageView("yardborder.png");
		yardBorder.setLayoutX(297);
		yardBorder.setLayoutY(96);
		mainPane.getChildren().addAll(new ImageView("brickbg.png"), yardBorder);
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
				try {
					gameController.checkPlantEnough();
					gameController.setGameStart(true);
					setUpInGamePlantButtons();
					gameController.Startgame();
					chooseChar.moveSubSceneOut();
					toFallSun();
					createSunCountSign();
					createCanvas();
				} catch (PlantNotEnoughFailedException e) {
					System.out.println("Submit failed, " + e.getMessage());
				}
			}
		});
	}

	public void toFallSun() {
		if (gameController.getSunCount() < 50) {
			if (gameController.getCurrentTime() % 2 == 0) {
				Sun sun = new Sun();
				sun.toImageView();
				sun.toFalling(sun.getImageView());
				mainPane.getChildren().add(sun.getImageView());
				gameController.setSunCount(gameController.getSunCount() + 1);
				System.out.println(gameController.getSunCount());
				sun.getImageView().setOnMouseClicked(new EventHandler<Event>() {
					@Override
					public void handle(Event arg0) {
						sun.moveOut(sun.getImageView());
						gameController.increaseEnegy();
					}
				});
			}
		}
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
						} catch (ChooseCharacterFailedException e) {
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
						} catch (ChooseCharacterFailedException e) {
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
				onClickHandler(cell);
			}
		});
	}

	public void onClickHandler(FieldCell cell) {
		if (gameController.getSelectedPlant() != null) {
			if (cell.getPlant() == null) {
				cell.setPlant(gameController.getSelectedPlant());
				gameController.reduceEneryToBuyPlant();
				gameController.getSelectedPlant().setUp();
				gameController.getSelectedPlant().setInitX(
						((int) cell.getLayoutX()) + 318 + gameController.getSelectedPlant().getGameChar().getDiffX());
				gameController.getSelectedPlant().setInitY(
						((int) cell.getLayoutY()) + 96 + gameController.getSelectedPlant().getGameChar().getDiffY());

				gameController.getSelectedPlant().setUp();
				gameController.getPlantInGame().add(gameController.getSelectedPlant().getGameChar());
				gameController.getInGameCharacter().add(gameController.getSelectedPlant().getGameChar());

				Rectangle box = gameController.getSelectedPlant().getGameChar().getBox();
				box.setLayoutX((int) cell.getLayoutX() + 300);
				box.setLayoutY(((int) cell.getLayoutY()) + 100);
				box.setFill(Color.TRANSPARENT);
				mainPane.getChildren().add(gameController.getSelectedPlant().getGameChar().getBox());
				mainPane.getChildren().add(gameController.getSelectedPlant().getGameChar().getImageView());
				gameController.getSelectedPlant().getGameChar().setFieldCell(cell);
				System.out.println(box.getLayoutX());
				System.out.println(box.getLayoutY());
				gameController.checkPlantRow(gameController.getSelectedPlant().getGameChar());
			}
		}
		System.out.println(cell.getPlant().getPlantName());
	}

	public void setUpInGamePlantButtons() {
		for (PlantButton charButton : gameController.getSelectedPlantButtons()) {
			setUpPlantButton(charButton);
		}
	}

	public void setUpPlantButton(PlantButton charButton) {
		charButton.setOnAction(null);
		charButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				gameController.setSelectedPlant(charButton.getPlant());
				System.out.println(gameController.getSelectedPlant().getPlantName());
			}
		});
	}

	public void setUpUnselectButtonListener(PlantButton charButton, PlantButton chooseCharButton) {
		charButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				chooseCharButton.setVisible(true);
				mainPane.getChildren().remove(charButton);
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
		ImageView fence = new ImageView("fence.png");
		fence.setLayoutX(0);
		fence.setLayoutY(572);
		mainPane.getChildren().addAll(field,fence);
		field.setLayoutX(300);
		field.setLayoutY(100);

		for (FieldCell cell : field.getFieldCells()) {
			initializeFieldCellListeners(cell);
		}
	}

	public void createPauseButton() {
		GameButton pause = new GameButton("");
		pause.setUpPauseButtonStyle();
		mainPane.getChildren().add(pause);
		pause.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// pop up Pause menu
			}
		});
		pause.setLayoutX(1112);
		pause.setLayoutY(17);
	}

	public void createGameButtons() {
		createPauseButton();
	}

	public void createCanvas() {
		canvas = new Canvas(300, 100);
		gc = canvas.getGraphicsContext2D();
		mainPane.getChildren().add(canvas);
		canvas.setLayoutX(-58);
		canvas.setLayoutY(9);
	}

	public void createSunCountSign() {
		ImageView sign = new ImageView("suncount.png");
		sign.setLayoutX(11);
		sign.setLayoutY(15);
		mainPane.getChildren().add(sign);
	}

	public void setUpGameEnding(boolean isWin) {
		GameEnding gameEnding = new GameEnding(isWin);
		mainScene = new Scene(gameEnding.getEndingPane(), WIDTH, HEIGHT);
	}

	public Scene getMainScene() {
		return mainScene;
	}

	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
	}

	public GameSubScene getChooseChar() {
		return chooseChar;
	}

	public void setChooseChar(GameSubScene chooseChar) {
		this.chooseChar = chooseChar;
	}

	public Stage getMainstage() {
		return mainStage;
	}

	public void setMainstage(Stage mainstage) {
		this.mainStage = mainstage;
	}

	public AnchorPane getMainPane() {
		return mainPane;
	}

	public void setMainPane(AnchorPane mainPane) {
		this.mainPane = mainPane;
	}

	public GraphicsContext getGc() {
		return gc;
	}

	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

}
