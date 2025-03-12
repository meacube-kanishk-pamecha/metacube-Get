import java.util.Arrays;

public class KnightsTour {

    public static void main(String[] args) {
        System.out.println("Hey");
        int n = 8;
        int[] xmoves = { 1, 2, -1, -2, 1, 2, -1, -2 };
        int[] ymoves = { 2, 1, -2, -1, -2, -1, 2, 1 };
        int[][] board = new int[n][n];
        int ipos = 0;
        int jpos = 0;
        
        if(knight(board, ipos, jpos, xmoves, ymoves, n, 1)){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
    
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }else{
            System.out.println("Not valid");
        }

    }
    private static boolean isSafe(int row, int col, int[][] board) {
                    
        if(row<board.length && col<board.length && row>=0 && col>=0 && board[row][col]==0)return true;
        return false;
     }

    public static boolean knight(int[][] board, int ipos, int jpos, int[] xmoves, int[] ymoves, int n, int count) {
        if (count == n*n)
            return true;
        // System.out.println("hello" + count);

        int row;
        int col;

        for (int k = 0; k < 8; k++) {
            row = ipos + xmoves[k];
            col = jpos + ymoves[k];
            // System.out.println("dfhj");
            if (isSafe(row, col, board)) {
                
                board[row][col] = count;
                if (knight(board, row, col, xmoves, ymoves, n, count + 1))
                    return true;
                else
                    board[row][col] = 0; // backtracking
            }
        }

    

    return false;
}


}