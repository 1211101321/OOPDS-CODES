import java.util.ArrayList;
import java.util.Scanner;

public class exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();

        System.out.print("Enter words (0 to finish): ");
        String word; // refrence type cant use "=="
        do {
            word = input.next();
            if (word.equals("0")) {
                break;
            }
            words.add(word);
        } while (true);

        System.out.println("The distinct words: " + words);
    }

    public static void removeDuplicate(ArrayList<String> list) {
        ArrayList<String> temp = new ArrayList<>();
        // iterate every element in listt
        for (int i = 0; i < list.size(); i++) {
            // copy distinct elements to temp
            if (!temp.contains(list.get(i))) {
                temp.add(list.get(i));
            }
        }
        list.clear();// removes all elements in list

        // copy all elements from temp to list
        for (String element : temp) {
            list.add(element);
        }

    }
}
