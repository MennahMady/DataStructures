/**
 * 
 * The Stack class extends the Quack class and provides methods for a stack data
 * structure
 * The Stack class provides methods for creating, manipulating, and comparing
 * stacks. The class
 * includes a constructor, push and pop methods, a method for retrieving the top
 * element of the
 * stack, and a method for returning a string representation of the elements in
 * the stack.
 * The class also includes an equals method to compare the size and elements of
 * two Stack objects.
 * 
 * @author Manuna Mady
 * @version old ADTs now with Linked Lists!
 */
public class Stack extends Quack {

    /**
     * Constructor for the Stack class
     */
    public Stack() {
        super();
    }

    /**
     * Pushes an object onto the top of the stack
     * 
     * @param obj the object to be pushed onto the stack
     */
    public void push(Object newData) {
        insert(newData, 0);
    }

    /**
     * Removes and returns the object at the top of the stack
     * 
     * @return the object at the top of the stack
     */
    public Object pop() {
        return remove(0);
    }

    /**
     * Returns the object at the top of the stack without removing it
     * 
     * @return the object at the top of the stack
     */
    public Object peek() {
        return get(0);
    }

    /**
     * Returns a string representation of the Stack
     * 
     * @return a string representation of the elements in the Stack
     */

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data.toString());
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Compares the sizes and elements of two Stack objects
     * 
     * @param other the Stack to be compared to this one
     * @return a boolean indicating whether the two Stack objects are equal
     */
    public boolean equals(Object other) {
        if (!(other instanceof Stack)) {
            return false;
        }
        return super.equals(other);
    }

    /**
     * Test method for the Stack class
     */
    public static void main(String[] args) {
        Stack empty = new Stack();
        Stack one = new Stack();
        Stack multiple = new Stack();

        one.push(5);
        multiple.push(10);
        multiple.push(20);
        multiple.push(30);

        System.out.println("Empty (should print nothing): " + empty);
        System.out.println("One (should print '5'): " + one);
        System.out.println("Multiple (should print '30, 20, 10'): " + multiple);

        one.pop();
        multiple.pop();
        System.out.println("One (upon pop) (should be empty): " + one);
        System.out.println("Multiple (upon pop) (should be '20, 10'): " + multiple);

        System.out.println("Attempting to pop from an empty stack. Error message should print: " + empty);

    }
}
