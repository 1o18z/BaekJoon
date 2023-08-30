import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] moveY = {1, 1, 0, -1, -1, -1, 0, 1}; // Y, N
    static int[] moveX = {0, 1, 1, 1, 0, -1, -1, -1}; // X, M
    static int N, M;
    static boolean[][] isVisited;
    static int[][] array;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        array = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == 0) {
                    result = Math.max(result, bfs(i, j));
                }
            }
        }
        System.out.println(result);
    }

    static int bfs(int y, int x) {
        isVisited = new boolean[N][M];

        class Position {
            int y;
            int x;
            int count;

            public Position(int y, int x, int count) {
                this.y = y;
                this.x = x;
                this.count = count;
            }
        }

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(y, x, 0));
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {

            Position position = queue.poll();
            int positionY = position.y;
            int positionX = position.x;

            for (int i = 0; i < 8; i++) {

                int currentY = positionY + moveY[i];
                int currentX = positionX + moveX[i];

                if (currentX >= 0 && currentX < M && currentY >= 0 && currentY < N && !isVisited[currentY][currentX]) {
                    if (array[currentY][currentX] == 0) {
                        queue.offer(new Position(currentY, currentX, position.count + 1));
                        isVisited[currentY][currentX] = true;
                    } else {
                        return position.count + 1;
                    }
                }
            }
        }
        return result;
    }
}
