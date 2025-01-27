import java.util.Scanner;
public class p4w2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 2; i <= N; i = i+2) {
            sum = sum + i;
        }
        System.out.println("Sum of even terms: " + sum);
    }
}