import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class GenericStackComposition<E>{
    private ArrayList<E> list = new ArrayList<>();
    public void push(E e){
        list.add(e);
    }

    public E peek(){
        return list.get(list.size() - 1);
    }

    public E pop(){
        return list.remove(list.size() - 1);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void clear(){
        list.clear();
    }

    public String toString(){
        return list.toString();
    }

    public int size() {
        return list.size();
    }
}

class TestGenericStackCompostion{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        GenericStackComposition<Integer> stack = new GenericStackComposition<>();
        int command;

        do{
            System.out.println ("GenericStack: " + stack);
            System.out.println ("Size: " + stack.size());
            System.out.println ("1 - Push a random integer into stack");
            System.out.println ("2 - Peek stack");
            System.out.println ("3 - Pop stack");
            System.out.println ("4 - Is stack empty?");
            System.out.println ("5 - Clear stack");
            System.out.println ("0 - Exit");
            System.out.print ("Command > ");
            command = input.nextInt();

            switch(command){
                case 1: stack.push(r.nextInt(100));
                        break;
                case 2: System.out.println(stack.peek());
                        break;
                case 3: System.out.println(stack.pop());
                        break;
                case 4: System.out.println(stack.isEmpty());
                        break;
                case 5: stack.clear();
                        break;     
            }
        } while(command != 0);
    }
}