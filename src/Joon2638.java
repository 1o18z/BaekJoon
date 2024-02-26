import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] board;
  static boolean[][] visited;
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int n, m, count, result;

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
        int value = Integer.parseInt(st.nextToken());
        board[i][j] = value;
        if (value == 1) {
          count++;
        }
      }
    }

    checkAir(0, 0);

    while (count != 0) {
      visited = new boolean[n][m];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (board[i][j] == 1 && !visited[i][j]) {
            dfs(i, j);
          }
        }
      }

      visited = new boolean[n][m];
      checkAir(0,0);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          board[i][j] = board[i][j] == 3 ? 2 : board[i][j];
        }
      }
      result++;
    }

    System.out.println(result);
  }

  private static void checkAir(int x, int y) {
    visited[x][y] = true;
    board[x][y] = 2;

    for (int i = 0; i < 4; i++) {
      int cx = x + dx[i];
      int cy = y + dy[i];

      if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
        if (!visited[cx][cy] && board[cx][cy] != 1) {
          board[cx][cy] = 2;
          checkAir(cx, cy);
        }
      }
    }
  }

  static void dfs(int x, int y) {
    visited[x][y] = true;

    if (board[x][y] == 1 && isMelt(x, y)) {
      count -= 1;
      board[x][y] = 3;
    }

    for (int i = 0; i < 4; i++) {
      int cx = x + dx[i];
      int cy = y + dy[i];

      if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
        if (!visited[cx][cy] && board[cx][cy] != 0) {
          dfs(cx, cy);
        }
      }
    }
  }

  static boolean isMelt(int x, int y) {
    int air = 0;

    for (int i = 0; i < 4; i++) {
      int cx = x + dx[i];
      int cy = y + dy[i];

      if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
        if (board[cx][cy] == 2) {
          air += 1;
        }
      }
    }
    return air >= 2;
  }
}
