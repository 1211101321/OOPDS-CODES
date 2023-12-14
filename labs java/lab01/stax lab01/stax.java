import java.util.Scanner;


public class stax{
    //this is a function that will accept your inputs
    public static double[] createArrayFromInput(){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//takes the n first digit

        double[] arr = new double[n];//creating array of double

        for(int i = 0; i < n; i++){
            arr[i] = input.nextDouble(); //inputting the objects into the array
        }

        return arr;
    }

    public static void print(double[] array){
        //this is the function that will tae the objects and seperate them with a comma
        System.out.print("[");//beginning of the array

        for(int i=0; i < array.length; i++){
            if (i < array.length-1) System.out.print(array[i] + ", "); // your array is now value 4, and it will subtract until your value is 
            else System.out.print(array[i] + "]");                     // a number less than the array size and will print out the commas
        }
        System.out.println();
    }

    public static double[] merge(double[] array1, double[] array2){//parameter of function, you passed the arrays as arguments
        //this is the function that merges both arrays
        double[] array = new double[array1.length + array2.length]; // so this is 4+3 = 7

        for(int i=0; i < array.length; i++){
            if (i < array1.length) array[i] = array1[i];
            else array[i] = array2[i-array1.length];
        }
        return array;
    }

    public static void main(String[] args){
        System.out.print("Enter array1: ");
        double[] array1 = createArrayFromInput();
        System.out.print("Enter array2: ");
        double[] array2 = createArrayFromInput();
        double[] array3 = merge(array1, array2);
        print(array1);
        print(array2);
        print(array3);
    }
}