import java.util.Scanner;
import java.util.ArrayList;

public class exercise2lab00 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        String word;
        boolean zero_entered = false;
        do { //do while loop that will break when 0 is entered 
             //the boolean value will change to TRUE and loop stops
            System.out.print("Enter a word (0 to end): ");
            word = input.next();
            if (word.equals("0")) { 
                zero_entered = true;
            } else {
                words.add(word);        // in c++ we used pushback for filling an array with objects JAVA is different
            }

        } while (!zero_entered);

        System.out.println(words);
        System.out.print("You entered: ");
        for (int i = 0; i < words.size(); i = i + 1) {
            System.out.print(words.get(i) + " "); //the .get allows us to retrieve a specific object from the list 
        }
        System.out.println();

        boolean ascending = true;
        boolean duplicate = false;
        for (int i = 0; i < words.size() - 1; i = i + 1) {
            ascending = false;
            for (int j = i + 1; j < words.size(); j = j + 1) {
                if (words.get(i).equals(words.get(j))) {
                    duplicate = true;
                }
            }
        }
        System.out.println("Ascending: " + ascending);
        System.out.println("Duplicate: " + duplicate);

    }
}
