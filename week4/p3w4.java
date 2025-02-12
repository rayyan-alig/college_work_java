import java.util.*;

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
        StringTokenizer s = new StringTokenizer(text);
        return s.countTokens();
    }

    public static int countSentences(String text) {
        StringTokenizer s = new StringTokenizer(text, ".!?");
        return s.countTokens();
    }

    public static int countOccurrences(String text, char letter) {
        int count = 0;
        StringTokenizer s = new StringTokenizer(text, " ");
        while(s.hasMoreTokens()){
            String token = s.nextToken();
            for(char c : token.toCharArray()){
                if(c == letter){
                    count++;
                }
            }
        }
        return count;
    }
}
