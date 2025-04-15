import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.stream.Collectors;

public class Operations {

    // HashMap that has all the nodes stored in it
    public HashMap<Integer, Node> nod = new HashMap<>();

    /**
     * add List function which adds the edges in a node
     * 
     * @param start int starting node from which node is started
     * @param end   int end node upto which edge is present
     * @param value the value on the node or the weight on the node
     */
    public void addList(int start, int end, int value) {
        Node n1 = nod.get(start);
        Node n2 = nod.get(end);
        n1.child.add(new Edge(n2, value));
        n2.child.add(new Edge(n1, value));
    }

    /**
     * addNode creating a new node and adding it in the HashMap
     * 
     * @param value the number of the nodes that are to be added
     */
    public void addNode(int value) {
        for (int i = 0; i < value; i++) {
            Node n = new Node(i);
            nod.put(i, n);
        }
    }

    /**
     * DFS it implements the Depth First Search. It is for the root node if no
     * parameters are present
     * 
     * @return List<Node> that are found in DFS traversal.
     */
    public List<Node> DFS() {
        return DFS(nod.get(0));
    }

    /**
     * DFS it implements the Depth First Search. It is for the
     * 
     * @param a Node a the starting node of the dfs
     * @return List<Node> which are accessible from the startin node a
     */
    public List<Node> DFS(Node a) {
        HashSet<Node> searched = new HashSet<>();
        Stack<Node> st = new Stack<>();
        st.add(a);

        // if stack is empty stop else continue
        while (!st.empty()) {
            Node temp = st.pop();
            searched.add(temp);

            // adding all the child of the current node in the stack which are not
            for (int i = 0; i < temp.child.size(); i++) {
                Node tempChild = temp.child.get(i).end;
                if (!searched.contains(tempChild)) {
                    st.push(tempChild);
                }
            }
        }
        List<Node> ansList = searched.stream().collect(Collectors.toList());
        return ansList;
    }

    /**
     * isConnected checks the graph has all the nodes connected with the node
     * 
     * @return boolean if it is connected fully then true else false.
     */
    public boolean isConnected() {
        return isConnected(nod.get(0), nod.size());
    }

    /**
     * isConnected checks the graph has all the nodes connected with the node
     * 
     * @param a    starting node from where it is to be checked
     * @param size total number of nodes in a graph
     * @return boolean if it is connected fully then true else false.
     */
    public boolean isConnected(Node a, int size) {
        List<Node> ansList = DFS();
        if (ansList.size() == size) {
            return true;
        }
        return false;
    }

    /**
     * getNode return a node from hashmap for the integer value a
     * 
     * @param a integer value or the node number a
     * @return Node a the node reference for that integer value.
     */
    public Node getNode(int a) {
        return nod.get(a);
    }

    /**
     * reachable the node which are rechable from the current node
     * 
     * @param Node a DFS traversal with the starting node a
     * @return List of nodes that are reachable or traveresed during DFS traversal.
     */
    public List<Node> reachable(Node a) {
        return DFS(a);
    }

    /**
     * mst is the minimum Spanning tree gives the tree with the all nodes and n-1
     * edges
     * 
     * @return ArrayList of Edges which connects all the
     */
    public ArrayList<Edge> mst() {
        PriorityQueue<Edge> upcoming = new PriorityQueue<>();
        HashSet<Node> visited = new HashSet<>();
        ArrayList<Edge> ans = new ArrayList<>();
        Node a = nod.get(0);
        visited.add(a);

        // adding all the childs in the in the priority queue
        for (int i = 0; i < a.child.size(); i++) {
            upcoming.add(a.child.get(i));
        }

        // for each child edge checking the end node is connected or not.
        while (!upcoming.isEmpty()) {
            Edge edge = upcoming.poll();

            // if the it is not already visited else do not again go through
            if (!visited.contains(edge.end)) {
                visited.add(edge.end);
                ans.add(edge);

                // adding all the childs in the in the priority queue
                for (int i = 0; i < edge.end.child.size(); i++) {
                    upcoming.add(edge.end.child.get(i));
                }
            }
        }
        return ans;

    }

    /**
     * shortestPath it gives shortest path from start to end node
     * 
     * @param start Node start from which we are finding the smallest path
     * @param end   Node end upto which we are finding the smallest path
     * @return int the minimum value which we are finding from a to b.
     */
    public int shortestPath(Node start, Node end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        HashMap<Node, Integer> minValue = new HashMap<>();
        HashSet<Node> isVisited = new HashSet<>();

        minValue.put(start, 0);
        pq.add(new Edge(start, 0));

        // until the priority queue is empty
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            Node curr = edge.end;

            // if it is already visited continue
            if (isVisited.contains(curr))
                continue;
            isVisited.add(curr);

            // all the child of the curr node and finding the minimum values of thec curr
            for (Edge childs : curr.child) {
                if (!isVisited.contains(childs.end)) {
                    int newDist = minValue.getOrDefault(curr, Integer.MAX_VALUE) + childs.value;
                    if (newDist < minValue.getOrDefault(childs.end, Integer.MAX_VALUE)) {
                        minValue.put(childs.end, newDist);
                        pq.add(new Edge(childs.end, newDist));
                    }
                }
            }
        }

        return minValue.get(end);
    }

}
