import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] lab;
    static int N, S;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Queue<Position> queue = new LinkedList<>();

    static class Position {
        int y;
        int x;
        int time;
        int virus;

        public Position(int y, int x, int time, int virus) {
            this.y = y;
            this.x = x;
            this.time = time;
            this.virus = virus;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Position> list = new ArrayList<>();

        N = Integer.parseInt(st.nextToken()); // 세로
        int K = Integer.parseInt(st.nextToken()); // 가로

        lab = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] != 0) {
                    list.add(new Position(i, j, 0, lab[i][j])); // 위치, 시간, 1
                }
            }
        }

        list.sort(Comparator.comparingInt(o -> o.virus));

        for (Position position : list) {
            queue.offer(position);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // 초
        int X = Integer.parseInt(st.nextToken()); // X위치
        int Y = Integer.parseInt(st.nextToken()); // Y위치

        bfs();
        System.out.println(lab[X-1][Y-1]);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int py = position.y;
            int px = position.x;
            int pTime = position.time;
            int pVirus = position.virus;

            if (pTime == S) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int cy = py + dy[i];
                int cx = px + dx[i];

                if (cx >= 0 && cy >= 0 && cx < N && cy < N) {
                    if (lab[cy][cx] == 0) {
                        lab[cy][cx] = pVirus;
                        queue.offer(new Position(cy, cx, pTime + 1, pVirus));
                    }
                }
            }
        }
    }

}
