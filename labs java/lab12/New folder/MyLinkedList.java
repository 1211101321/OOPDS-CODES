public class MyLinkedList<E>{
    private class Node<E>{
        // data fields
        E element;      // Null
        Node<E> next;   // Null

        public Node(E e){
            this.element = e;
        }
    }
    
    // data fields of MyLinkedList
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // methods
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                sb.append(current.element + ", ");
            } else {
                sb.append(current.element);
            }
            current = current.next;
        }
        return sb.toString() + "]";
    }

    public int size(){
        return size;
    }

    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        newNode. next = head;
        head = newNode;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        if(size == 0){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: "+index+"size, "+size);


        }
        if(index == 0){
            addFirst(e);

        }
        else if(index ==size){
            addLast(e);

        }
    }

}