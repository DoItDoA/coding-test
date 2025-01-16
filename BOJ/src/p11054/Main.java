package p11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        int[] dpD = new int[n];
        int[] dpI = new int[n];

        String[] val = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(val[i]);
            dpI[i] = 1;
            dpD[i] = 1;
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) {
                    dpI[i] = Math.max(dpI[i], dpI[j] + 1);
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (num[i] > num[j]) {
                    dpD[i] = Math.max(dpD[i], dpD[j] + 1);
                }
            }
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(dpD[i] + dpI[i] - 1, max);
        }

        System.out.println(max);
    }
}
