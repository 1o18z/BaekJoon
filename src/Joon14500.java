import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, m;
  static int[][] board;
  static boolean[][] visited;
  static int result = 0;

  private static int[] dx = {0, 0, 1, -1};
  private static int[] dy = {-1, 1, 0, 0};

  private static int[][] sx = {{0, 0, 0, 1}, {0, 1, 2, 1}, {0, 0, 0, -1}, {0, -1, 0, 1}};
  private static int[][] sy = {{0, 1, 2, 1}, {0, 0, 0, 1}, {0, 1, 2, 1}, {0, 1, 1, 1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        visited[i][j] = true;
        dfs(i, j, 0, board[i][j]);
        visited[i][j] = false;
        checkSpecialShape(i, j);
      }
    }
    
    System.out.println(result);
  }

  private static void checkSpecialShape(int i, int j) {
    for (int k = 0; k < 4; k++) {
      int sum = 0;
      boolean isPossible = true;

      for (int l = 0; l < 4; l++) {
        int cx = i + sx[k][l];
        int cy = j + sy[k][l];

        if (cx < 0 || cx >= n || cy < 0 || cy >= m) {
          isPossible = false;
          continue;
        }
        sum += board[cx][cy];
      }
      
      if (isPossible) {
        result = Math.max(result, sum);
      }
    }
  }

  private static void dfs(int i, int j, int depth, int sum) {
    if (depth >= 3) {
      result = Math.max(result, sum);
      return;
    }

    for (int k = 0; k < 4; k++) {
      int cx = i + dx[k];
      int cy = j + dy[k];

      if (cx >= 0 && cx < n && cy >= 0 && cy < m && !visited[cx][cy]) {
        visited[cx][cy] = true;
        dfs(cx, cy, depth + 1, sum + board[cx][cy]);
        visited[cx][cy] = false;
      }
    }
  }
}
