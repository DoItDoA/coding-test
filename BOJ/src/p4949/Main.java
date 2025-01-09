package p4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) break;

            String result = "yes";
            int[] balance = new int[4];
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '(') {
                    balance[0]++;
                    stack.add(')');
                } else if (c == ')') {
                    balance[1]++;

                } else if (c == '[') {
                    balance[2]++;
                    stack.add(']');
                } else if (c == ']') {
                    balance[3]++;

                }
                if (balance[1] > balance[0] || balance[3] > balance[2]) {
                    result = "no";
                    break;
                }

                if (c == ')' && stack.pop() != ')') {
                    result = "no";
                    break;
                } else if (c == ']' && stack.pop() != ']') {
                    result = "no";
                    break;
                }
            }
            if (!(balance[1] == balance[0] && balance[3] == balance[2])) {
                result = "no";
            }
            System.out.println(result);
        }
    }
}
