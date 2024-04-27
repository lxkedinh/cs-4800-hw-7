package flyweight;

import java.util.HashMap;

public class CharacterPropertiesFactory {
    private final HashMap<String, CharacterProperties> combinations = new HashMap<>();
    private static CharacterPropertiesFactory factory = null;

    private CharacterPropertiesFactory() {}

    public static CharacterPropertiesFactory getInstance() {
        if (factory == null) {
            factory = new CharacterPropertiesFactory();
        }

        return factory;
    }

    /**
     *
     * @param propertiesString - string in the form of "font-color-size" that represents a combination of properties
     * @return CharacterProperties instance of the combination of properties specified in propertiesString
     */
    public CharacterProperties getCharacterProperties(String propertiesString) {
        String formattedPropertiesString = propertiesString.toLowerCase();

        if (combinations.containsKey(formattedPropertiesString)) {
            return combinations.get(formattedPropertiesString);
        }

        String[] parsedProperties = propertiesString.split("-");
        String font = parsedProperties[0];
        String color = parsedProperties[1];
        int size = Integer.parseInt(parsedProperties[2]);

        CharacterProperties newCombination = new CharacterProperties(font, color, size);
        combinations.put(formattedPropertiesString, newCombination);

        return newCombination;
    }

}
