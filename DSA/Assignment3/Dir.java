import java.util.*;

class Node {
    String Name;
    List<Node> list;

    Node(String s) {
        this.Name = s;
        this.list = new ArrayList<>();
    }

    @Override
    public String toString() {
        return Name;
    }
}

public class Dir {

    static List<Node> curr;
    static Node root;

    public Dir() {
        root = new Node("C:");
        curr = new ArrayList<>();
        curr.add(root);
    }

    /**
     * cd for changing the directory this function is called
     * 
     * @param String s name of the directory to be changed
     */
    void cd(String s) {
        // list of sub directories in the current directory
        List<Node> ans = curr.get(curr.size() - 1).list;
        boolean found = false;
        // checking if the curr dir. contains the given directory
        for (Node node : ans) {
            if (node.Name.equals(s)) {
                // adding it to the curr List in which the current directorie are stored
                curr.add(node);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Directory not found: " + s);
        }
    }

    /**
     * ls used to list the sub directories of the current dir.
     */
    void ls() {
        List<Node> ans = curr.get(curr.size() - 1).list;
        for (Node node : ans) {
            System.out.println(node.Name);
        }
    }

    /**
     * mkdir function used to create a new directory
     * 
     * @param String s name of the directory is to be created
     */
    void mkdir(String s) {
        List<Node> ans = curr.get(curr.size() - 1).list;
        for (Node node : ans) {
            if (node.Name.equals(s)) {
                System.out.println("Directory already exists: " + s);
                return;
            }
        }
        ans.add(new Node(s));
    }

    /**
     * bk return to the parent element
     */
    void bk() {
        if (curr.size() == 0) {
            System.out.println("Root Directory");
            return;
        }
        curr.remove(curr.size() - 1);

    }

    /**
     * find to find a sub directory
     * 
     * @param String s name of the directory to be found
     */
    List<Node> find(String s) {
        return find(s, curr.get(curr.size() - 1), new ArrayList<>());
    }

    List<Node> find(String s, Node currFind, List<Node> listCurr) {
        if (s.equals(currFind.Name)) {
            listCurr.add(currFind);
            return listCurr;
        }
        // going inside each sub Directory and finding the file or directory with
        // soecified name
        for (Node node : currFind.list) {
            listCurr.add(node);
            List<Node> found = find(s, node, listCurr);
            if (found != null) {
                return listCurr;
            }
            listCurr.remove(node);
        }
        return null;
    }

    /**
     * print the current position of the user in the dir.
     */
    void print() {
        for (Node n : curr) {
            System.out.print(n.Name + "/");
        }
        System.out.print(">");
    }

    /**
     * to print the tree like structure of the dir
     * 
     * @param node  start node of the structure
     * @param space space in this iteraion from the left
     * @param last  is it last the node
     * @param first is it the first node
     */
    void tree(Node node, String space, boolean last, boolean first) {

        System.out.print(space);
        // is it thefirst node
        if (first) {
            System.out.print("\u2500\u2500\u2500 ");
        }
        // is it last node
        else if (last) {
            System.out.print("\u2514\u2500\u2500 ");

        }
        // other nodes.
        else {
            System.out.print("\u251c ");
        }
        System.out.println(node.Name);

        String format;
        if (last) {
            format = space + "    ";
        } else {
            format = space + "\u2502   ";
        }

        int size = node.list.size();
        for (int i = 0; i < size; i++) {
            tree(node.list.get(i), format, i == size - 1, false);
        }
    }

    /**
     * tree function that calls tree for printing in the vcmd
     */
    void tree() {
        tree(root, "", true, true);
    }

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        Dir d = new Dir();
        d.print();
        // Infinite loop
        while (true) {
            String s = Sc.nextLine();
            String[] arr = s.split("\\s");
            // matching the commands given by the user
            switch (arr[0]) {
                case "cd":
                    d.cd(arr[1]);
                    d.print();
                    break;
                case "ls":
                    d.ls();
                    d.print();
                    break;
                case "mkdir":
                    d.mkdir(arr[1]);
                    d.print();
                    break;
                case "tree":
                    d.tree();
                    d.print();
                    break;
                case "bk":
                    d.bk();
                    d.print();
                    break;
                case "find":
                    List<Node> found = d.find(arr[1]);
                    // found a directory with that name or not
                    if (found != null) {
                        System.out.println("Found directory: " + found);
                    } else {
                        System.out.println("Directory not found.");
                    }
                    d.print();
                    break;

                case "exit":
                    Sc.close();
                    return;

                default:
                    System.out.println("enter valid keyword");
                    d.print();
                    break;
            }

        }
    }
}
