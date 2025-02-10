import java.util.*;

public class GiftsOfAutumn {
    public static void main(String[] args) {
        // Массив с набором слов
        String[] words = {"potatoes", "radish", "eggplant", "potatoes", "carrots", "garlic", "carrots",
                "potatoes", "radish", "garlic", "squash", "eggplant", "potatoes", "radish", "eggplant", "eggplant"};

        // Находим уникальные слова
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Уникальные слова: " + uniqueWords);

        // Подсчитываем, сколько раз встречается каждое слово
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("Количество повторений каждого слова: " + wordCount);
    }
}