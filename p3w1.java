import java.util.Scanner;

class p3w1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();

        double celsius = (fahrenheit - 32) / 1.8;

        System.out.println("The temperature in Celsius is: " + celsius);

        scanner.close();
    }
}
