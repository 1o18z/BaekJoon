import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] tomato;
    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Position> queue = new LinkedList<>();

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        tomato = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.offer(new Position(i, j));
                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            Position position = queue.poll(); //  하나 꺼내서
            int px = position.x;
            int py = position.y;

            for (int i = 0; i < 4; i++) {
                int cy = py + dy[i];
                int cx = px + dx[i];

                if (cx >= 0 && cy >= 0 && cx < N && cy < M) {
                    if (tomato[cx][cy] == 0) {
                        tomato[cx][cy] = tomato[px][py] + 1;
                        queue.offer(new Position(cx, cy));
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, tomato[i][j]);
            }
        }
        return max - 1;
    }
    
}
