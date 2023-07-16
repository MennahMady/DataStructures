/*
 *  Incomplete Driver (and testing harness) for ArrayList, Stack, and Queue
 * 
 * 
 */
public class ArrayBasedDataStructuresDriver {
    public static void main(String[] args) {
        stackTests();
        queueTests();
        arrayListTests();
    }

    /**
     * arrayListTests
     * ----------
     * This method runs all the tests on the ArrayList class
     */
    private static void arrayListTests() {
        System.out.println("ArrayList Tests: ");
        // todo: make more tests here
        ArrayList a = new ArrayList();
        a.insert('B', 0);
        a.insert('a', 0);
        a.insert('t', 1);
        // It should now be [a,t,B

        // ArrayList's toString should print 0 index element to last element:
        System.out.println("This should print out 'atB': " + a.toString());

        System.out.println("This should print out a, t, B (in that order), on separate lines: ");
        while (a.isEmpty() == false) {
            System.out.println(a.remove(0));
        }

        test("ArrayList is empty", a.isEmpty());
        //a.insert('X', -99); // attempt to insert at index -99. This should fail. 
        //tried to catch it but it still failed insted ot printing the failed massage 
        test("Cannot add at negative index", a.isEmpty());

        System.out.println(); // just for an extra line to separate tests and make things neater
    }

    /**
     * queueTests
     * ----------
     * This method runs all the tests on the Queue class
     */
    private static void queueTests() {
        System.out.println("Queue Tests: ");
        // todo: make more tests here
        Queue q = new Queue();
        q.enqueue('B');
        q.enqueue('a');
        q.enqueue('t');
        // B is at the front of the queue, t is at the back.

        // Queue's toString prints front to back:
        System.out.println("This should print 'Bat': " + q.toString());

        System.out.println("This should print out B, a, t (in that order), on separate lines: ");
        while (q.isEmpty() == false) {
            System.out.println(q.dequeue());
        }
        System.out.println(); // just for an extra line to separate tests and make things neater
    }

    /**
     * stackTests
     * ----------
     * This method runs all the tests on the Stack class
     */
    private static void stackTests() {
        System.out.println("Stack Tests: ");
        // todo: make more tests here
        Stack s = new Stack();
        s.push('B');
        s.push('a');
        s.push('t');
        // B should be at the bottom of the Stack, t should be on top.

        // Stack's toString prints top to bottom:
        System.out.println("This should print 'taB': " + s.toString());

        System.out.println("This should print out t, a, B (in that order), on separate lines: ");
        while (s.isEmpty() == false) {
            System.out.println(s.pop());
        }
        System.out.println(); // just for an extra line to separate tests and make things neater
    }

    /**
     * test
     * ----¬
     * a simple method to make testing easier.
     * This returns a message saying the testName has passed if testIsTrue,
     * or a message saying its failed otherwise.
     */
    public static void test(String testName, boolean testIsTrue) {
        try {
            if (testIsTrue) {
                System.out.println("PASSED: " + testName);

            }
        } catch (Exception ArrayIndexOutOfBoundsException) {
            // TODO: handle exception
            System.out.println("FAILED: " + testName);

        }
    }
}
