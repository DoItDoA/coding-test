package p17615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] colors = br.readLine().toCharArray();

        int countR = 0;
        for (char c : colors) if (c == 'R') countR++;
        int countB = n - countR;

        int leftR = 0;
        int leftB = 0;
        int rightR = 0;
        int rightB = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && colors[j] == 'R') leftR++;
                else if (i == 1 && colors[j] == 'B') leftB++;
                else if (i == 2 && colors[n - 1 - j] == 'R') rightR++;
                else if (i == 3 && colors[n - 1 - j] == 'B') rightB++;
                else break;
            }
        }

        int min = Math.min(countR - leftR, Math.min(countR - rightR, Math.min(countB - leftB, countB - rightB)));
        System.out.println(min);
    }
}
