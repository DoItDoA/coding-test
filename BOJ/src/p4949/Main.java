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
            if (!isValid(input)) result = "no";

            System.out.println(result);
        }
    }


    private static boolean isValid(String input) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[') {
                s.add(c);
            } else if (c == ')') {
                if (s.isEmpty() || s.pop() != '(') return false;
            } else if (c == ']') {
                if (s.isEmpty() || s.pop() != '[') return false;
            }
        }
        return s.isEmpty();
    }
}

