package game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import display.GameCards;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Init {
    static List<GameCards> cardInit(String group) {
        List<GameCards> deck = new ArrayList<>();
        List<GameCards> fromJson = getListFromJson(group);
        for (GameCards gameCard : fromJson) {
            int index = 0;
            gameCard.cardInit();
            while (index < gameCard.getCount()) {
                deck.add(gameCard);
                index++;
            }
        }
        return deck;
    }

    private static List<GameCards> getListFromJson(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\json\\" + fileName + ".json"), new TypeReference<>() {});
        } catch (IOException ex) {
            System.out.println("Unable to read file " + fileName + ".");
            return new ArrayList<>();
        }
    }

    static GameCards singleCardInit(String group) {
        GameCards gameCard = getFromJson(group);
        gameCard.cardInit();
        return gameCard;
    }

    private static GameCards getFromJson(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\json\\" + fileName + ".json"), GameCards.class);
        } catch (IOException ex) {
            System.out.println("Unable to read file " + fileName + ".");
            return new GameCards();
        }
    }
}
