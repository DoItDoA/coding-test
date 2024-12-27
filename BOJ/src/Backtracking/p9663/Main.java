package Backtracking.p9663;
// 매우 어려움
import java.io.*;

public class Main {
    private static int n;
    private static int[] board;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        n = Integer.parseInt(input);

        board = new int[n];
        recur(0);
        System.out.println(cnt);
    }

    private static void recur(int row) {
        if (row == n) {
            cnt++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                recur(row + 1);
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        for (int chkRow = 0; chkRow < row; chkRow++) {
            if (board[chkRow] == col)
                return false;

            if (Math.abs(row - chkRow) == Math.abs(col - board[chkRow]))
                return false;
        }
        return true;
    }
}
