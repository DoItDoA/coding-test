package p14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int h = Integer.parseInt(s[0]);
        int w = Integer.parseInt(s[1]);

        int[] block = new int[w];
        s = br.readLine().split(" ");
        for (int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(s[i]);
        }

        int[] leftMax = new int[w];
        int[] rightMax = new int[w];
        leftMax[0] = block[0];
        rightMax[w - 1] = block[w - 1];
        for (int i = 1; i < w; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], block[i]);
        }
        for (int i = w - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], block[i]);
        }

        int water = 0;
        for (int i = 0; i < w; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - block[i];
        }
        System.out.println(water);
    }
}
