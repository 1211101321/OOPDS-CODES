import java.util.Scanner;

public class phonekeypads {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter phone number: ");
        String phoneStr = input.next();

        // now we have to check every character in our phone
        for (int i = 0; i < phoneStr.length(); i++) {

            char ch = phoneStr.charAt(i);

            if (Character.isLetter(ch)) {
                System.out.print(getNumber(ch) + " ");
            } else {
                System.out.print(ch + " ");

            }
        }

    }

    public static int getNumber(char letter) {
        switch (Character.toLowerCase(letter)) {
            case 'a', 'b', 'c':
                return 2;
            case 'd', 'e', 'f':
                return 3;
            case 'g', 'h', 'i':
                return 4;
            case 'j', 'k', 'l':
                return 5;
            case 'm', 'n', 'o':
                return 6;
            case 'p', 'q', 'r', 's':
                return 7;
            case 't', 'u', 'v':
                return 8;
            case 'w', 'x', 'y':
                return 9;
            default:
                return -1; // donate error
        }

    }
}