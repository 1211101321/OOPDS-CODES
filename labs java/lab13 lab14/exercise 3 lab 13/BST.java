import java.util.Scanner;

public class BST<E extends Comparable<E>> {
    private class TreeNode<E> {
        // data fields for TreeNode
        E element; // null
        TreeNode<E> left; // null
        TreeNode<E> right; // null

        public TreeNode(E e) {
            this.element = e;
        }
    }

    // data fields for BST
    private TreeNode<E> root; // null
    private int size; // null

    // methods
    public int size() {
        return size;
    }

    public boolean insert(E e) {
        if (size == 0) { // insert into empty BST
            root = new TreeNode<E>(e);
        } else { // BST is not empty
            TreeNode<E> current = root;
            TreeNode<E> parent = null; // parent of the current element
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else { // e == current
                    return false;
                }
            }

            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<>(e);
            } else {
                parent.right = new TreeNode<>(e);
            }
        }
        size++;
        return true; // inserted successfully
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(TreeNode<E> parent) {
        if (parent != null) {
            inOrder(parent.left);
            System.out.println(parent.element);
            inOrder(parent.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode<E> parent) {
        if (parent != null) {
            System.out.print(parent.element + " ");
            preOrder(parent.left);
            preOrder(parent.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(TreeNode<E> parent) {
        if (parent != null) {
            postOrder(parent.left);
            postOrder(parent.right);
            System.out.print(parent.element + " ");
        }
    }


    
}

class Exercise3 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Scanner input = new Scanner(System.in);
        int command;

        do {
            System.out.print("InOrder : ");
            bst.inOrder();
            System.out.print("PreOrder : ");
            bst.preOrder();
            System.out.print("PostOrder : ");
            bst.postOrder();
            System.out.println("Size : " + bst.size());
            System.out.println("1. Insert specified integer : ");
            System.out.println("2. Search specified integer : ");
            System.out.println("3. Clear: ");
            System.out.println("0. Exit: ");
            System.out.print("Command > ");
            command = input.nextInt();
            switch (command) {
                case 1:
                    int target = input.nextInt();
                    System.out.println(bst.insert(target));
                    break;
                case 2:
                    break;
                case 3:
                    break;


            }
        } while (command != 0);
    }
}