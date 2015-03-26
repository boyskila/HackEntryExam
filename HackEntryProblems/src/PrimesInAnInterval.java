import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimesInAnInterval {

    public static boolean validateInput(int from, int to) {

        if (from < to && from > 0 && to > 0 && from > 0 && to > 0)

            return true;
        return false;

    }

    public static List<Integer> getPrimesBetween(int from, int to) {

        List<Integer> primes = new ArrayList<Integer>();

        if (!validateInput(from, to)) {
            System.out.println("Invalid input ");
        }

        for (int i = from; i <= to; i++) {

            for (int a = 2; a <= i; a++) {
                if (a == i) {
                    primes.add(i);
                }
                if (i % a == 0) {

                    break;
                }

            }

        }

        return primes;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a : ");

        int a = sc.nextInt();

        System.out.println("Enter b : ");

        int b = sc.nextInt();

        for (Integer prime : getPrimesBetween(a, b)) {
            System.out.println(prime);
        }
        sc.close();
    }

}