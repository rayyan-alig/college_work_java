import java.util.Scanner;

class Circle {
    private double radius;
    private double centerX;
    private double centerY;

    public Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public double computeArea() {
        return Math.PI * radius * radius;
    }

    public double computePerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean isInside(double x, double y) {
        double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        return distance <= radius;
    }
}

public class p2w4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter radius of the circle (negative value to quit):");
            double radius = scanner.nextDouble();
            if (radius < 0) {
                break;
            }
            
            System.out.println("Enter x-coordinate of the center:");
            double centerX = scanner.nextDouble();
            
            System.out.println("Enter y-coordinate of the center:");
            double centerY = scanner.nextDouble();
            
            Circle circle = new Circle(radius, centerX, centerY);
            
            System.out.println("Circle Area: " + circle.computeArea());
            System.out.println("Circle Perimeter: " + circle.computePerimeter());
            
            System.out.println("Enter a point's x-coordinate:");
            double pointX = scanner.nextDouble();
            
            System.out.println("Enter a point's y-coordinate:");
            double pointY = scanner.nextDouble();
            
            if (circle.isInside(pointX, pointY)) {
                System.out.println("The point is inside the circle.");
            } else {
                System.out.println("The point is outside the circle.");
            }
        }
        
    }
}
