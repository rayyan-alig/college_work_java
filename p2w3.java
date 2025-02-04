import java.util.*;

class p2w3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter something: ");
        String input = scanner.nextLine();

        List<String> result = new ArrayList<>();
        Solve("", input, result);

        for (String val : result) {
            System.out.print(val + " ");
        }
    }

    static void Solve(String op, String ip, List<String> result) {
        if (ip.length() == 0) {
            result.add(op);
            return;
        }
        for (int i = 0; i < ip.length(); i++) {
            String newip = ip.substring(0, i) + ip.substring(i + 1);
            String newop = op + ip.charAt(i);
            Solve(newop, newip, result);
        }
    }
}
