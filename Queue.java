import java.util.NoSuchElementException;

/**
 * 
 * A Queue data structure implemented using a linked list. The Queue
 * operates on a First-In-First-Out (FIFO) principle, allowing elements to be
 * added to the back of the queue and removed from the front of the queue.
 */

public class Queue extends Quack {
    /**
     * Constructor for the Queue class
     */
    public Queue() {
        // call the parent class constructor
        super();
    }

    /**
     * Adds an object to the end of the queue.
     *
     * @param next the object to be added
     */
    public void enqueue(Object next) {
        append(next); // insert to the back of the queue
    }

    /**
     * Removes and returns the object at the front of the queue.
     *
     * @return the object at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return remove(0); // remove from the front of the queue
    }

    /**
     * Returns a string representation of the Queue.
     *
     * @return a string representation of the elements in the Queue
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current.next != null) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        sb.append(current.data).append("]");
        return sb.toString();
    }

    /**
     * Compares the sizes and elements of two Queue objects.
     *
     * @param other the Queue to be compared to this one
     * @return a boolean indicating whether the two Queue objects are equal
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Queue)) {
            return false;
        }

        Queue otherQueue = (Queue) other;

        if (size() != otherQueue.size()) {
            return false;
        }

        for (int i = 0; i < size(); i++) {
            if (!get(i).equals(otherQueue.get(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * A simple test of the Queue class.
     */
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        System.out.println("Queue contents after enqueues: " + q);

        Object c = q.dequeue();
        System.out.println("Dequeued element: " + c);
        System.out.println("Queue contents after first dequeue: " + q);

        c = q.dequeue();
        System.out.println("Dequeued element: " + c);
        System.out.println("Queue contents after second dequeue: " + q);

        c = q.dequeue();
        System.out.println("Dequeued element: " + c);
        System.out.println("Queue contents after third dequeue: " + q);

        try {
            q.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Queue empty = new Queue();
        try {
            empty.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
