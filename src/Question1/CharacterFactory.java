package Question1;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private static final Map<String, CharacterProperties> propertiesMap = new HashMap<>();

    public static CharacterProperties getProperties(String font, String color, int size) {
        String key = font + color + size;
        if (!propertiesMap.containsKey(key)) {
            propertiesMap.put(key, new CharacterProperties(font, color, size));
        }
        return propertiesMap.get(key);
    }
}
