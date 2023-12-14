import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class GenericQueueComposition<E>{
    private LinkedList<E> list = new LinkedList<>();
    public void enqueue (E e){
        list.add(e);
    }

    public E dequeue(){
        return list.remove(0);

    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
    

    public void clear(){
        list.clear();
    }

    public int size(){
        return list.size();
    }

    public String toString(){
        return list.toString();
    }

}

class TestGenericQueueComposition{
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        Random r = new Random(0);
        int command;
        GenericQueueComposition<Integer> queue = new GenericQueueComposition<>();

    }
}