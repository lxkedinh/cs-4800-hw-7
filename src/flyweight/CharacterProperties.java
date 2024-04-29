package flyweight;

public class CharacterProperties {
    private final String font;
    private final String color;
    private final int size;

    public CharacterProperties(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    /**
     * @return serialized string that represents this combination of character properties as "font-color-size".
     */
    public String serialize() {
        return String.format("%s-%s-%d", font, color, size);
    }

    @Override
    public String toString() {
        String capitalizedFont = font.substring(0,1).toUpperCase() + font.substring(1).toLowerCase();
        String capitalizedColor = color.substring(0,1).toUpperCase() + color.substring(1).toLowerCase();

        return String.format("Font: %-10sColor: %-10s Size: %-4d", capitalizedFont, capitalizedColor, size);
    }
}
