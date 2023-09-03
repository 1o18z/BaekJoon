import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] tomato;
    static int X, Y, Z;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static Queue<Position> queue = new LinkedList<>();

    static class Position {
        int z;
        int y;
        int x;

        public Position(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        tomato = new int[Z][Y][X];

        for (int k = 0; k < Z; k++) {
            for (int i = 0; i < Y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < X; j++) {
                    tomato[k][i][j] = Integer.parseInt(st.nextToken());
                    if (tomato[k][i][j] == 1) {
                        queue.offer(new Position(k, i, j));
                    }
                }
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            Position position = queue.poll(); //  하나 꺼내서
            int pz = position.z;
            int py = position.y;
            int px = position.x;

            for (int i = 0; i < 6; i++) {
                int cz = pz + dz[i];
                int cy = py + dy[i];
                int cx = px + dx[i];

                if (cx >= 0 && cy >= 0 && cz >= 0 && cx < X && cy < Y && cz < Z) {
                    if (tomato[cz][cy][cx] == 0) {
                        tomato[cz][cy][cx] = tomato[pz][py][px] + 1;
                        queue.offer(new Position(cz, cy, cx));
                    }
                }
            }
        }

        int max = 0;
        for (int k = 0; k < Z; k++) {
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if (tomato[k][i][j] == 0) {
                        return -1;
                    }
                    max = Math.max(max, tomato[k][i][j]);
                }
            }
        }
        return max - 1;
    }

}
