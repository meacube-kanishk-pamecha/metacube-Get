package q1;

import java.util.HashMap;

public class Mirror {

    protected int maxMirror(int[] arr) {
        int max = Integer.MIN_VALUE;
        HashMap<String, Integer> s = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder str = new StringBuilder();
            int count = 0;
            for (int j = i; j < arr.length; j++) {
                str.append(arr[j]);
                count++;
                var ss = str.toString();
                s.put(ss, s.getOrDefault(ss, count));
            }
        }
        for (var temp : s.keySet()) {
            StringBuilder strB = new StringBuilder(temp);
            String str = strB.reverse().toString();
            if (s.containsKey(str)) {
                max = Math.max(max, s.get(str));
            }

        }
        return max;
    }

}
