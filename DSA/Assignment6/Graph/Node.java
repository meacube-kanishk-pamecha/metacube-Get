import java.util.ArrayList;
import java.util.List;

public class Node {

    public int val;
    public List<Edge> child = new ArrayList<>();

    Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return " " + val;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + val;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (val != other.val)
            return false;
        return true;
    }

}

class Edge implements Comparable<Edge> {
    Node end;
    int value;

    Edge(Node end, int value) {
        this.end = end;
        this.value = value;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((end == null) ? 0 : end.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (end == null) {
            if (other.end != null)
                return false;
        } else if (!end.equals(other.end))
            return false;
        return true;
    }

    /**
     * compareTo it compares the edge value of the current object with edge values
     * of the given object
     */
    @Override
    public int compareTo(Edge e) {
        if (this.value > e.value)
            return 1;
        return -1;
    }

    @Override
    public String toString() {
        return "--" + value + "->" + end;
    }
}