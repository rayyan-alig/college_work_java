import java.util.Scanner;

public class p3w4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter text:");
        String text = scanner.nextLine();
        
        int wordCount = countWords(text);
        int sentenceCount = countSentences(text);
        int eCount = countOccurrences(text, 'e');
        int zCount = countOccurrences(text, 'z');
        
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of sentences: " + sentenceCount);
        System.out.println("Occurrences of 'e': " + eCount);
        System.out.println("Occurrences of 'z': " + zCount);
        
    }

    public static int countWords(String text) {
        int count = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    public static int countSentences(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '.' || ch == '!' || ch == '?') {
                count++;
            }
        }
        return count;
    }

    public static int countOccurrences(String text, char letter) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }
}
