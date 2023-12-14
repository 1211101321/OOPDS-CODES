import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a sentence or word or whatever lol:  ");
        String sentence = input.nextLine();

        Map<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        Map<Character, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < sentence.length(); i++) {
            System.out.println(i + " ");

            char ch = Character.toLowerCase(sentence.charAt(i));

            // DOES IT EXIST IN MAP????????

            if (linkedHashMap.get(ch) == null) {
                // does not exist
                linkedHashMap.put(ch, 1);
                treeMap.put(ch, 1);
            } else {
                // ch exist in map
                int count = linkedHashMap.get(ch); // obtain existing count
                linkedHashMap.put(ch, count + 1);
                treeMap.put(ch, count + 1);
            }

        }

        System.out.println("Character occurrence in original order");
        System.out.println(linkedHashMap);

        for (var entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }

        /// for(int i = 0; i<linkedHashMap; i++)

        Map<Character, Integer> treeMap2 = new TreeMap<>(linkedHashMap);
        System.out.println("Character occurrence in ascending order");
        System.out.println(treeMap);

        treeMap2.forEach((k, v) -> System.out.println(k + "\t" + v));

        /*
         * for (var entry : treeMap.entrySet()) {
         * System.out.println(entry.getKey() + "\t" + entry.getValue());
         * }
         */

        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
        /// System.out.println("Enter a sentence; ");
    }

}