import java.util.Scanner;

class Commission {
    private double sale;

    public Commission(double sale) {
        this.sale = sale;
    }

    public double calculateCommission() {
        if (sale < 500) {
            return 0.02 * sale;
        } else if (sale < 5000) {
            return 0.05 * sale;
        } else {
            return 0.08 * sale;
        }
    }
}

class CommissionDemo {
    public void CommissionMethod() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sales amount: ");
        double sale = scanner.nextDouble();

        if (sale < 0) {
            System.out.println("Invalid Input");
        } else {
            Commission commission = new Commission(sale);
            System.out.println("Commission: Rs. " + commission.calculateCommission());
        }

    }
}

public class Main {
    public static void main(String[] args) {
        CommissionDemo demo = new CommissionDemo();
        demo.CommissionMethod();
    }
}
