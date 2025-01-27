import java.util.Scanner;
public class p2w2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Squares and Cubes from 1 to 5: ");        
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i + " Square: " + (i * i) + " Cube: " + (i * i * i));
        }
    }
}