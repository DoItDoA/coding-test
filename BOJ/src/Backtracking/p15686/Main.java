package Backtracking.p15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int n, m;
    private static int map[][];
    private static List<int[]> house = new ArrayList<>();
    private static List<int[]> chicken = new ArrayList<>();
    private static Integer min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] val = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(val[j]);
                map[i][j] = num;
                if (num == 1) house.add(new int[]{i, j});
                else if (num == 2) chicken.add(new int[]{i, j});
            }
        }

        recur(0, 0, new ArrayList<>());
        System.out.println(min);
    }

    private static void recur(int start, int depth, List<int[]> list) {
        if (depth == m) {
            int distance = 0;
            for (int[] h : house) {
                int minC = Integer.MAX_VALUE;
                for (int[] c : list) {
                    int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    if (minC > d) minC = d;
                }
                distance += minC;
            }
            if (min > distance) min = distance;
            return;
        }

        for (int c = start; c < chicken.size(); c++) {
            list.add(0, chicken.get(c));
            recur(c + 1, depth + 1, list);
            list.remove(0);
        }
    }
}
