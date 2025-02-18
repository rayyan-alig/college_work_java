interface ShapeInterface {
    double calculateArea();
    double calculatePerimeter();
    String getName(); 
}

abstract class Shape implements ShapeInterface {
    private String name;
    
    public Shape(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

public class p4w6 {
    public static void main(String[] args) {
        ShapeInterface circle = new Circle(5); 
        ShapeInterface rectangle = new Rectangle(4, 6);

        System.out.println(circle.getName() + " - Area: " + circle.calculateArea() + ", Perimeter: " + circle.calculatePerimeter());
        System.out.println(rectangle.getName() + " - Area: " + rectangle.calculateArea() + ", Perimeter: " + rectangle.calculatePerimeter());
    }
}
