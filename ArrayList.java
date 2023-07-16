/**

A ArrayList (Queue + Stack) is a data structure that allows you to add and remove items from both ends.
This implementation is backed by a singly-linked list.
*/

public class ArrayList <T> {
    // Inner class representing a node in the linked list
    protected class Node {
        T data;
        Node next;

        /**
         * Constructs a new node with the given data.
         *
         * @param data the data to be stored in the node
         */
        protected Node(T data) {
            this.data = data;
            this.next = null;
        }

    }

    // Start of the linked list
    protected Node head;

    /**
     * Constructs a new, empty ArrayList.
     */
    public ArrayList() {
        head = null;
    }

    /**
     * Inserts a new element at the specified index.
     * 
     * @param newData the data to be stored in the new node
     * @param index   the index at which to insert the new node
     */
    public void insert(T newData, int index) {
        if (index < 0) {
            System.out.println("Error: Cannot insert at negative index.");
            return;
        }
        Node newNode = new Node(newData);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node prev = getNode(index - 1);
            if (prev == null) {
                return;
            }
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    /**
     * Retrieves the node at a given index in the linked list.
     * 
     * @param index The index of the node to retrieve.
     * @return The node at the given index, or null if the index is less than 0.
     *         If the index is out of bounds, an error message will be printed to
     *         the console.
     */
    private Node getNode(int index) {
        if (index < 0) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Error: Index out of bounds.");
        }
        return current;
    }

    /**
     * Removes the element at the specified index.
     * 
     * @param index the index of the node to remove
     * @return the data stored in the removed node
     */
    public T remove(int index) {
        if (head == null) {
            System.out.println("Error: Cannot remove from empty list.");
            return null;
        }
        if (index == 0) {
            Node removedNode = head;
            head = head.next;
            return removedNode.data;
        }
        Node prev = getNode(index - 1);
        if (prev == null || prev.next == null) {
            return null;
        }
        Node removedNode = prev.next;
        prev.next = removedNode.next;
        return removedNode.data;
    }

    /**
     * Appends the given data to the end of the ArrayList.
     * 
     * @param newData the data to be appended to the ArrayList
     */
    public void append(T newData) {
        if (head == null) {
            head = new Node(newData);
        } else {
            Node lastNode = getNode(size() - 1);
            lastNode.next = new Node(newData);
        }
    }
    public void add(T newData) {
        append( newData);
    }
    /**
     * Deletes the element at the specified index.
     * 
     * @param index the index of the node to delete
     */
    public void delete(int index) {
        remove(index);
    }

    /**
     * Returns the data stored in the node at the specified index.
     * 
     * @param index the index of the node whose data is to be returned
     * @return the data stored in the node at the specified index, or null if the
     *         index is out of bounds
     */
    public T get(int index) {
        Node node = getNode(index);
        return node == null ? null : node.data;
    }

    /**
     * Returns the number of elements in the ArrayList.
     * 
     * @return The number of elements in the ArrayList.
     */
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Determines whether the ArrayList is empty.
     * 
     * @return true if the ArrayList is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the index of the first occurrence of a given target T in the
     * ArrayList.
     * 
     * @param target The T to search for.
     * @return The index of the first occurrence of the target T, or -1 if it
     *         is not found.
     */
    public int indexOf(T target) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(target)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Determines whether this ArrayList is equal to another T.
     * 
     * @param other The object to compare to this ArrayList.
     * @return true if the other object is a ArrayList and has the same elements in the
     *         same order as this ArrayList, false otherwise.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof ArrayList)) {
            return false;
        }
        ArrayList<T> otherArrayList = (ArrayList<T>) other;
        if (size() != otherArrayList.size()) {
            return false;
        }
        Node current = head;
        Node otherCurrent = otherArrayList.head;
        while (current != null) {
            if (!current.data.equals(otherCurrent.data)) {
                return false;
            }
            current = current.next;
            otherCurrent = otherCurrent.next;
        }
        return true;
    }

    /**
     * Returns a string representation of the ArrayList, with elements enclosed in
     * brackets and separated by commas.
     * 
     * @return A string representation of the ArrayList.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * A main method for testing the ArrayList class.
     * Inserts, deletes, and prints the contents of a ArrayList.
     */
    public static void main(String[] args) {
        ArrayList <Integer> q = new ArrayList<>();
        q.append(10);
        q.append(20);
        q.append(30);
        q.insert(15, 1);
        q.insert(25, 3);
        q.insert(35, 5);
        q.insert(5, 0);
        System.out.println("ArrayList contents after inserts: " + q);

        q.delete(0);
        q.delete(3);
        q.delete(q.size() - 1);
        System.out.println("ArrayList contents after deletes: " + q);

        q.insert(40, 2);
        q.insert(45, 2);
        q.delete(2);
        System.out.println("ArrayList contents after mixed inserts/deletes: " + q);

        ArrayList  <Integer> empty = new ArrayList<>();
        empty.delete(0); // should print error message
        empty.insert(1, 1); // should print error message

    }
}