import java.util.Scanner; // Scanner is in the java.util package
import java.util.Arrays;

public class exercise1lab00 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter total number of items: ");
        int size = input.nextInt();

        double[] prices = new double[size];
        System.out.print("Enter the prices for " + size + " items: ");
        for (int i = 0; i < prices.length; i = i + 1) {
            prices[i] = input.nextDouble();
        }
        System.out.println(Arrays.toString(prices));
        for (int i = 0; i < prices.length; i = i + 1) {
            System.out.print(prices[i] + " ");
        }
        System.out.println();

        double sum = 0;
        for (int i = 0; i < prices.length; i = i + 1) {
            sum = sum + prices[i];
        }
        System.out.print("Sum of all items: "+ sum);

    }
}