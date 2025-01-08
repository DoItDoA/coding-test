package backtracking.p9663;

import java.io.*;
// 매우 어려움

public class Main2 {
    static int N;
    static int[] board; // board[i]는 i번째 행에 퀸이 놓인 열의 위치
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);
        board = new int[N];

        solve(0); // 0번째 행부터 퀸을 배치
        System.out.println(count);
    }

    public static void solve(int row) {
        if (row == N) { // 모든 행에 퀸을 배치한 경우
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) { // 현재 위치에 퀸을 놓을 수 있는지 확인
                board[row] = col;
                solve(row + 1); // 다음 행으로 이동
            }
        }
    }

    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 퀸이 있는지 확인
            int i1 = board[i];
            boolean b = board[i] == col;
            if (board[i] == col) {
                return false;
            }
            // 대각선에 퀸이 있는지 확인(가로길이와 세로 길이가 같으면 대각션에 위치)
            int abs = Math.abs(board[i] - col); // 가로 길이
            int abs1 = Math.abs(i - row); // 세로 길이
            if (Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}