package windows;

import game.GameBoard;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StartUpWindow extends Application {
    private static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private double cardWidth = dimension.getWidth() * 0.1234;
    private double cardHeight = dimension.getHeight() * 0.29514;
    private double startVillainAndHeroSetWidth = dimension.getWidth() * 0.19206;
    private double startVillainSetHeight = dimension.getHeight() * 0.33565;
    private double startHeroSetHeight = dimension.getHeight() * 0.65394;
    private Pane pane = new Pane();
    private double deckCardWidth = dimension.getWidth() * 0.10937;
    private double deckCardHeight = dimension.getHeight() * 0.25116;
    private double startVillainDeckWidth = dimension.getWidth() * 0.83659;
    private double startVillainDeckHeight = dimension.getHeight() * 0.3745;
    private double mastermindAndSchemeCardX = dimension.getWidth() * 0.054;
    private double schemeCardY = dimension.getHeight() * 0.06597;
    private List<Button> heroButtons;
    private List<Button> villainButtons;
    private Button mastermindButton;
    private Label schemeLabel;

    @Override
    public void start(Stage stage) {
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(createNewScene(SceneEnum.INIT_SCENE, stage));
        stage.setTitle("Marvel Legendary - Deck Building Game");
        stage.getIcons().add(new Image("file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\icon.png"));
        stage.show();
    }

    Scene createNewScene(SceneEnum sceneEnum, Stage stage) {
        pane = createNewPane(sceneEnum, stage);
        Scene scene = new Scene(pane, dimension.getWidth(), dimension.getHeight());
        if (sceneEnum == SceneEnum.INIT_SCENE) {
            scene.setOnKeyPressed(keyEvent -> stage.setScene(createNewScene(SceneEnum.MENU_SCENE, stage)));
            scene.setOnMouseClicked(mouseEvent -> stage.setScene(createNewScene(SceneEnum.MENU_SCENE, stage)));
        }
        if (sceneEnum == SceneEnum.NEW_GAME_SCENE) {
            scene.setOnKeyPressed(keyEvent -> pausedGame(keyEvent.getCode().getCode(), stage));
        }
        return scene;
    }

    private Pane createNewPane(SceneEnum sceneEnum, Stage stage) {
        pane = new Pane();
        switch (sceneEnum) {
            case INIT_SCENE: {
                Image image = new Image("file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\intro.png");
                BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER, new BackgroundSize(dimension.width, dimension.height, false, false, false, true));
                pane.setBackground(new Background(backgroundImage));
                break;
            }
            case MENU_SCENE: {
                Button newGameButton = new Button("New Game");
                newGameButton.setPrefSize(140, 30);
                newGameButton.setLayoutX(dimension.width * 0.1 - 75);
                newGameButton.setLayoutY(dimension.height * 0.5 - 15);
                newGameButton.setOnAction(actionEvent -> startNewGame(stage));
                Button creditsButton = new Button("Credits");
                creditsButton.setPrefSize(140, 30);
                creditsButton.setLayoutX(dimension.width * 0.7 - 65);
                creditsButton.setLayoutY(dimension.height * 0.5 - 15);
                creditsButton.setOnAction(actionEvent -> stage.setScene(createNewScene(SceneEnum.CREDITS_SCENE, stage)));
                Button exitGameButton = new Button("Exit");
                exitGameButton.setOnAction(actionEvent -> stage.close());
                exitGameButton.setPrefSize(140, 30);
                exitGameButton.setLayoutX(dimension.width * 0.9 - 65);
                exitGameButton.setLayoutY(dimension.height * 0.5 - 15);
                pane.getChildren().add(newGameButton);
                pane.getChildren().add(creditsButton);
                pane.getChildren().add(exitGameButton);
                Image image = new Image("file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\background.jpg");
                BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER, new BackgroundSize(dimension.width, dimension.height, false, false, true, false));
                pane.setBackground(new Background(backgroundImage));
                break;
            }
            case NEW_GAME_SCENE: {
                Image image = new Image("file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\board.png", dimension.getWidth(), dimension.height, false, false);
                pane.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
                schemeLabel = new Label();
                schemeLabel.setLayoutX(mastermindAndSchemeCardX);
                schemeLabel.setLayoutY(schemeCardY);
                schemeLabel.setPrefSize(deckCardWidth, deckCardHeight);
                schemeLabel.setVisible(false);
                pane.getChildren().add(schemeLabel);
                mastermindButton = new Button();
                mastermindButton.setLayoutX(mastermindAndSchemeCardX);
                mastermindButton.setLayoutY(startVillainDeckHeight);
                mastermindButton.setPrefSize(deckCardWidth, deckCardHeight);
                mastermindButton.setVisible(false);
                mastermindButton.setOnAction(actionEvent -> GameBoard.getRandomTactic());
                pane.getChildren().add(mastermindButton);
                Button villainFirstSlotButton = new Button();
                villainFirstSlotButton.setPrefSize(cardWidth, cardHeight);
                villainFirstSlotButton.setLayoutX(startVillainAndHeroSetWidth);
                villainFirstSlotButton.setLayoutY(startVillainSetHeight);
                villainFirstSlotButton.setOnAction(actionEvent -> villainFirstSlotButton.setVisible(false));
                villainFirstSlotButton.setVisible(false);
                pane.getChildren().add(villainFirstSlotButton);
                Button villainSecondSlotButton = new Button();
                villainSecondSlotButton.setPrefSize(cardWidth, cardHeight);
                villainSecondSlotButton.setLayoutX(startVillainAndHeroSetWidth + cardWidth);
                villainSecondSlotButton.setLayoutY(startVillainSetHeight);
                villainSecondSlotButton.setOnAction(actionEvent -> villainSecondSlotButton.setVisible(false));
                villainSecondSlotButton.setVisible(false);
                pane.getChildren().add(villainSecondSlotButton);
                Button villainThirdSlotButton = new Button();
                villainThirdSlotButton.setPrefSize(cardWidth, cardHeight);
                villainThirdSlotButton.setLayoutX(startVillainAndHeroSetWidth + 2 * cardWidth);
                villainThirdSlotButton.setLayoutY(startVillainSetHeight);
                villainThirdSlotButton.setOnAction(actionEvent -> villainThirdSlotButton.setVisible(false));
                villainThirdSlotButton.setVisible(false);
                pane.getChildren().add(villainThirdSlotButton);
                Button villainFourthSlotButton = new Button();
                villainFourthSlotButton.setPrefSize(cardWidth, cardHeight);
                villainFourthSlotButton.setLayoutX(startVillainAndHeroSetWidth + 3 * cardWidth);
                villainFourthSlotButton.setLayoutY(startVillainSetHeight);
                villainFourthSlotButton.setOnAction(actionEvent -> villainFourthSlotButton.setVisible(false));
                villainFourthSlotButton.setVisible(false);
                pane.getChildren().add(villainFourthSlotButton);
                Button villainFifthSlotButton = new Button();
                villainFifthSlotButton.setPrefSize(cardWidth, cardHeight);
                villainFifthSlotButton.setLayoutX(startVillainAndHeroSetWidth + 4 * cardWidth);
                villainFifthSlotButton.setLayoutY(startVillainSetHeight);
                villainFifthSlotButton.setOnAction(actionEvent -> villainFifthSlotButton.setVisible(false));
                villainFifthSlotButton.setVisible(false);
                pane.getChildren().add(villainFifthSlotButton);
                Button villainDeckButton = new Button();
                villainDeckButton.setPrefSize(deckCardWidth, deckCardHeight);
                villainDeckButton.setLayoutX(startVillainDeckWidth);
                villainDeckButton.setLayoutY(startVillainDeckHeight);
                villainDeckButton.setBackground(
                        new Background(
                                new BackgroundImage(
                                        new Image(
                                                "file:" + System.getProperty("user.dir") + "\\main\\src\\resources\\images\\card-reverse.png",
                                                deckCardWidth,
                                                deckCardHeight,
                                                false,
                                                false
                                        ),
                                        BackgroundRepeat.NO_REPEAT,
                                        BackgroundRepeat.NO_REPEAT,
                                        BackgroundPosition.CENTER,
                                        BackgroundSize.DEFAULT
                                )
                        )
                );
                villainButtons = new ArrayList<>();
                villainButtons.add(villainFirstSlotButton);
                villainButtons.add(villainSecondSlotButton);
                villainButtons.add(villainThirdSlotButton);
                villainButtons.add(villainFourthSlotButton);
                villainButtons.add(villainFifthSlotButton);
                villainDeckButton.setOnAction(actionEvent -> GameBoard.getRandomVillain(villainButtons));
                pane.getChildren().add(villainDeckButton);
                Button heroFirstSlotButton = new Button();
                heroFirstSlotButton.setLayoutX(startVillainAndHeroSetWidth);
                heroFirstSlotButton.setLayoutY(startHeroSetHeight);
                heroFirstSlotButton.setPrefSize(cardWidth, cardHeight);
                heroFirstSlotButton.setOnAction(actionEvent -> GameBoard.getRandomHero(heroFirstSlotButton));
                heroFirstSlotButton.setVisible(false);
                pane.getChildren().add(heroFirstSlotButton);
                Button heroSecondSlotButton = new Button();
                heroSecondSlotButton.setLayoutX(startVillainAndHeroSetWidth + cardWidth);
                heroSecondSlotButton.setLayoutY(startHeroSetHeight);
                heroSecondSlotButton.setPrefSize(cardWidth, cardHeight);
                heroSecondSlotButton.setOnAction(actionEvent -> GameBoard.getRandomHero(heroSecondSlotButton));
                heroSecondSlotButton.setVisible(false);
                pane.getChildren().add(heroSecondSlotButton);
                Button heroThirdSlotButton = new Button();
                heroThirdSlotButton.setLayoutX(startVillainAndHeroSetWidth + 2 * cardWidth);
                heroThirdSlotButton.setLayoutY(startHeroSetHeight);
                heroThirdSlotButton.setPrefSize(cardWidth, cardHeight);
                heroThirdSlotButton.setOnAction(actionEvent -> GameBoard.getRandomHero(heroThirdSlotButton));
                heroThirdSlotButton.setVisible(false);
                pane.getChildren().add(heroThirdSlotButton);
                Button heroFourthSlotButton = new Button();
                heroFourthSlotButton.setLayoutX(startVillainAndHeroSetWidth + 3 * cardWidth);
                heroFourthSlotButton.setLayoutY(startHeroSetHeight);
                heroFourthSlotButton.setPrefSize(cardWidth, cardHeight);
                heroFourthSlotButton.setOnAction(actionEvent -> GameBoard.getRandomHero(heroFourthSlotButton));
                heroFourthSlotButton.setVisible(false);
                pane.getChildren().add(heroFourthSlotButton);
                Button heroFifthSlotButton = new Button();
                heroFifthSlotButton.setLayoutX(startVillainAndHeroSetWidth + 4 * cardWidth);
                heroFifthSlotButton.setLayoutY(startHeroSetHeight);
                heroFifthSlotButton.setPrefSize(cardWidth, cardHeight);
                heroFifthSlotButton.setOnAction(actionEvent -> GameBoard.getRandomHero(heroFifthSlotButton));
                heroFifthSlotButton.setVisible(false);
                pane.getChildren().add(heroFifthSlotButton);
                heroButtons = new ArrayList<>();
                heroButtons.add(heroFirstSlotButton);
                heroButtons.add(heroSecondSlotButton);
                heroButtons.add(heroThirdSlotButton);
                heroButtons.add(heroFourthSlotButton);
                heroButtons.add(heroFifthSlotButton);
                break;
            }
            case CREDITS_SCENE: {
                Image image = new Image("file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\intro.png");
                BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER, new BackgroundSize(dimension.width, dimension.height, false, false, false, true));
                Label label = new Label();
                pane.setBackground(new Background(backgroundImage));
                label.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
                label.setLayoutY(dimension.height / 2.0 - 100);
                label.setLayoutX(dimension.width / 2.0 - 150);
                label.setPrefSize(300, 200);
                label.setAlignment(Pos.CENTER);
                label.setTextAlignment(TextAlignment.CENTER);
                label.setText("Author: S. \"Arethius\" M.\nIdea of this project: A. \"Necro\" M.\nDate of creation: 26.09.2019\nVersion: 1.0\nGraphics found via Google search.\nSome graphics were acquired from:\nhttps://marveldbg.wordpress.com/");
                label.textFillProperty().setValue(Color.WHITE);
                Button backToMenuButton = new Button("Back to menu");
                backToMenuButton.setPrefSize(140, 30);
                backToMenuButton.setLayoutX(dimension.width - 160);
                backToMenuButton.setLayoutY(dimension.height - 50);
                backToMenuButton.setOnAction(actionEvent -> stage.setScene(createNewScene(SceneEnum.MENU_SCENE, stage)));
                pane.getChildren().add(label);
                pane.getChildren().add(backToMenuButton);
                break;
            }
        }
        return pane;
    }

    private void pausedGame(int x, Stage stage) {
        if (x == 27) {
            new PopUpWindow(stage, "Game Paused");
        }
    }

    private void startNewGame(Stage stage) {
        setPlayerNumber();
        if (GameBoard.getNumberOfPlayers() < 0) {
            stage.setScene(createNewScene(SceneEnum.MENU_SCENE, stage));
        } else {
            stage.setScene(createNewScene(SceneEnum.NEW_GAME_SCENE, stage));
            GameBoard.getScheme(schemeLabel);
            GameBoard.getMastermind(mastermindButton);
            GameBoard.cardsUsed();
            for(Button b : heroButtons) {
                GameBoard.getRandomHero(b);
            }
        }
    }

    private void setPlayerNumber() {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Marvel Legendary - Deck Building Game");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(new Image("file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\icon.png"));
        Label label = new Label("Choose number of players:");
        label.setLayoutX(90);
        label.setLayoutY(20);
        Button onePlayerButton = new Button("1");
        onePlayerButton.setPrefSize(50, 50);
        onePlayerButton.setLayoutX(20);
        onePlayerButton.setLayoutY(50);
        onePlayerButton.setOnAction(actionEvent -> createGameBoard(1, stage));
        onePlayerButton.setDisable(true);
        Button twoPlayersButton = new Button("2");
        twoPlayersButton.setPrefSize(50, 50);
        twoPlayersButton.setLayoutX(80);
        twoPlayersButton.setLayoutY(50);
        twoPlayersButton.setOnAction(actionEvent -> createGameBoard(2, stage));
        Button threePlayersButton = new Button("3");
        threePlayersButton.setPrefSize(50, 50);
        threePlayersButton.setLayoutX(140);
        threePlayersButton.setLayoutY(50);
        threePlayersButton.setOnAction(actionEvent -> createGameBoard(3, stage));
        Button fourPlayersButton = new Button("4");
        fourPlayersButton.setPrefSize(50, 50);
        fourPlayersButton.setLayoutX(200);
        fourPlayersButton.setLayoutY(50);
        fourPlayersButton.setOnAction(actionEvent -> createGameBoard(4, stage));
        Button fivePlayersButton = new Button("5");
        fivePlayersButton.setPrefSize(50, 50);
        fivePlayersButton.setLayoutX(260);
        fivePlayersButton.setLayoutY(50);
        fivePlayersButton.setOnAction(actionEvent -> createGameBoard(5, stage));
        pane = new Pane();
        pane.setPrefSize(330, 120);
        pane.getChildren().add(label);
        pane.getChildren().add(onePlayerButton);
        pane.getChildren().add(twoPlayersButton);
        pane.getChildren().add(threePlayersButton);
        pane.getChildren().add(fourPlayersButton);
        pane.getChildren().add(fivePlayersButton);
        stage.setScene(new Scene(pane));
        stage.showAndWait();
    }

    private void createGameBoard(int playerNumber, Stage stage) {
        new GameBoard(playerNumber);
        stage.close();
    }
}
