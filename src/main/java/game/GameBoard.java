package game;

import display.GameCards;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import windows.PopUpWindow;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class GameBoard{
    private static int numberOfPlayers;
    private static int numberOfHeroes;
    private static int numberOfVillains;
    private static int numberOfHenchman;
    private static int numberOfBystanders;
    private static int numberOfSchemeTwists;
    private static Background schemeBackground;
    private static boolean isSkrullRequired;
    private static int schemeId;
    private static String mastermindLeadsVillains;
    private static String mastermindLeadsHenchman;
    private static boolean isMastermindLeadsVillain;
    private static double schemeWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.10937;
    private static double schemeHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.25116;
    private static List<GameCards> heroDeck;
    private static List<GameCards> villainDeck;
    private static List<GameCards> mastermindDeck;
    private static Set<String> heroGroups;
    private static Set<String> villainGroups;

    public GameBoard(int numberOfPlayers) {
        isSkrullRequired = false;
        GameBoard.numberOfPlayers = numberOfPlayers;
        switch (numberOfPlayers) {
            case 2: {
                numberOfHeroes = 5;
                numberOfVillains = 2;
                numberOfHenchman = 1;
                numberOfBystanders = 2;
                break;
            }
            case 3: {
                numberOfHeroes = 5;
                numberOfVillains = 3;
                numberOfHenchman = 1;
                numberOfBystanders = 8;
                break;
            }
            case 4: {
                numberOfHeroes = 5;
                numberOfVillains = 3;
                numberOfHenchman = 2;
                numberOfBystanders = 8;
                break;
            }
            case 5: {
                numberOfHeroes = 6;
                numberOfVillains = 4;
                numberOfHenchman = 2;
                numberOfBystanders = 12;
                break;
            }
            default:
                System.out.println("Wrong number of players. Only available is 1 to 5 Players!");
                break;
        }
        Random random = new Random();
        schemeId = random.nextInt(8) + 1;
        switch (schemeId) {
            case 1:
                numberOfSchemeTwists = 8;
                schemeBackground = new Background(
                        new BackgroundImage(
                                new Image(
                                        "file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\schemes\\01.jpg",
                                        schemeWidth,
                                        schemeHeight,
                                        false,
                                        false
                                ),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                BackgroundSize.DEFAULT
                        )
                );
                break;
            case 2:
                numberOfSchemeTwists = 8;
                numberOfBystanders = 12;
                schemeBackground = new Background(
                        new BackgroundImage(
                                new Image(
                                        "file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\schemes\\02.jpg",
                                        schemeWidth,
                                        schemeHeight,
                                        false,
                                        false
                                ),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                BackgroundSize.DEFAULT
                        )
                );
                break;
            case 3:
                numberOfSchemeTwists = 8;
                numberOfHenchman += 1;
                schemeBackground = new Background(
                        new BackgroundImage(
                                new Image(
                                        "file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\schemes\\03.jpg",
                                        schemeWidth,
                                        schemeHeight,
                                        false,
                                        false
                                ),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                BackgroundSize.DEFAULT
                        )
                );
                break;
            case 4:
                numberOfSchemeTwists = 7;
                schemeBackground = new Background(
                        new BackgroundImage(
                                new Image(
                                        "file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\schemes\\04.jpg",
                                        schemeWidth,
                                        schemeHeight,
                                        false,
                                        false
                                ),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                BackgroundSize.DEFAULT
                        )
                );
                break;
            case 5:
                numberOfSchemeTwists = 5;
                numberOfBystanders = 18;
                schemeBackground = new Background(
                        new BackgroundImage(
                                new Image(
                                        "file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\schemes\\05.jpg",
                                        schemeWidth,
                                        schemeHeight,
                                        false,
                                        false
                                ),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                BackgroundSize.DEFAULT
                        )
                );
                break;
            case 6:
                numberOfSchemeTwists = 8;
                schemeBackground = new Background(
                        new BackgroundImage(
                                new Image(
                                        "file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\schemes\\06.jpg",
                                        schemeWidth,
                                        schemeHeight,
                                        false,
                                        false
                                ),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                BackgroundSize.DEFAULT
                        )
                );
                break;
            case 7:
                numberOfSchemeTwists = 8;
                numberOfHeroes += 1;
                isSkrullRequired = true;
                schemeBackground = new Background(
                        new BackgroundImage(
                                new Image(
                                        "file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\schemes\\07.jpg",
                                        schemeWidth,
                                        schemeHeight,
                                        false,
                                        false
                                ),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                BackgroundSize.DEFAULT
                        )
                );
                break;
            case 8:
                switch (numberOfPlayers) {
                    case 2:
                        numberOfHeroes = 4;
                        numberOfSchemeTwists = 8;
                        break;
                    case 3:
                        numberOfSchemeTwists = 8;
                        break;
                    case 4:
                    case 5:
                        numberOfSchemeTwists = 5;
                        break;
                }
                schemeBackground = new Background(
                        new BackgroundImage(
                                new Image(
                                        "file:" + System.getProperty("user.dir") + "\\src\\main\\resources\\images\\schemes\\08.jpg",
                                        schemeWidth,
                                        schemeHeight,
                                        false,
                                        false
                                ),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                BackgroundSize.DEFAULT
                        )
                );
                break;
            default:
                System.out.println("Out of bounds scheme.");
                break;
        }
        heroGroups = new HashSet<>();
        villainGroups = new HashSet<>();
        initHeroDeck();
        initMastermind();
        initVillainDeck();
    }

    private void initHeroDeck() {
        heroDeck = new ArrayList<>();
        List<String> deck = new ArrayList<>();
        try {
            List<Object> heroesO;
            heroesO = Files.list(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\json\\heroes\\")).collect(Collectors.toList());
            List<String> heroesS = new ArrayList<>();
            for (Object o : heroesO) {
                heroesS.add(o.toString().replace(System.getProperty("user.dir") + "\\src\\main\\resources\\json\\heroes\\", "").replace(".json", ""));
            }
            deck = getRandomHeroes(heroesS);
        } catch (IOException ex) {
            System.out.println("Path not found!");
        }
        for (String group : deck) {
            heroGroups.add(group);
            heroDeck.addAll(Init.cardInit("heroes\\" + group));
        }
    }

    private List<String> getRandomHeroes(List<String> allHeroes) {
        List<String> result = new ArrayList<>();
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(allHeroes.size());
            result.add(allHeroes.get(index));
            allHeroes.remove(index);
        } while (result.size() < numberOfHeroes);
        return result;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static void getRandomHero(Button b) {
        if (heroDeck.size() > 0) {
            Random random = new Random();
            int index = random.nextInt();
            index = (index < 0) ? (index * -1) % heroDeck.size() : index % heroDeck.size();
            Background background = heroDeck.get(index).getBackground();
            b.setVisible(false);
            new PopUpWindow(background);
            b.setBackground(background);
            b.setVisible(true);
            heroDeck.remove(index);
        } else {
            b.setVisible(false);
            new PopUpWindow("Hero Deck is empty!");
        }
    }

    private void initVillainDeck() {
        villainDeck = new ArrayList<>();
        List<String> deck = new ArrayList<>();
        try {
            List<Object> villainsO;
            villainsO = Files.list(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\json\\villains\\")).collect(Collectors.toList());
            List<String> villainsS = new ArrayList<>();
            for (Object o : villainsO) {
                villainsS.add(o.toString().replace(System.getProperty("user.dir") + "\\src\\main\\resources\\json\\villains\\", "").replace(".json", ""));
            }
            deck = getRandomVillains(villainsS);
        } catch (IOException ex) {
            System.out.println("Path not found!");
        }
        if (isMastermindLeadsVillain) {
            if (!deck.contains(mastermindLeadsVillains)) {
                deck.remove(0);
                deck.add(mastermindLeadsVillains);
            }
        }
        if (isSkrullRequired) {
            if (!deck.contains("skrulls")) {
                deck.remove((isMastermindLeadsVillain && deck.get(0).equals(mastermindLeadsVillains)) ? 1 : 0);
                deck.add("skrulls");
            }
        }
        for (String group : deck) {
            villainGroups.add(group);
            villainDeck.addAll(Init.cardInit("villains\\" + group));
        }
        addBystanders();
    }

    private void addBystanders() {
        GameCards bystanders = Init.singleCardInit("bystander");
        for (int i = 0; i < numberOfBystanders; i++) {
            villainDeck.add(bystanders);
        }
        addMasterStrikes();
    }

    private void addMasterStrikes() {
        GameCards masterStrike = Init.singleCardInit("master-strike");
        for (int i = 0; i < 5; i++) {
            villainDeck.add(masterStrike);
        }
        addSchemeTwists();
    }

    private void addSchemeTwists() {
        GameCards schemeTwist = Init.singleCardInit("scheme-twist");
        for (int i = 0; i < numberOfSchemeTwists; i++) {
            villainDeck.add(schemeTwist);
        }
        if (isSkrullRequired) {
            addHeroes();
        }
        addHenchman();
    }

    private void addHeroes() {
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(heroDeck.size());
            villainDeck.add(heroDeck.get(index));
            heroDeck.remove(index);
        }
    }

    private void addHenchman() {
        List<String> deck = new ArrayList<>();
        try {
            List<Object> henchmanO;
            henchmanO = Files.list(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\json\\henchman\\")).collect(Collectors.toList());
            List<String> henchmanS = new ArrayList<>();
            for (Object o : henchmanO) {
                henchmanS.add(o.toString().replace(System.getProperty("user.dir") + "\\src\\main\\resources\\json\\henchman\\", "").replace(".json", ""));
            }
            deck = getRandomHenchman(henchmanS);
        } catch (IOException ex) {
            System.out.println("Path not found!");
        }
        if (!isMastermindLeadsVillain) {
            if (!deck.contains(mastermindLeadsHenchman)) {
                deck.remove(0);
                deck.add(mastermindLeadsHenchman);
            }
        }
        for (String group : deck) {
            villainGroups.add(group);
            GameCards gameCard = Init.singleCardInit("henchman\\" + group);
            for (int i = 0; i < gameCard.getCount(); i++) {
                villainDeck.add(gameCard);
            }
        }
    }

    private List<String> getRandomHenchman(List<String> allHenchman) {
        List<String> result = new ArrayList<>();
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(allHenchman.size());
            result.add(allHenchman.get(index));
            allHenchman.remove(index);
        } while (result.size() < numberOfHenchman);
        return result;
    }

    private List<String> getRandomVillains(List<String> allVillains) {
        List<String> result = new ArrayList<>();
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(allVillains.size());
            result.add(allVillains.get(index));
            allVillains.remove(index);
        } while (result.size() < numberOfVillains);
        return result;
    }

    private void initMastermind() {
        mastermindDeck = new ArrayList<>();
        String deck = null;
        try {
            List<Object> mastermindsO;
            mastermindsO = Files.list(Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\json\\masterminds\\")).collect(Collectors.toList());
            List<String> mastermindsS = new ArrayList<>();
            for (Object o : mastermindsO) {
                mastermindsS.add(o.toString().replace(System.getProperty("user.dir") + "\\src\\main\\resources\\json\\masterminds\\", "").replace(".json", ""));
            }
            deck = getRandomMastermind(mastermindsS);
        } catch (IOException ex) {
            System.out.println("Path not found!");
        }
        mastermindDeck.addAll(Init.cardInit("masterminds\\" + deck));
    }

    private String getRandomMastermind(List<String> allMasterminds) {
        String result;
        Random random = new Random();
        int index;
        index = random.nextInt(allMasterminds.size());
        result = allMasterminds.get(index);
        switch (result) {
            case "loki": {
                mastermindLeadsVillains = "enemies-of-asgard";
                isMastermindLeadsVillain = true;
                break;
            }
            case "dr-doom": {
                mastermindLeadsHenchman = "doombot-legion";
                isMastermindLeadsVillain = false;
                break;
            }
            case "red-skull": {
                mastermindLeadsVillains = "hydra";
                isMastermindLeadsVillain = true;
                break;
            }
            case "magneto": {
                mastermindLeadsVillains = "brotherhood";
                isMastermindLeadsVillain = true;
                break;
            }
        }
        return result;
    }

    public static void getRandomVillain(List<Button> buttons) {
        if (villainDeck.size() > 0) {
            Random random = new Random();
            int index = random.nextInt();
            index = (index < 0) ? (index * -1) % villainDeck.size() : index % villainDeck.size();
            GameCards gameCard = villainDeck.get(index);
            if (gameCard.getGroup().equals("Master Strike")) {
                new PopUpWindow(gameCard.getBackground());
            } else if (gameCard.getGroup().equals("Scheme Twist")) {
                new PopUpWindow(gameCard.getBackground());
            } else if (gameCard.getGroup().equals("Bystander") && (schemeId != 5)) {
                new PopUpWindow(gameCard.getBackground());
            } else {
                if (buttons.get(4).isVisible()) {
                    if (buttons.get(3).isVisible()) {
                        if (buttons.get(2).isVisible()) {
                            if (buttons.get(1).isVisible()) {
                                buttons.get(0).setBackground(buttons.get(1).getBackground());
                                buttons.get(0).setVisible(true);
                            }
                            buttons.get(1).setBackground(buttons.get(2).getBackground());
                            buttons.get(1).setVisible(true);
                        }
                        buttons.get(2).setBackground(buttons.get(3).getBackground());
                        buttons.get(2).setVisible(true);
                    }
                    buttons.get(3).setBackground(buttons.get(4).getBackground());
                    buttons.get(3).setVisible(true);
                }
                Background background = gameCard.getBackground();
                buttons.get(4).setVisible(false);
                new PopUpWindow(background);
                buttons.get(4).setBackground(background);
                buttons.get(4).setVisible(true);
            }
            villainDeck.remove(index);
        } else {
            new PopUpWindow("Villain Deck is empty!");
        }
    }

    public static void getMastermind(Button button) {
        Background background = new Background(
                new BackgroundImage(
                        new Image(
                                mastermindDeck.get(0).getBackground().getImages().get(0).getImage().getUrl(),
                                schemeWidth,
                                schemeHeight,
                                false,
                                false
                        ),
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT
                )
        );
        new PopUpWindow(background);
        button.setBackground(background);
        button.setVisible(true);
    }

    public static void getScheme(Label label) {
        new PopUpWindow(schemeBackground);
        label.setBackground(schemeBackground);
        label.setVisible(true);
    }

    public static void cardsUsed() {
        new PopUpWindow("Heroes being used:\n", heroGroups);
        new PopUpWindow("Enemies being used:\n", villainGroups);
    }

    public static void getRandomTactic() {
        if ((mastermindDeck.size() - 1) > 0) {
            Random random = new Random();
            int index = random.nextInt(mastermindDeck.size() - 1) + 1;
            new PopUpWindow(mastermindDeck.get(index).getBackground());
            mastermindDeck.remove(index);
            if(mastermindDeck.size() == 1) {
                new PopUpWindow("Mastermind has been defeated.");
            }
        } else {
            new PopUpWindow("Mastermind has been defeated.");
        }
    }

    public static String getVillainDeckSize() {
        return (villainDeck.size() > 2) ? villainDeck.size() - 1 + " cards left." : (villainDeck.size() == 2) ? "1 card left." : "No cards left.";
    }

    public static String getHeroDeckSize() {
        return (heroDeck.size() > 2) ? heroDeck.size() - 1 + " cards left." : (heroDeck.size() == 2) ? "1 card left." : "No cards left.";
    }

    public static String getInitVillainDeckSize() {
        return villainDeck.size() + " cards left.";
    }

    public static String getInitHeroDeckSize() {
        return heroDeck.size() + " cards left.";
    }
}
