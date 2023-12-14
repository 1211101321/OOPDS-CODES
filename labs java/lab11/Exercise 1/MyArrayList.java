import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyArrayList<E> {
    // data fields
    public static final int INITIAL_CAPACITY = 2;

    private E[] data = (E[]) new Object[INITIAL_CAPACITY];
    private int size;

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        return result.toString() + "]";
    }

    public int size() {
        return size;
    }

    public void ensureCapacity() {
        if (size == data.length) { // full capacity
            E[] newData = (E[]) new Object[size * 2 + 1]; // create a larger array
            // copy all elements from data array to newData array
            System.arraycopy(data, 0, newData, 0, size);
            data = newData; // make data array reference to newData
        }
    }

    public void add(E e) { // add e to the end
        add(size, e);
    }

    public void add(int index, E e) { // add e at index
        if (index < 0 || index > size) { // (index = size) is ok
            throw new IndexOutOfBoundsException("Index: " + index + ",size: " + size);
        }
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e; // place e at index
        size++;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) { // (index = size) is not ok
            throw new IndexOutOfBoundsException("Index: " + index + ",size: " + size);
        }
    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i; // found e at i
            }
        }
        return -1; // when i not found
    }

    public E remove(int index) {
        checkIndex(index);
        E temporary = data[index];
        // shift to left all element from index until the end
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null; // remove the extra last element
        size--;
        return temporary;
    }

    public E remove(E e) { // remove by element
        int index = indexOf(e);
        if (index < 0) { // element not found
            return null;
        } else {
            return remove(index);
        }
    }

    public E set(int index, E e) {
        E temporary = data[index];
        checkIndex(index);
        data[index] = e;
        return temporary;
    }

    public void clear() {// remove all elements
        size = 0;
        data = (E[]) new Object[INITIAL_CAPACITY];
        System.out.println(Arrays.toString(data));// this doesnt actually remove it
    }
}

class TestMyArrayList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MyArrayList<Integer> list = new MyArrayList<>();
        Random r = new Random();
        int command;

        do {
            System.out.println("MyArrayList: " + list);
            System.out.println("Size: " + list.size());
            System.out.println("1 - Add random integer at end");
            System.out.println("2 - Add random integer at specific index");
            System.out.println("3 - Get integer at specified index");
            System.out.println("4 - Get index of specified integer");
            System.out.println("5 - Remove the integer at specified index");
            System.out.println("6 - Remove specified integer");
            System.out.println("7 - Set new random integer at specified index");
            System.out.println("8 - Clear list");
            System.out.println("0 - Exit");
            System.out.print(">> ");
            command = input.nextInt();

            switch (command) {
                case 1:
                    list.add(r.nextInt(100));
                    break;
                case 2:
                    int index = input.nextInt();
                    list.add(index, r.nextInt(100));
                    break;
                case 3:
                    index = input.nextInt();
                    System.out.println(list.get(index));
                    break;
                case 4:
                    Integer target = input.nextInt();
                    System.out.println(list.indexOf(target));
                    break;
                case 5:
                    index = input.nextInt();
                    System.out.println(list.remove(index));
                    break;
                case 6:
                    target = input.nextInt();
                    System.out.println(list.remove(target));
                    break;
                case 7:
                    index = input.nextInt();
                    System.out.println(list.set(index, r.nextInt(100)));
                    break;
                case 8:
                    list.clear();
                    break;
            }
        } while (command != 0);
    }
}