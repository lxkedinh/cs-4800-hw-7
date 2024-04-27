package flyweight;

public class Character {
    private char characterValue;
    private CharacterProperties properties;

    public Character(char characterValue, String propertiesString) {
        this.characterValue = characterValue;
        properties = CharacterPropertiesFactory.getInstance().getCharacterProperties(propertiesString);
    }

    public char getCharacterValue() {
        return characterValue;
    }

    public void setCharacterValue(char characterValue) {
        this.characterValue = characterValue;
    }

    public CharacterProperties getProperties() {
        return properties;
    }

    public void setProperties(String propertiesString) {
        this.properties = CharacterPropertiesFactory.getInstance().getCharacterProperties(propertiesString);
    }

    @Override
    public String toString() {
        return String.format("\"%s\"\t\t%s", characterValue, properties);
    }
}
