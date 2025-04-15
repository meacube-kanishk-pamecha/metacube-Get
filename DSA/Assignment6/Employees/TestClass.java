package Employees;

public class TestClass {

    /**
     * sort method sorts the linked list using Quick sort comparing the list
     *
     * @param head head start of the linked list
     */
    public static Node quickSort(Node head) {
        Node tail = getTail(head);
        quickSort(head, tail);
        return head;
    }

    /**
     * quickSort implementaion for sorting the linkedlist
     * 
     * @param head Node start the start or the head of the linked list.
     * @param tail Node tail the last node of the list.
     */
    private static void quickSort(Node head, Node tail) {

        if (head == null || head == tail || head == tail.nxt)
            return;

        Node pivot = partition(head, tail);
        if (pivot != head) {
            Node temp = head;

            // until the last node or the pivot
            while (temp.nxt != pivot && temp.nxt != null) {
                temp = temp.nxt;
            }
            temp.nxt = null;
            quickSort(head, temp);
            temp.nxt = pivot;
        }

        if (pivot != tail && pivot.nxt != null) {
            quickSort(pivot.nxt, tail);
        }
    }

    /**
     * partition it partition the list in two half one of the smaller values of the
     * pivot and other larger value
     * 
     * @param head starting node of the head
     * @param tail end where the list is getting end
     * @return Node or the pivot node
     */
    private static Node partition(Node head, Node tail) {
        Employee pivotValue = tail.e;
        Node i = head, j = head;

        // until j is tail
        while (j != tail) {
            if (j.e.compareTo(pivotValue) < 0) {
                swap(i, j);
                i = i.nxt;
            }
            j = j.nxt;
        }

        swap(i, tail);
        return i;
    }

    /**
     * getTail it return the tail of the linkedlist
     * 
     * @param Node node the starting or mid node
     * @return Node the last node of the list
     */
    private static Node getTail(Node node) {
        while (node != null && node.nxt != null) {
            node = node.nxt;
        }
        return node;
    }

    /**
     * swap it swaps the Node a and b employee e values.
     * 
     * @param a first node which is to be swapped
     * @param b second node which is to be swaped
     */
    private static void swap(Node a, Node b) {
        Employee temp = a.e;
        a.e = b.e;
        b.e = temp;
    }

    /**
     * print it prints the List until the end Node.
     * 
     * @param head the head or start of the list.
     */
    public static void print(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.e);
            temp = temp.nxt;
        }
    }

    // main method to test the quicksort
    public static void main(String[] args) {
        System.out.println("We are in main class");

        Node head = new Node();
        Node n1 = new Node(new Employee(10, 100000, "kanihsk"));
        head.nxt = n1;
        Node n2 = new Node(new Employee(10, 20000, "Mansa"));
        n1.nxt = n2;
        Node n3 = new Node(new Employee(8, 3000, "Mansa"));
        n2.nxt = n3;
        Node n4 = new Node(new Employee(12, 90000, "Mansa"));
        n3.nxt = n4;
        Node n5 = new Node(new Employee(10, 2000, "Mansa"));
        n4.nxt = n5;
        Node n6 = new Node(new Employee(11, 3000, "Mansa"));
        n5.nxt = n6;
        Node n7 = new Node(new Employee(12, 70000, "Mansa"));
        n6.nxt = n7;

        print(head.nxt); // before sort
        quickSort(head.nxt); // sorting
        System.out.println("After Sorting:");
        print(head.nxt); // after sort
    }
}
