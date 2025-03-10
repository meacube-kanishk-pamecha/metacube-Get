package q1;

public class MirrorTest {
    public static void main(String[] args) {
        Mirror m = new Mirror();
        int [] arr = {1, 4, 5, 3, 5, 4, 1};
        System.out.println(m.maxMirror(arr));
    }
}
