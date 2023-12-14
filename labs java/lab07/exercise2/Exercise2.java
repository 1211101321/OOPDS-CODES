import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Exercise2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        List<Integer> list = createRandomList();
        Random r = new Random();
        int command;

        do{
            System.out.println ("Random list: " + list);
            System.out.println("Enter your choice:");
            System.out.println("1: New random list");
            System.out.println("2: Sort list");
            System.out.println("3: Reverse list");
            System.out.println("4: Shuffle list");
            System.out.println("5: Max");
            System.out.println("6: Min");
            System.out.println("0: Quit");
            System.out.print(">");
            command = input.nextInt();

            switch(command){
                case 1: list = createRandomList();
                        break;
                case 2: Collections.sort(list);
                        break;
                case 3: Collections.reverse(list);
                        break;
                case 4: Collections.shuffle(list);
                        break;
                case 5: System.out.println(Collections.max(list));
                        break;
                case 6: System.out.println(Collections.min(list));
                        break;
            }
        }while(command != 0);   
    }

    public static List<Integer> createRandomList(){
        Random r = new Random();
        List<Integer> list = new LinkedList<>();
        //generate 10 random integers
        for(int i = 0; i < 10; i++){
            list.add(r.nextInt(100)); // 0 - 99
        }
        return list;
    }
}