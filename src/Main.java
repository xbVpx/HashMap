import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
            " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo " +
            "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum " +
            "dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
            "sunt in culpa qui officia deserunt mollit anim id est laborum.";


    public static void main(String[] args) {


        Map<Character, Integer> collectCharacters = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            String smallCharacter = text.toLowerCase();
            char symbol = smallCharacter.charAt(i);

            if (Character.isLetter(symbol) && collectCharacters.get(symbol) == null) {
                collectCharacters.put(symbol, 1);

            } else if (Character.isLetter(symbol) && collectCharacters.containsKey(symbol)) {
                collectCharacters.put(symbol, collectCharacters.remove(symbol) + 1);
            }
        }
        System.out.println(collectCharacters);

        Map.Entry<Character, Integer> maxEntry = null;
        for (Map.Entry<Character, Integer> entry : collectCharacters.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        System.out.println("Больше всего символов: " + maxEntry);

        Map.Entry<Character, Integer> minEntry = null;
        for (Map.Entry<Character, Integer> entry : collectCharacters.entrySet()) {
            if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0) {
                minEntry = entry;
            }
        }
        System.out.println("Меньше всего символов: " + minEntry);
    }

}