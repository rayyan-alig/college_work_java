public class p5w1 {
    public static void main(String[] args) {
        double num1 = -12.56;
        double num2 = 3.14;
        double num3 = 4.0;
        double num4 = 9.0;

        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        System.out.println("num3: " + num3);
        System.out.println("num4: " + num4);
        
        
        System.out.println("Math.abs(num1): " + Math.abs(num1));
        System.out.println("Math.ceil(num1): " + Math.ceil(num1));
        System.out.println("Math.floor(num1): " + Math.floor(num1));
        System.out.println("Math.round(num2): " + Math.round(num2));
        
        System.out.println("Math.max(num2, num3): " + Math.max(num2, num3));
        System.out.println("Math.min(num2, num3): " + Math.min(num2, num3));

        System.out.println("Math.sqrt(num4): " + Math.sqrt(num4));
        System.out.println("Math.pow(num3, 2): " + Math.pow(num3, 2));

        System.out.println("Math.exp(1): " + Math.exp(num1));
        System.out.println("Math.log(10): " + Math.log(10)); 
        System.out.println("Math.log10(1000): " + Math.log10(1000)); 

        System.out.println("Math.sin(Math.PI / 2): " + Math.sin(Math.PI / 2)); 
        System.out.println("Math.cos(Math.PI): " + Math.cos(Math.PI)); 
        System.out.println("Math.tan(Math.PI / 4): " + Math.tan(Math.PI / 4)); 

        System.out.println("Math.random(): " + Math.random());

    }
}
