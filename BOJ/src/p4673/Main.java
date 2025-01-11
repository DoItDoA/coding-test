package p4673;


import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        int[] num = new int[10000];
        for (int i = 0; i < 10000; i++) {
            num[i] = i + 1;
        }

        for (int i = 0; i < 10000; i++) {
            if (num[i] != 0) {
                int n = num[i];

                String str = n + "";
                int sum = n;
                while (true) {
                    for (int j = 0; j < str.length(); j++) {
                        sum += Integer.parseInt(String.valueOf(str.charAt(j)));
                    }
                    if (sum <= 10000) {
                        num[sum - 1] = 0;
                        str = sum + "";
                    } else break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            if (num[i] != 0) {
                sb.append(num[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
