package Dictionary;

public interface Dictionary {

    /**
     * add this function adds a node to the tree
     * 
     * @param Tree curr the curr node for which it is to be checked
     * @param Tree n the tree which is to be added
     * @return Tree root node
     */
    Tree add(Tree curr, Tree n);

    /**
     * delete this function is used for deleting a specific node from the tree
     * 
     * @param Tree curr the curr node for which it is to be checked
     * @param Tree n the tree which is to be delete
     * @return Tree root node
     */
    Tree delete(Tree curr, String val);

    /**
     * get this gives the value of the key inserted
     * 
     * @param Tree   curr the curr node for which it is to be checked
     * @param String key the tree which is to be added
     * @return String the value of the given key
     */
    String get(Tree curr, String key);

}