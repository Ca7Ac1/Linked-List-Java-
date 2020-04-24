
public class LinkedList<E> {

    private Node<E> head;

    /**
     * Create a linked list with multiple starting elements
     * 
     * @param data Starting elements of list
     */
    public LinkedList(E[] data) {
        head = new Node<E>(data[0], null);
        Node<E> currentNode = head;

        for (int i = 1; i < data.length; i++) {
            currentNode.next = new Node<E>(data[i], null);
            currentNode = currentNode.next;
        }
    }

    /**
     * Create a linked list with only the head
     * 
     * @param data Head of the linked list
     */
    public LinkedList(E data) {
        head = new Node<E>(data, null);
    }

    /**
     * Create an empty linked list
     */
    public LinkedList() {
        head = null;
    }

    private class Node<T> {

        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Insert an element at the end of the list
     * @param data
     * The element to be inserted
     */
    public LinkedList<E> insert(E data) {
        Node<E> newNode = new Node<E>(data, null);

        if (head == null) {
            head = newNode;
        } else {
            Node<E> last = head;

            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }
        return this;
    }

    /**
     * Remove an element from the list based on value
     * 
     * @param key The value to be removed
     */
    public LinkedList<E> removeByKey(E key) {
        Node<E> currentNode = head;

        if (head == null) {
            return this;
        }

        if (head.data.equals(key)) {
            head = head.next;
        } else {
            while (currentNode.next != null) {
                if (currentNode.next.data.equals(key)) {
                    currentNode.next = currentNode.next.next;
                    break;
                }
                currentNode = currentNode.next;
            }
        }
        return this;
    }

    /**
     * Remove an element from a list based on position
     * @param index
     * The position of the element to be removed with the 
     * first element having a position of zero
     */
    public LinkedList<E> removeByIndex(int index) {
        Node<E> currentNode = head;
        int count = 1;

        if (currentNode == null) {
            return this;
        }

        if (index == 0) {
            head = head.next;
        } else {
            while (currentNode.next != null) {
                if (count == index) {
                    currentNode.next = currentNode.next.next;
                    break;
                }
                count++;
                currentNode = currentNode.next;
            }
        }
        return this;
    }

    /**
     * Print out the elements of the list
     */
    public void print() {
        Node<E> currentNode = head;

        while (currentNode != null) {
            System.out.println(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }
}