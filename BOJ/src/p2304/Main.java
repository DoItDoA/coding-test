package p2304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int maxV = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a1, a2) -> a1[0] - a2[0]);

        for (int i = 0; i < n; i++) {
            if (arr[i][1] > maxV) {
                maxV = arr[i][1];
                maxIdx = i;
            }
        }


        int square = 0;
        int leftV = arr[0][1];
        int leftH = arr[0][0];
        for (int i = 1; i <= maxIdx; i++) {
            if (leftV <= arr[i][1]) {
                square += (arr[i][0] - leftH) * leftV;
                leftV = arr[i][1];
                leftH = arr[i][0];
            }
        }

        int rightV = arr[n - 1][1];
        int rightH = arr[n - 1][0];
        for (int i = n - 2; i >= maxIdx; i--) {
            if (rightV <= arr[i][1]) {
                int i1 = (rightH - arr[i][0]) * rightV;
                square += i1;
                rightV = arr[i][1];
                rightH = arr[i][0];
            }
        }

        System.out.println(maxV + square);

    }
}
