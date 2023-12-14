import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive long integer: ");
        
        long number = input.nextLong();

        System.out.println("(Iterative) The sum of digits in " + number + " is " + sumDigitsIterative(number));

        System.out.println("(Recursive) The sum of digits in " + number + " is " + sumDigitsRecursive(number));
    }

    public static int sumDigitsIterative(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int sumDigitsRecursive(long n) {
        // base case to stop recursion
        if (n == 0) {
            return 0;
        }
        // recursive case to continue recursion
        else {
            return (int) n % 10 + sumDigitsRecursive(n / 10);
        }
    }
}