import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] array;
    static int M, N;
    static int count = 1;
    static boolean[][] isVisited;
    static int[] locationX = {0, 1, 0, -1};
    static int[] locationY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        array = new int[M][N];
        isVisited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String[] split = new StringTokenizer(br.readLine()).nextToken().split("");
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        class Position {
            int x;
            int y;
            int count;

            public Position(int x, int y, int count) {
                this.x = x;
                this.y = y;
                this.count = count;
            }
        }

        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y, count));
        array[x][y] = 0;
        isVisited[x][y] = true;

        while (!q.isEmpty()) {
            Position position = q.poll();
            int result = position.count;

            if (position.x == M - 1 && position.y == N - 1) {
                return result;
            }

            int xx = position.x;
            int yy = position.y;

            for (int i = 0; i < 4; i++) {
                int currentX = xx + locationX[i];
                int currentY = yy + locationY[i];

                if (currentX >= 0 && currentX < M && currentY >= 0 && currentY < N && array[currentX][currentY] == 1 && !isVisited[currentX][currentY]) {
                    q.offer(new Position(currentX, currentY, result + 1));
                    isVisited[currentX][currentY] = true;
                }
                array[xx][yy] = 0;
            }
        }
        return count;
    }

}
