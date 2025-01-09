package p13305;
// 다시 생각
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] roads = new long[n - 1];
        long[] cities = new long[n];

        String[] val = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++) {
            roads[i] = Long.parseLong(val[i]);
        }

        val = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cities[i] = Long.parseLong(val[i]);
        }
        cities[n - 1] = 1;

        long price = 0;
        long min = cities[0];
        for (int i = 0; i < n - 1; i++) {
            if (min > cities[i]) min = cities[i];

            long road = roads[i];
            price += min * road;
        }
        System.out.println(price);
    }
}