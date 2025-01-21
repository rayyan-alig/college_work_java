import java.util.Scanner;

public class p4w1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a double value for num: ");
        double num = scanner.nextDouble();

        double numRound = Math.round(num); 
        double numCeil = Math.ceil(num);   
        double numFloor = Math.floor(num); 
        int numInteger = (int) num;        

        System.out.println("Rounded value (numRound): " + numRound);
        System.out.println("Ceil value (numCeil): " + numCeil);
        System.out.println("Floor value (numFloor): " + numFloor);
        System.out.println("Integer value (numInteger): " + numInteger);

        scanner.close();
    }
}
