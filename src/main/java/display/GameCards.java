package display;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.awt.*;

public class GameCards {
    private static double cardWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.1234;
    private static double cardHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.29514;
    private String name;
    private String group;
    private int count;
    private Background background;
    private String imagePath;

    public GameCards() {
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Background getBackground() {
        return background;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void cardInit() {
        background = new Background(
                new BackgroundImage(
                        new Image(
                                "file:" + System.getProperty("user.dir") + imagePath,
                                cardWidth,
                                cardHeight,
                                false,
                                false
                        ),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT
                )
        );
    }

    public String toString() {
        return name + " - " + group + "\n";
    }
}
