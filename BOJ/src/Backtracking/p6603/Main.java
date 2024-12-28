package Backtracking.p6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<List<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] val = br.readLine().split(" ");
            int n = Integer.parseInt(val[0]);
            if (n == 0) break;

            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(Integer.parseInt(val[i]));
            }
            map.add(list);
        }

        for (int i = 0; i < map.size(); i++) {
            recur(map.get(i), 0, new ArrayList<>());
            System.out.println();
        }
    }

    static void recur(List<Integer> list, int depth, List<Integer> basket) {
        if (depth == 6) {
            for (int num : basket) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int num : list) {
            if (basket.size() == 0 || basket.get(basket.size() - 1) < num) {
                basket.add(num);
                recur(list, depth + 1, basket);
                basket.remove(basket.size() - 1);
            }
        }
    }
}

