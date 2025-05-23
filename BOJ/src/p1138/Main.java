package p1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] rs = new int[n];
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            for (int j = 0; j < n; j++) {
                if (num == 0) {
                    if (rs[j] != 0) continue;
                    rs[j] = i + 1;
                    break;
                }
                if (num > 0 && rs[j] == 0) num--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int r : rs) sb.append(r + " ");
        System.out.println(sb);
    }
}
