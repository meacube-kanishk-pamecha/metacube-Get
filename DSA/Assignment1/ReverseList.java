

class Node {
    int val;
    Node next;

    Node(int i) {
        this.val = i;
        this.next = null;
    }

    Node() {
    }
}

public class ReverseList {
    /**
     * 
     * @param head Node head of the lsit
     * @param L int left startof the list to be rotated
     * @param R int right end of the list to be rotated
     * @param N how many times to be rotated
     * @return new node of the list
     */  
       public static Node rotate(Node head, int L, int R, int N) {
        Node temp = new Node(0);
        temp.next = head;
        Node prev = temp;
        for (int i = 1; i < L; i++) {
            prev = prev.next;
        }
        Node sHead = prev.next;
        Node sTail = sHead;
        for (int i = L; i < R; i++) {
            sTail = sTail.next;
        }
        Node Listafter = sTail.next;
        sTail.next = null;
        Node rotatedSublist = rotateR(sHead, N, R - L + 1);
        prev.next = rotatedSublist;
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = Listafter;
        return temp.next;
    }

    /**
     * rotateR rotates the list right side by k times
     * @param  Node head it inputs the type of hed 
     * @param int k how many times it to be rotated
     * @param  int length length of the list
     * @return Node new node or start of the list
     */
    private static Node rotateR(Node head, int k, int length) {
        k = k % length;

        Node fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

    /**
     * print function prints the whole Node List
     * @param head parameter is of type Node
     */
    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " ,");
            head = head.next;
        }
       
    }

    public static void main(String[] args) {
        Node head = new Node();
        Node n1 = new Node(2);
        head.next = n1;
        Node n2 = new Node(3);
        n1.next = n2;
        Node n3 = new Node(4);
        n2.next = n3;
        Node n4 = new Node(5);
        n3.next = n4;
        Node n5 = new Node(6);
        n4.next = n5;
        Node n6 = new Node(7);
        n5.next = n6;
        int l = 2;
        int r = 5;
        int n = 2;
        rotate(n1, l, r, n);
        print(n1);


    }

   
    
}



