package Backtracking.p1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int l, c;
    private static List<Character> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        l = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        String[] val = br.readLine().split(" ");
        for (int i = 0; i < c; i++) {
            list.add(val[i].charAt(0));
        }

        Collections.sort(list);
        recur(0, new ArrayList<>());
    }

    private static void recur(int depth, List<Character> basket) {
        if (depth == l) {
            int cntM = 0;
            int cntJ = 0;
            for (char b : basket) {
                if (isVowel(b)) cntM++;
                else cntJ++;
            }
            if (cntM > 0 && cntJ > 1) {
                for (char b : basket) {
                    System.out.print(b);
                }
                System.out.println();
            }
            return;
        }

        for (char a : list) {
            if (basket.size() == 0 || basket.get(basket.size() - 1) < a) {
                basket.add(a);
                recur(depth + 1, basket);
                basket.remove(basket.size() - 1);
            }
        }
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
