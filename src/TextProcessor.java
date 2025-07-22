public class TextProcessor {


    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return 0;
        return sentence.trim().split("\\s+").length;
    }


    public static String replaceWord(String text, String oldWord, String newWord) {
        return text.replace(oldWord, newWord);
    }

    public static void main(String[] args) {
        String text = "Java is fun and Java is powerful";

        int wordCount = countWords(text);
        System.out.println("Word count: " + wordCount);

        String replaced = replaceWord(text, "Java", "Programming");
        System.out.println("Updated text: " + replaced);
    }
}
