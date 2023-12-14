import java.util.Scanner;
import java.util.Arrays;

public class lab01exercise2 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter array 1: ");
        int arraySlot = input.nextInt();
        double[] arrayObjects = new double[arraySlot];
        //double arrayofNumbers[] = new double[arraySlot];
        
        for (int i = 0; i < arraySlot; i=i+1){
            arrayObjects[i]= input.nextDouble();
        }

        System.out.print("Array 1: [");
        for (int i = 0; i < arraySlot; i=i+1){
            System.out.print(arrayObjects[i]);
            if (i<arraySlot -1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}