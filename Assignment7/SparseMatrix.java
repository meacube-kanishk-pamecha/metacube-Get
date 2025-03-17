import java.util.HashMap;

public class SparseMatrix {

    boolean square = true;
    int row = 0;
    int column = 0;
   final HashMap<Pos, Integer> mp = new HashMap<>();

    SparseMatrix(int[][] array) {
        row = array.length;
        column = array[0].length;
        if (row != column)
            square = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (array[i][j] != 0) {
                    Pos p = new Pos(i, j);
                    mp.put(p, array[i][j]);
                }
            }
        }

    }

    /**
     * transPose 
     * @return HashMap<Pos, Integer>
     */
    protected HashMap<Pos, Integer> transPose() {
        HashMap<Pos, Integer> newtransPose = new HashMap<>();
        for (var position : mp.keySet()) {
            Pos p = new Pos(position.j, position.i);
            newtransPose.put(p, mp.get(position));

        }
        return newtransPose;
    }

    protected boolean symmetrical() {
        if (!square)
            return false;
        for (var p : mp.keySet()) {

            if (mp.get(new Pos(p.j, p.i)) != mp.get(p)) {
                System.out.println(mp.get(new Pos(p.j, p.i)) + "" + mp.get(p));
                return false;
            }
        }
        return true;

    }

    protected HashMap<Pos, Integer> addition(SparseMatrix sm) {

        HashMap<Pos, Integer> ans = new HashMap<>();

        for (var p : mp.keySet()) {
            ans.put(p, mp.get(p));

        }
        for (var p : sm.mp.keySet()) {
            if (ans.containsKey(p)) {
                ans.put(p, ans.get(p) + sm.mp.get(p));
            } else {
                ans.put(p, sm.mp.get(p));
            }

        }

        return ans;
    }

    HashMap<Integer, Integer> findrows(int a, HashMap<Pos, Integer> map) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        for (var clas : map.keySet()) {
            if (clas.i == a) {
                ans.put(clas.j, map.get(clas));
            }
        }
        return ans;
    }

    HashMap<Integer, Integer> findcolums(int a, HashMap<Pos, Integer> map) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        for (var clas : map.keySet()) {
            if (clas.j == a) {
                ans.put(clas.j, map.get(clas));
            }
        }
        return ans;
    }

    protected HashMap<Pos, Integer> multiplication(SparseMatrix sm) {
        HashMap<Pos, Integer> ans = new HashMap<>();
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < sm.row; j++) {
                for (int k = 0; k < row; k++) {
                    
                        ans.put(new Pos(i, j),
                                (mp.getOrDefault(new Pos(i, k), 0) * sm.mp.getOrDefault(new Pos(k, j), 0))+ans.getOrDefault(new Pos(i, j),0));
                    
                }
            }

        }
        return ans;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mp == null) ? 0 : mp.hashCode());
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
        SparseMatrix other = (SparseMatrix) obj;
        if (mp == null) {
            if (other.mp != null)
                return false;
        } else if (!mp.equals(other.mp))
            return false;
        return true;
    }




}