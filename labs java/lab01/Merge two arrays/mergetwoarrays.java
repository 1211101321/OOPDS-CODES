import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class mergetwoarrays {
    public static void main(String[] args){
        System.out.print ("Enter array1: ");
        double[] array1 = createArrayFromInput();
        System.out.println (Arrays.toString(array1));

        System.out.print ("Enter array2: ");
        double[] array2 = createArrayFromInput();
        System.out.println (Arrays.toString(array2));

        double[] array3 = merge(array1, array2);
        System.out.print ("array3: ");
        print(array3);

    }

    public static double[] merge (double[] array1, double[] array2){
        int size = array1.length + array2.length;
        double[] array3 = new double[size];

        //copy array1 to array3
        for (int i = 0; i < array1.length; i++){
            array3[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            array3[array1.length + i] = array2[i];
        }

        return array3;
    }

    public static void print (double[] array){
        System.out.println (Arrays.toString(array));
    }

    public static double[] createArrayFromInput(){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        double[] array = new double[size];
        for (int i = 0; i < array.length; i++){
            array[i] = input.nextInt();
        }
        return array;
    }
    
}