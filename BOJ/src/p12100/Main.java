package p12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] board;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int n;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        recur(0, board);
        System.out.println(max);
    }

    private static void recur(int move, int[][] boardOrigin) {
        if (move == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (max < boardOrigin[i][j])
                        max = boardOrigin[i][j];
                }
            }
            return;
        }

        for (int k = 0; k < 4; k++) {
            int[][] board = copyBoard(boardOrigin);
            Deque<Integer> deque = new LinkedList<>();
            if (k % 2 == 0) {
                for (int y = 0; y < n; y++) {
                    int[] arr = board[y];
                    if (k == 0) {
                        reverseArr(arr);
                        sumNum(deque, arr);
                        for (int i = 0; i < n; i++) {
                            if (deque.isEmpty()) board[y][n - 1 - i] = 0;
                            else board[y][n - 1 - i] = deque.pollFirst();
                        }
                    } else {
                        sumNum(deque, arr);
                        for (int i = 0; i < n; i++) {
                            if (deque.isEmpty()) board[y][i] = 0;
                            else board[y][i] = deque.pollFirst();
                        }
                    }
                }
            } else {
                for (int x = 0; x < n; x++) {
                    int[] arr = new int[n];
                    for (int y = 0; y < n; y++) {
                        int num = board[y][x];
                        arr[y] = num;
                    }
                    if (k == 1) {
                        reverseArr(arr);
                        sumNum(deque, arr);
                        for (int i = 0; i < n; i++) {
                            if (deque.isEmpty()) board[n - 1 - i][x] = 0;
                            else board[n - 1 - i][x] = deque.pollFirst();
                        }
                    } else {
                        sumNum(deque, arr);
                        for (int i = 0; i < n; i++) {
                            if (deque.isEmpty()) board[i][x] = 0;
                            else board[i][x] = deque.pollFirst();
                        }
                    }
                }
            }
            recur(move + 1, board);
        }
    }

    private static void sumNum(Deque<Integer> deque, int[] arr) {
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) continue;
            if (temp != arr[i]) {
                temp = arr[i];
                deque.addLast(arr[i]);
            } else {
                temp = 0;
                deque.addLast(deque.pollLast() + arr[i]);
            }
        }
    }

    private static void reverseArr(int[] arr) {
        int h = n / 2;
        int temp;
        for (int i = 0; i < h; i++) {
            temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    private static int[][] copyBoard(int[][] board) {
        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }
}
