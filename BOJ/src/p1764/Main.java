package p1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다시 풀기

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<String> noSee = new HashSet<>();
        for (int i = 0; i < n; i++) {
            noSee.add(br.readLine());
        }

        Set<String> noHear = new HashSet<>();
        for (int i = 0; i < m; i++) {
            noHear.add(br.readLine());
        }

        List<String> noSeeHear = new ArrayList<>();
        for (String see : noSee) {
            if(noHear.contains(see)){
                noSeeHear.add(see);
            }
        }
        Collections.sort(noSeeHear);
        StringBuilder sb = new StringBuilder();
        for(String a: noSeeHear){
            sb.append(a).append("\n");
        }
        System.out.println(noSeeHear.size());
        System.out.println(sb);
    }
}
