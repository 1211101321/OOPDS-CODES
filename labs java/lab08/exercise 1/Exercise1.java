import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // scanner for user input
        System.out.println("Sample run: ");
        System.out.println("Enter integers: ");
        String numbers = input.nextLine();

        Set<Integer> treeSet = new TreeSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>(treeSet);
        
        // scanner for numbers
        Scanner scan = new Scanner(numbers);
        while (scan.hasNextInt()) {
            int number = scan.nextInt();
            treeSet.add(number);
            linkedHashSet.add(number);
        }

        System.out.println("Nonduplicate numbers in ascending order: " + treeSet);

        /// Set<Integer> linkedHashSet = new LinkedHashSet<>(treeSet);

        System.out.println("Nonduplicate numbers in insertion order: " + linkedHashSet);

    }
}