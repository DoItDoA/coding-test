package p1874;
// 좀 어려움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (int i = 0; i < n; i++) {
            int num = i + 1;
            stack.push(num);
            sb.append("+").append("\n");

            while (true) {
                if (stack.isEmpty()) break;

                Integer peek = stack.peek();
                if (peek == arr[k]) {
                    Integer pop = stack.pop();
                    sb.append("-").append("\n");
                    k++;
                } else break;
            }
        }
        System.out.println(stack.isEmpty() ? sb : "NO");
    }
}