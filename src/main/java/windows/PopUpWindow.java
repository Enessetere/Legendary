package windows;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PopUpWindow {
    private Stage stage = new Stage();
    private List<Label> labels;

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
        label.setLayoutX(50);
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

    PopUpWindow(Stage stage) {
        stage.setX((Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2) - 115);
        stage.setY((Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2) - 50);
        stage.setTitle("Loading...");
        stage.getIcons().add(new Image("file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\icon.png"));
        stage.initStyle(StageStyle.DECORATED);
        labels = new ArrayList<>();
        Pane pane = new Pane();
        pane.setPrefSize(230, 100);
        Label label0 = new Label();
        label0.setPrefSize(20,80);
        label0.setLayoutX(10);
        label0.setLayoutY(10);
        label0.setVisible(false);
        label0.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        label0.setOnMouseClicked(mouseEvent -> stage.close());
        Label label1 = new Label();
        label1.setPrefSize(20,80);
        label1.setLayoutX(31);
        label1.setLayoutY(10);
        label1.setVisible(false);
        label1.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        Label label2 = new Label();
        label2.setPrefSize(20,80);
        label2.setLayoutX(52);
        label2.setLayoutY(10);
        label2.setVisible(false);
        label2.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        Label label3 = new Label();
        label3.setPrefSize(20,80);
        label3.setLayoutX(73);
        label3.setLayoutY(10);
        label3.setVisible(false);
        label3.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        Label label4 = new Label();
        label4.setPrefSize(20,80);
        label4.setLayoutX(94);
        label4.setLayoutY(10);
        label4.setVisible(false);
        label4.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        Label label5 = new Label();
        label5.setPrefSize(20,80);
        label5.setLayoutX(115);
        label5.setLayoutY(10);
        label5.setVisible(false);
        label5.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        Label label6 = new Label();
        label6.setPrefSize(20,80);
        label6.setLayoutX(136);
        label6.setLayoutY(10);
        label6.setVisible(false);
        label6.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        Label label7 = new Label();
        label7.setPrefSize(20,80);
        label7.setLayoutX(157);
        label7.setLayoutY(10);
        label7.setVisible(false);
        label7.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        Label label8 = new Label();
        label8.setPrefSize(20,80);
        label8.setLayoutX(178);
        label8.setLayoutY(10);
        label8.setVisible(false);
        label8.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        Label label9 = new Label();
        label9.setPrefSize(20,80);
        label9.setLayoutX(199);
        label9.setLayoutY(10);
        label9.setVisible(false);
        label9.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));
        labels.add(label0);
        labels.add(label1);
        labels.add(label2);
        labels.add(label3);
        labels.add(label4);
        labels.add(label5);
        labels.add(label6);
        labels.add(label7);
        labels.add(label8);
        labels.add(label9);
        pane.getChildren().add(label0);
        pane.getChildren().add(label1);
        pane.getChildren().add(label2);
        pane.getChildren().add(label3);
        pane.getChildren().add(label4);
        pane.getChildren().add(label5);
        pane.getChildren().add(label6);
        pane.getChildren().add(label7);
        pane.getChildren().add(label8);
        pane.getChildren().add(label9);
        stage.setScene(new Scene(pane));
        stage.show();
    }

    public List<Label> getLabels () {
        return labels;
    }

    private void exitToMenu(Stage parentStage) {
        parentStage.setScene(new StartUpWindow().createNewScene(SceneEnum.MENU_SCENE, parentStage));
        this.stage.close();
    }
}
