import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2583 {

    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static int N, M;
    static boolean[][] isVisited;
    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        for (int c = 0; c < testCount; c++) {
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 세로
            M = Integer.parseInt(st.nextToken()); // 가로

            array = new int[N][M];
            isVisited = new boolean[N][M];

            int K = Integer.parseInt(st.nextToken()); // 좌표 개수
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int value = Integer.parseInt(st.nextToken());
                int value1 = Integer.parseInt(st.nextToken());
                array[value][value1] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!isVisited[i][j] && array[i][j] == 1) {
                        count ++;
                        dfs(i, j);

                    }
                }
            }
          
            System.out.println(count);
        }
      
    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;
        array[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int currentX = x + moveX[i];
            int currentY = y + moveY[i];
          
            if (currentX >= 0 && currentX < N && currentY >= 0 && currentY < M) {
                if (!isVisited[currentX][currentY] && array[currentX][currentY] == 1) {
                    dfs(currentX, currentY);
                }
            }
        }
    }
  
}
