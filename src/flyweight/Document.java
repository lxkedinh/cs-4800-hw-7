package flyweight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<Character> content = new ArrayList<>();

    public Document() {}

    public Document(String fileName) {
        try {
            readFromFile(fileName);
        } catch (Exception e) {
            System.out.println("Could not create a new document.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     *
     * @param character - character to write to document
     * @param propertiesString - string in format "font-color-size" for character properties you want to use
     */
    public void write(char character, String propertiesString) {
        content.add(new Character(character, propertiesString));
    }

    public void undo() {
        content.remove(content.size() - 1);
    }

    private void readFromFile(String fileName) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();
        while (line != null) {
            String[] parsedLine = line.split(" ");
            char character = parsedLine[0].charAt(0);
            String propertiesString = parsedLine[1];
            content.add(new Character(character, propertiesString));
            line = reader.readLine();
        }

        reader.close();
    }

    public void saveToFile(String fileName) throws FileNotFoundException, IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (Character c : content) {
            String lineToWrite = String.format("%c %s\n", c.getCharacterValue(), c.getProperties().serialize());
            writer.write(lineToWrite);
        }

        writer.close();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Character c : content) {
            s.append(c);
            s.append('\n');
        }

        return s.toString();
    }
}
