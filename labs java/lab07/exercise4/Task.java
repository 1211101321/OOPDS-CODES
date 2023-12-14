import java.util.*;

public class Task implements Comparable<Task>{
    private int value;
    private String name;

    public Task(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String toString() {
        return "Task <value=" + value + " name=" + name + ">";
    }

    public int compareTo(Task t){
        if(value < t.value){
            return 1;
        }
        else if(value == t.value){
            return 0;
        }
        else{
            return -1;
        }
    }
}

class TestQueues {
    public static void main(String[] args) {
        PriorityQueue<Integer> intPQ = new PriorityQueue<>();
        intPQ.add(40);
        intPQ.add(60);
        intPQ.add(20);
        while (!intPQ.isEmpty())
            System.out.println("Removed from PriorityQueue<Integer>: " +
                    intPQ.poll());

        Queue<Task> q = new LinkedList<>(); // queue is an interface not a class so you cant make a linked list
        q.offer(new Task(3, "Press"));
        q.offer(new Task(8, "Drill"));
        q.offer(new Task(1, "Knock"));

        while (!q.isEmpty()) {
            System.out.println("Removed from Queue<Task> " +
                    q.poll());
        }

        // Q4

        PriorityQueue<Task> taskPQ = new PriorityQueue<>(); // queue is an interface not a class so you cant make a
                                                            // linked list
        taskPQ.offer(new Task(3, "Press"));
        taskPQ.offer(new Task(8, "Drill"));
        taskPQ.offer(new Task(1, "Knock"));

        while (!taskPQ.isEmpty()) {
            System.out.println("Removed from PriorityQueue<Task> :" +
                    taskPQ.poll());
        }

    }

}