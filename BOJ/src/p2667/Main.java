package p2667;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int[][] map;
    private static boolean[][] check;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int input = 0;
    private static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(br.readLine());

        map = new int[input][input];
        check = new boolean[input][input];

        for (int y = 0; y < input; y++) {
            String binary = br.readLine();
            for (int x = 0; x < input; x++) {
                map[y][x] = Integer.parseInt(String.valueOf(binary.charAt(x)));
            }
        }

        List<Integer> sizeList = new ArrayList<>();
        for (int y = 0; y < input; y++) {
            for (int x = 0; x < input; x++) {
                if (map[y][x] == 1 && !check[y][x]) {
                    check[y][x] = true;
                    size = 1;
                    dfs(y, x);
                    sizeList.add(size);
                }
            }
        }
        System.out.println(sizeList.size());
        Collections.sort(sizeList);
        for(Integer size: sizeList){
            System.out.println(size);
        }
    }

    static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];
            if (ax >= 0 && ax < input && ay >= 0 && ay < input) {
                if (map[ay][ax] == 1 && !check[ay][ax]) {
                    check[ay][ax] = true;
                    size++;
                    dfs(ay, ax);
                }
            }
        }
    }
}