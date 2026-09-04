package string.assignments;

import java.util.*;

public class InventoryParser{

    static void printFilteredWordFrequency(String feedback) {

        // Stop words
        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        // Convert to lowercase
        String text = feedback.toLowerCase();

        // Remove punctuation
        text = text.replace(".", "");
        text = text.replace(",", "");

        // Split into words
        String[] words = text.split("\\s+");

        // HashMap for frequency
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            // Check if word is a stop word
            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }

            // Skip stop words
            if (isStopWord) {
                continue;
            }

            // Count frequency
            if (frequency.containsKey(word)) {
                frequency.put(word, frequency.get(word) + 1);
            } else {
                frequency.put(word, 1);
            }
        }

        // Convert map entries to a list
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        // Sort by count in descending order
        Collections.sort(list, (a, b) ->
                b.getValue().compareTo(a.getValue()));

        // Print result
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}