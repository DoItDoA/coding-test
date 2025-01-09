package p1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int total = 0;
        while (q.size() > 1) {
            Integer first = q.poll();
            Integer second = q.poll();
            int sum = first + second;
            total += sum;
            q.add(sum);
        }

        System.out.println(total);
    }
}
