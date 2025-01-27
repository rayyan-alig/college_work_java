import java.util.Scanner;
public class p5w2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();
        int num = 1;
        System.out.println("Floyd's Triangle (Pattern 1):");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
        System.out.println("Floyd's Triangle (Pattern 2):");
        for (int row = 1; row <=n; row++) {
            for (int col = 1; col <= row; col++) {
                if(row%2 == 1 && col%2 == 1){
			System.out.print("1 ");
		} 
		if(row%2 == 0 && col%2 == 1){
			System.out.print("0 ");
		}    
		if(row%2 == 1 && col%2 == 0){
			System.out.print("0 ");
		}
		if(row%2 == 0 && col%2 == 0){
			System.out.print("1 ");
		}        
	    }
            System.out.println();
        }
    }
}
