package p1406;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c : str.toCharArray()) {
            left.add(c);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("L") && !left.isEmpty()) {
                right.add(left.pop());
            } else if (cmd[0].equals("D") && !right.isEmpty()) {
                left.add(right.pop());
            } else if (cmd[0].equals("B") && !left.isEmpty()) {
                left.pop();
            } else if(cmd[0].equals("P")) {
                char c = cmd[1].charAt(0);
                left.push(c);
            }
        }
        while(!left.isEmpty()){
            right.add(left.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
