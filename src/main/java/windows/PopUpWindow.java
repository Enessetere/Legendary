package windows;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.util.Set;

public class PopUpWindow {
    private Stage stage = new Stage();

    private void show() {
        stage.showAndWait();
    }

    PopUpWindow(Stage parentStage, String text) {
        stage.initOwner(parentStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.setTitle("Marvel Legendary - Deck Building Game - Warning!");
        stage.getIcons().add(new Image("file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\icon.png"));
        Pane pane = new Pane();
        Label label = new Label(text);
        label.setLayoutY(20);
        label.setLayoutX(90);
        Button resumeWindowButton = new Button("Resume");
        resumeWindowButton.setLayoutX(20);
        resumeWindowButton.setLayoutY(50);
        resumeWindowButton.setPrefSize(100, 30);
        resumeWindowButton.setOnAction(actionEvent -> this.stage.close());
        Button exitWindowButton = new Button("Exit to Menu");
        exitWindowButton.setLayoutX(140);
        exitWindowButton.setLayoutY(50);
        exitWindowButton.setPrefSize(100, 30);
        exitWindowButton.setOnAction(actionEvent -> this.stage.close());
        pane.getChildren().add(label);
        pane.getChildren().add(resumeWindowButton);
        pane.getChildren().add(exitWindowButton);
        exitWindowButton.setOnAction(actionEvent -> exitToMenu(parentStage));
        Scene scene = new Scene(pane, 260, 100);
        stage.setScene(scene);
        stage.setTitle("Marvel Legendary - Deck Building Game");
        show();
    }

    public PopUpWindow(String text) {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.setTitle("Marvel Legendary - Deck Building Game - Warning!");
        stage.getIcons().add(new Image("file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\icon.png"));
        Pane pane = new Pane();
        Label label = new Label(text);
        label.setLayoutY(20);
        label.setLayoutX(90);
        Button resumeWindowButton = new Button("Resume");
        resumeWindowButton.setLayoutX(80);
        resumeWindowButton.setLayoutY(50);
        resumeWindowButton.setPrefSize(100, 30);
        resumeWindowButton.setOnAction(actionEvent -> this.stage.close());
        pane.getChildren().add(label);
        pane.getChildren().add(resumeWindowButton);
        Scene scene = new Scene(pane, 260, 100);
        stage.setScene(scene);
        stage.setTitle("Marvel Legendary - Deck Building Game");
        show();
    }

    public PopUpWindow(String text, Set<String> set) {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.setTitle("Marvel Legendary - Deck Building Game - Warning!");
        stage.getIcons().add(new Image("file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\icon.png"));
        Pane pane = new Pane();
        StringBuilder textBuilder = new StringBuilder(text);
        for(String string : set) {
            textBuilder.append(string).append("\n");
        }
        text = textBuilder.toString();
        Label label = new Label(text);
        label.setLayoutY(20);
        label.setLayoutX(90);
        Button resumeWindowButton = new Button("Continue");
        resumeWindowButton.setLayoutX(80);
        resumeWindowButton.setLayoutY(150);
        resumeWindowButton.setPrefSize(100, 30);
        resumeWindowButton.setOnAction(actionEvent -> this.stage.close());
        pane.getChildren().add(label);
        pane.getChildren().add(resumeWindowButton);
        Scene scene = new Scene(pane, 260, 200);
        stage.setScene(scene);
        stage.setTitle("Marvel Legendary - Deck Building Game");
        show();
    }

    public PopUpWindow(Background background) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.setX(dimension.getWidth() / 2.0 - 200);
        stage.setY(dimension.getHeight() / 2.0 - 300);
        stage.setTitle("Marvel Legendary - Deck Building Game - Warning!");
        stage.getIcons().add(new Image("file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\icon.png"));
        Pane pane = new Pane();
        Label label = new Label();
        label.setLayoutX(0);
        label.setLayoutY(0);
        label.setPrefSize(400,600);
        label.setBackground(
                new Background(
                        new BackgroundImage(
                                new Image(
                                        background.getImages().get(0).getImage().getUrl(),
                                        400,
                                        600,
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
        pane.getChildren().add(label);
        Scene scene = new Scene(pane, 400, 600);
        scene.setOnKeyPressed(keyEvent -> stage.close());
        scene.setOnMouseClicked(mouseEvent -> stage.close());
        stage.setScene(scene);
        stage.setTitle("Marvel Legendary - Deck Building Game");
        show();
    }

    private void exitToMenu(Stage parentStage) {
        parentStage.setScene(new StartUpWindow().createNewScene(SceneEnum.MENU_SCENE, parentStage));
        this.stage.close();
    }
}
