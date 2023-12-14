import java.util.Arrays;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strArray = new String[5];
        System.out.println("Enter 5 strings:");

        for (int i = 0; i < 5; i++) {
            strArray[i] = input.next();
        }

        if (isAscending(strArray)) {
            System.out.println(Arrays.toString(strArray) + " is in ascending order");
        } else {
            System.out.println(Arrays.toString(strArray) + " is not in ascending order");
        }
    }

    public static <E extends Comparable<? super E>> boolean isAscending(E[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false; // Return false if not in ascending order
            }
        }
        return true; // Return true if all elements are in ascending order
    }
}