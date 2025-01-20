package p10845;
// 쉬움
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int lastNum = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            switch (s[0]) {
                case "push":
                    lastNum = Integer.parseInt(s[1]);
                    q.add(lastNum);
                    break;
                case "pop":
                    if (q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.poll());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if (q.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if (q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.peek());
                    break;
                case "back":
                    if (q.isEmpty()) System.out.println(-1);
                    else System.out.println(lastNum);
                    break;
            }
        }
    }
}
