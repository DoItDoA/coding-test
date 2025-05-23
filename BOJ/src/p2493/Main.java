package p2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek()[1] >= arr[i]) {
                    sb.append(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0 + " ");
            }
            stack.add(new int[]{i + 1, arr[i]});
        }
        System.out.println(sb);
    }
}
