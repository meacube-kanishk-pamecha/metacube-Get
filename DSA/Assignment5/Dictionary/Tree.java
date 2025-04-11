package Dictionary;

import java.util.ArrayList;
import java.util.List;

public class Tree implements Dictionary, Comparable<Tree> {
    String key;
    String value;
    Tree left;
    Tree right;

    public Tree(String key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * hashCode it is used for the matching the hash value
     */
    @Override
    public int hashCode() {
        return (key == null) ? 0 : key.hashCode();
    }

    /**
     * It checks the two objects are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Tree other = (Tree) obj;
        return key != null && key.equals(other.key);
    }

    /**
     * It is implementation of the abstract function
     */
    @Override
    public int compareTo(Tree other) {
        return this.key.compareTo(other.key);
    }

    /**
     * add this function adds a node to the tree
     * 
     * @param Tree curr the curr node for which it is to be checked
     * @param Tree n the tree which is to be added
     * @return Tree root node
     */
    public Tree add(Tree curr, Tree n) {
        if (curr == null)
            return n;
        if (curr.compareTo(n) > 0) {
            curr.left = add(curr.left, n);
        } else {
            curr.right = add(curr.right, n);
        }
        return curr;
    }

    /**
     * sorted this operation gives the inorder traversal in a list
     * 
     * @param root node as the current curr
     * @return List<Tree> in the sorted manner
     */
    public List<Tree> sorted(Tree curr) {

        List<Tree> sortedList = new ArrayList<>();
        inOrder(curr, sortedList);
        return sortedList;
    }

    /**
     * inorder traversal gives the left root right value which are the sorted
     * 
     * @param curr the current on which the tree is standing
     * @param list the lsit in which we are storing the values
     */
    private void inOrder(Tree curr, List<Tree> list) {
        if (curr == null)
            return;
        // inorder traversal left root right
        inOrder(curr.left, list);
        list.add(curr);
        inOrder(curr.right, list);
    }

    /**
     * sortedBetween it make the sorted list first and removes the nodes whose are
     * not in that region
     * 
     * @param key1 the lower limit from where it should be started
     * @param key2 the higher limit upto which it can take values
     * @param curr current tree node
     * @return List<Tree> this contains all the node which are in the range of key1
     *         and key2
     */
    public List<Tree> sortedBetween(String key1, String key2, Tree curr) {
        List<Tree> sortedList = sorted(curr);
        List<Tree> ans = new ArrayList<>();
        // checking for each string that it is in between them or not
        for (Tree node : sortedList) {
            if (node.key.compareTo(key1) >= 0 && node.key.compareTo(key2) <= 0) {
                ans.add(node);
            }
        }
        return ans;
    }

    /**
     * get this gives the value of the key inserted
     * 
     * @param Tree   curr the curr node for which it is to be checked
     * @param String key the tree which is to be added
     * @return String the value of the given key
     */
    public String get(Tree curr, String key) {
        if (curr == null)
            return null;
        int cmp = key.compareTo(curr.key);
        if (cmp == 0)
            return curr.value;
        else if (cmp < 0)
            return get(curr.left, key);
        else
            return get(curr.right, key);
    }

    /**
     * delete this function is used for deleting a specific node from the tree
     * 
     * @param Tree curr the curr node for which it is to be checked
     * @param Tree n the tree which is to be delete
     * @return Tree root node
     */
    @Override
    public Tree delete(Tree curr, String key) {
        if (curr == null)
            return null;

        int cmp = key.compareTo(curr.key);
        // if key is smaller than the current move left
        if (cmp < 0) {
            curr.left = delete(curr.left, key);
        }
        // if key is smaller than the current move left
        else if (cmp > 0) {
            curr.right = delete(curr.right, key);
        }
        // it matches with the current element delete it
        else {
            // Node to delete found
            if (curr.left == null)
                return curr.right;
            if (curr.right == null)
                return curr.left;

            Tree min = replaceNode(curr.right);
            curr.key = min.key;
            curr.value = min.value;
            curr.right = delete(curr.right, min.key);
        }
        return curr;
    }

    /**
     * replaceNode it gives the node to replaced
     * 
     * @param Tree node it the node which is to be replaced with the deleting node
     * @return Tree the node which is to be replaced
     */
    private Tree replaceNode(Tree node) {
        // finding the node that can replace the current node
        while (node.left != null)
            node = node.left;
        return node;
    }

    /**
     * parseJSON It takes the JSON as String it is used to make it
     * 
     * @param String s it is the json value
     */
    public void parseJSON(String s) {
        // splitiong on the basis of , with a new line
        for (String str : s.split(",\n")) {

            // removing the first and last bracekts.
            str = str.substring(1, str.length() - 1);
            String[] mp = new String[2];
            int count = 0;

            // spliting on the basis of ,
            for (String ss : str.split(", ")) {
                String[] name = ss.split(":");
                // setting the key and values
                mp[count++] = name[1];
            }

            System.out.println(mp[0] + "->" + mp[1]);
            // adding to the current node
            this.add(this, new Tree(mp[0], mp[1]));

        }

    }

    /**
     * Overiding the toString function
     */
    @Override
    public String toString() {
        return "" + key + "-> " + value + " ";
    }
}
