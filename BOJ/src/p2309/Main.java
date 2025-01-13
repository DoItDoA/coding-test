package p2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<Integer> seven = new ArrayList<>();
    private static int[] person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        person = new int[9];
        for (int i = 0; i < 9; i++) {
            person[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(person);

        recur(0);
    }

    private static void recur(int depth) {
        if (depth == 7) {
            int sum = seven.stream().mapToInt(s -> s).sum();
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(seven.get(i));
                }
                System.exit(0);
            } else return;
        }

        for (int i = depth; i < 9; i++) {
            seven.add(person[i]);
            recur(depth + 1);
            seven.remove(seven.size() - 1);
        }
    }
}
