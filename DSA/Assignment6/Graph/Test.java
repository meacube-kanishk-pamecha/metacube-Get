public class Test {
    public static void main(String[] args) {

        Operations op = new Operations();
        // adding nodes in the hashmap
        op.addNode(5);

        // adding the edges and calling the edge function
        op.addList(0, 1, 4);
        op.addList(0, 4, 5);
        op.addList(1, 4, 6);
        op.addList(1, 3, 2);
        op.addList(3, 4, 7);
        op.addList(2, 1, 8);
        op.addList(2, 3, 1);

        // Calling all the functions and getting there output
        System.out.println(op.DFS());
        System.out.println(op.reachable(op.getNode(0)));
        System.out.println(op.mst());
        System.out.println(op.isConnected());
        System.out.println(op.shortestPath(op.getNode(0), op.getNode(2)));
    }
}
