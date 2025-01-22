package p2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean isValid = true;
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == '(' || c == '[') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    isValid = false;
                    break;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    isValid = false;
                    break;
                }
            }
        }

        if (!isValid || s.length == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(recur(s));
    }

    private static int recur(char[] s) {
        if (s.length == 0) return 1;

        Stack<Character> stack = new Stack<>();
        String str = "";
        int sum = 0;
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == '(' || c == '[') {
                stack.add(c);
            } else if (c == ')' || c == ']') {
                stack.pop();
            }
            str += String.valueOf(c);
            if (stack.size() == 0) {
                String subStr = str.substring(1, str.length() - 1);
                if (str.charAt(0) == '(') sum += recur(subStr.toCharArray()) * 2;
                else sum += recur(subStr.toCharArray()) * 3;
                str = "";
            }
        }
        return sum;
    }
}
