package Employees;

public class TestClass {

    /**
     * sort method sorts the linkedlist using insertion sort comparing the
     * neighbours
     * 
     * @param head head start of the linkedlist
     */
    public static void sort(Node head) {
        if (head == null || head.nxt == null)
            return;
        int size = size(head);
        // going throught the linkedlist n times which is the size of the linkedlist
        for (int start = 0; start < size; start++) {
            Node prev = head;
            Node curr = head.nxt;
            // going and making the largest element at the end
            while (curr.nxt != null) {
                // checking it is need to be saped or not
                if (curr.e.compareTo(curr.nxt.e) > 0) {
                    Node temp = curr.nxt;
                    curr.nxt = temp.nxt;
                    temp.nxt = curr;
                    prev.nxt = temp;
                    curr = temp;
                }
                prev = curr;
                curr = curr.nxt;
            }
        }
    }

    /**
     * insertion it sort it sorts the linkedlist on the descending order 
     * @param Node head it is starting node of the linkedList.
     */
    public static void insertion(Node head) {
        if (head == null || head.nxt == null)
            return;

        Node sort = new Node();
        Node curr = head.nxt;
        // when curr is not null
        while (curr != null) {
            Node next = curr.nxt;
            Node prev = sort;
            
            // comparing with the previous employee salary
            while (prev.nxt != null && prev.nxt.e.compareTo(curr.e) < 0) {
                prev = prev.nxt;
            }
            curr.nxt = prev.nxt;
            prev.nxt = curr;
            curr = next;
        }
        head.nxt = sort.nxt;
    }

    /**
     * size function is used to calculate the number of nodes in list
     * 
     * @param head starting of the list
     * @return int size the number of nodes in the list
     */
    public static int size(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.nxt;
        }
        return count;
    }

    /**
     * print function print the linkedlist.
     * 
     * @param head the start of the linkedlist from where it is to be printed
     */
    public static void print(Node head) {
        Node temp = head;
        // getting upto end and print the node encounterd
        while (temp != null) {
            System.out.println(temp.e);
            temp = temp.nxt;
        }
    }

    public static void main(String[] args) {
        System.out.println("We are in main class");
        Node head = new Node();
        Node n1 = new Node(new Employee(10, 1000, "kanihsk"));
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

        print(head);
        insertion(head);
        print(head);
    }
}
