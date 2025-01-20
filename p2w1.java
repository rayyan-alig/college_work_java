import java.util.Scanner;
class p2w1{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		System.out.println("enter first number");
		int a = sc.nextInt();
		System.out.println("enter second number");
		int b = sc.nextInt();

		int sum = a+b;
		System.out.println("sum of two numbers : "+ sum);

		int product = a*b;
		System.out.println("product of two numbers : "+ product);

		int quotient = a/b;
		System.out.println("quotient of two numbers : "+ quotient);

		if(a>b){
			System.out.println("a is greater than b");
		}
		if(a==b){
			System.out.println("a and b are equal");
		}
		else{
			System.out.println("b is greater than a");
		}

		

	}
}