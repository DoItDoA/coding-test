package p20006;

import java.io.*;
import java.util.*;

public class Main {
    private static class Player {
        int level;
        String nick;

        public Player(int level, String nick) {
            this.level = level;
            this.nick = nick;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Player>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nick = st.nextToken();

            if (list.size() == 0) {
                List<Player> room = new ArrayList<>();
                room.add(new Player(level, nick));
                list.add(room);
            } else {
                boolean isNew = true;
                for (List<Player> room : list) {
                    if (room.size() < m && room.get(0).level - 10 <= level && level <= room.get(0).level + 10) {
                        room.add(new Player(level, nick));
                        isNew = false;
                        break;
                    }
                }
                if (isNew) {
                    List<Player> newRoom = new ArrayList<>();
                    newRoom.add(new Player(level, nick));
                    list.add(newRoom);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (List<Player> room : list) {
            if (room.size() == m) sb.append("Started!").append("\n");
            else sb.append("Waiting!").append("\n");

            Collections.sort(room, (a1, a2) -> a1.nick.compareTo(a2.nick));
            for (Player player : room) {
                sb.append(player.level + " " + player.nick).append("\n");
            }
        }
        System.out.println(sb);
    }
}
