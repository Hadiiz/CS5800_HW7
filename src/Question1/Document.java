package Question1;

import Question1.Character;
import Question1.CharacterFactory;
import Question1.CharacterProperties;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<Character> characters = new ArrayList<>();

    public void addCharacter(char c, String font, String color, int size) {
        CharacterProperties properties = CharacterFactory.getProperties(font, color, size);
        characters.add(new Character(c, properties));
    }

    // Edit a character at a specific index
    public void editCharacter(int index, char newChar, String font, String color, int size) {
        if (index >= 0 && index < characters.size()) {
            CharacterProperties properties = CharacterFactory.getProperties(font, color, size);
            characters.set(index, new Character(newChar, properties));
        }
    }

    // Display content
    public String getContent() {
        StringBuilder content = new StringBuilder();
        for (Character character : characters) {
            content.append(character.getCharacter());
        }
        return content.toString();
    }

    public void save(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Character character : characters) {
            writer.write(character.getCharacter() + " " + character.getProperties().getFont() + " " +
                    character.getProperties().getColor() + " " + character.getProperties().getSize() + "\n");
        }
        writer.close();
    }

    public void load(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            char charPart = parts[0].charAt(0);
            String font = parts[1];
            String color = parts[2];
            int size = Integer.parseInt(parts[3]);
            addCharacter(charPart, font, color, size);
        }
        reader.close();
    }
}
