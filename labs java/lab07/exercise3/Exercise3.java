import java.util.Scanner;
import java.util.Stack;

public class Exercise3{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Stack<Integer>[] towers = new Stack[3]; // 3 nulls, no objects yet
        int sourceTower;
        int destTower;
        
        // construct 3 Stack objects
        for (int i = 0; i < towers.length; i++){
            towers[i] = new Stack<>();
        }

        // add 3 disks to tower 0
        for(int i = 3; i >= 1; i--){
            towers[0].push(i);
        }

        do{
            System.out.println("Tower 0: " + towers[0]);
            System.out.println("Tower 1: " + towers[1]);
            System.out.println("Tower 2: " + towers[2]);
            System.out.print("Enter source tower and destination tower: ");
            sourceTower = input.nextInt();

            if (sourceTower < 0){
                break;
            }
            destTower = input.nextInt();
            if(destTower < 0){
                break;
            }

            //move top disk
            int topDisk = towers[sourceTower].pop();
            towers[destTower].push(topDisk);

            // towers[destTower].push(towers[sourceTower].pop()); <-- shortcut for move top disk
        }while (true);
    }
}