package p10828;
// 매우 쉬움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("push")) stack.push(Integer.parseInt(s[1]));
            else if (s[0].equals("pop")) {
                if (stack.empty()) System.out.println(-1);
                else System.out.println(stack.pop());
            } else if (s[0].equals("size")) System.out.println(stack.size());
            else if (s[0].equals("empty")) System.out.println(stack.empty() ? 1 : 0);
            else if (s[0].equals("top")) {
                if (stack.empty()) System.out.println(-1);
                else System.out.println(stack.peek());
            }
        }
    }
}
