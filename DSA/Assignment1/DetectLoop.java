public class DetectLoop {
    public static boolean detectloop(Node n){
        Node slow = n;
        Node fast = n.next;
        while(fast!=null){
         slow =slow.next;
         fast = fast.next.next;
         if(slow==fast) return true;
        }
        return false;
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
       //  n6.next =n2;
        
      System.out.println( detectloop(head));
    }
}
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
