import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] lab;
    static int N, M;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int result = 0;

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        createWall(0);
        System.out.println(result);
    }

    static void createWall(int wallCount) { // 벽 세우기
        if (wallCount == 3) {
            countSafeArea();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1; // 벽 세우기
                    createWall(wallCount + 1);
                    lab[i][j] = 0; // 3개 세워서 안전영역 구한 후 세운 벽 다시 되돌리기
                }
            }
        }
    }

    static void countSafeArea() { // 벽이 3개 세워졌을 때 안전영역 구하기
        int[][] cloneLab = new int[N][M]; // 원본 배열 말고 복사된 배열에서 bfs

        for (int i = 0; i < N; i++) {
            cloneLab[i] = Arrays.copyOfRange(lab[i], 0, M);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cloneLab[i][j] == 2) {
                    bfs(cloneLab, i, j);
                }
            }
        }

        int safeAreaCount = 0; // 바이러스 전파 후 남은 안전영역 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cloneLab[i][j] == 0) {
                    safeAreaCount += 1;
                }
            }
        }
        result = Math.max(result, safeAreaCount); // 안전영역 구할 때마다 안전영역 최대값 갱신
    }

    static void bfs(int[][] cloneLab, int y, int x) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(y, x));

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int py = position.y;
            int px = position.x;

            for (int i = 0; i < 4; i++) {
                int cy = py + dy[i];
                int cx = px + dx[i];

                if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                    if (cloneLab[cy][cx] == 0) {
                        cloneLab[cy][cx] = 3; // 감염됐다는 표시
                        queue.offer(new Position(cy, cx));
                    }
                }
            }
        }
    }
  
}
