import java.util.Scanner;

public class Goldbach {
    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an even number greater than 2: ");
        int num = sc.nextInt();

        if (num <= 2 || num % 2 != 0) {
            System.out.println("Enter an even number greater than 2.");
        } else {
            boolean found = false;
            for (int i = 2; i <= num / 2; i++) {
                if (isPrime(i) && isPrime(num - i)) {
                    System.out.println(num + " = " + i + " + " + (num - i));
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No Goldbach partition found (unexpected for even numbers > 2).");
            }
        }
        sc.close();
    }
}
