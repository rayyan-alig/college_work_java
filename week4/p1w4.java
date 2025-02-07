import java.util.Scanner;

class OddAndEven {
    private int countOfOdd = 0;
    private int countOfEven = 0;

    public void addNumber(int number) {
        if (number % 2 == 0) {
            countOfEven++;
        } else {
            countOfOdd++;
        }
    }

    public String toString() {
        return "Number of Odd: " + countOfOdd + ", Number of Even: " + countOfEven;
    }
}

class TestOddAndEven {
    public void testMethod() {
        Scanner scanner = new Scanner(System.in);
        OddAndEven counter = new OddAndEven();
        
        System.out.println("Enter numbers (Q to quit):");
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("Q") || input.equals("q")) {
                break;
            }
            int number = Integer.parseInt(input);
            counter.addNumber(number);
        }
        
        System.out.println(counter);
    }
}

public class p1w4 {
    public static void main(String[] args) {
        TestOddAndEven testobj = new TestOddAndEven();
        testobj.testMethod();
    }
}
