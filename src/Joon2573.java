import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[][] sea;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sea = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sea[i][j] = sc.nextInt();
            }
        }

        int count = seperate();
        int result = 0;
      
        while (count < 2) {
            if (count == 0) {
                result = 0;
                break;
            }
          
            bfs();
            result++;
            count = seperate();
        }

        System.out.println(result);
    }

    static int seperate() {
        boolean[][] visited = new boolean[n][m];

        int count = 0; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sea[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }
      
        return count;
    }

    static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true; 

        for (int i = 0; i < 4; i++) {
            int currentX = x + moveX[i];
            int currentY = y + moveY[i];

            if (currentX >= 0 && currentX < n && currentY >= 0 && currentY < m) {
                if (sea[currentX][currentY] != 0 && !visited[currentX][currentY]) {
                    dfs(currentX, currentY, visited);
                }
            }
        }
    }

    static void bfs() {
        int[][] melting = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sea[i][j] != 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] target = queue.poll();
            int count = 0;
          
            for (int i = 0; i < 4; i++) {
                int currentX = moveX[i] + target[0];
                int currentY = moveY[i] + target[1];

                if (currentX >= 0 && currentX < n && currentY >= 0 && currentY < m) {
                    if (sea[currentX][currentY] == 0) {
                        count++;
                    }
                }
              
                melting[target[0]][target[1]] = sea[target[0]][target[1]] - count;
                melting[target[0]][target[1]] = Math.max(0, melting[target[0]][target[1]]);
            }
        }
      
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sea[i][j] = melting[i][j];
            }
        }
    }
}
