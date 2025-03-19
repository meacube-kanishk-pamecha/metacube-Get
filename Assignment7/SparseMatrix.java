import java.util.*;
public class SparseMatrix {

    private boolean square = true;
    int row = 0;
    int column = 0;
    // comporator compares the value in the hashmap and keeps in the sorted way
    private Comparator<Pos> sorter = (a, b) -> {
        if(a.i == b.i){
            return a.j - b.j;
        }
        return a.i - b.i;
    };
   final Map<Pos, Integer> mp = new TreeMap<>(sorter);

   //constructor
    SparseMatrix(int[][] array) {
        row = array.length;
        column = array[0].length;
        //checking if it square or not 
        if (row != column)
            square = false;
            //looping throught the loop for row
        for (int i = 0; i < row; i++) {
            // looping for the column 
            for (int j = 0; j < column; j++) {
                // if not equal to zero add it in the hashmap
                if (array[i][j] != 0) {
                    Pos p = new Pos(i, j);
                    mp.put(p, array[i][j]);
                }
            }
        }

    }

    /**
     * transPose transposes the matrix gives the alue at i,j to j,i
     * @return HashMap<Pos, Integer> of the transposed matrix
     */
    protected Map<Pos, Integer> transPose() {
        Map<Pos, Integer> newtransPose = new TreeMap<>(sorter);
        // iterate all the non zero values of the matrix and gives it to new hashmap in tranposed pos.
        for (var position : mp.keySet()) {
            Pos p = new Pos(position.j, position.i);
            newtransPose.put(p, mp.get(position));

        }
        return newtransPose;
    }

    /**
     * symmetrical checks the symmetrical or not
     * @return boolean if symmetric return true else false
     */
    protected boolean symmetrical() {
        // if it is not square matrix return false
        if (!square)
            return false;
        // iterate all the non zero values of the matrix and cheks it to symmetrical position if it is not same return false.
        for (var p : mp.keySet()) {

            //if not same return false
            if (mp.get(new Pos(p.j, p.i)) != mp.get(p)) {
                System.out.println(mp.get(new Pos(p.j, p.i)) + "" + mp.get(p));
                return false;
            }
        }
        return true;

    }

    /**
     * addition performs addition of two sparse matrix 
     * @param  SparseMatrix sm object of the SparseMatrix class to be added with th current object
     * @return HashMap<Pos,Integer> which stores the result of the addition of two matrix 
     */
    protected Map<Pos, Integer> addition(SparseMatrix sm) {

        Map<Pos, Integer> ans = new TreeMap<>(sorter);
        // iterating for the 1st object and adding in the answer
        for (var p : mp.keySet()) {
            ans.put(p, mp.get(p));
        }
        // iterating over the 2nd object hashmap and adding in the answer 
        for (var p : sm.mp.keySet()) {
            // checking there is already present for this key 
            if (ans.containsKey(p)) {
                ans.put(p, ans.get(p) + sm.mp.get(p));
            } 
            else {
                ans.put(p, sm.mp.get(p));
            }

        }

        return ans;
    }

    /**
     * 
     * @param a
     * @param map
     * @return
     */
  


    /**
     * multiplication multiplies the current object map and passed object map
     * @param SparseMatrix sm  object of the 
     * @return
     */
    protected Map<Pos, Integer> multiplication(SparseMatrix sm) {
        Map<Pos, Integer> ans = new TreeMap<>(sorter);
        // iterating the outer loop for the columns
        for (int i = 0; i < column; i++) {
            // iterating for the inner loop for the rows of sm object 
            for (int j = 0; j < sm.row; j++) {
                // iterating through the k common 
                for (int k = 0; k < row; k++) {
                       // putting it in the hashmap 
                        ans.put(new Pos(i, j),
                                (mp.getOrDefault(new Pos(i, k), 0) * sm.mp.getOrDefault(new Pos(k, j), 0))+ans.getOrDefault(new Pos(i, j),0));
                    
                }
            }

        }
        return ans;
    }

   
    /**
     * Checking it the Map are equal or not 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SparseMatrix other = (SparseMatrix) obj;
        if (mp == null) {
            if (other.mp != null)
                return false;
        } else if (!mp.equals(other.mp))
            return false;
        return true;
    }

   




}