package p14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int h = Integer.parseInt(s[0]);
        int w = Integer.parseInt(s[1]);

        int[][] map = new int[h][w];
        int[] block = new int[w];
        s = br.readLine().split(" ");
        for (int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < w; i++) {

        }
    }
}
