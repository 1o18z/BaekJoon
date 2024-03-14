import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, k;
  static int[][] board;
  static boolean[][] visited;

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static int level, remainCheese;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    board = new int[n][k];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < k; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (true) {
      visited = new boolean[n][k];
      remainCheese = 0;
      level++;

      dfs(0, 0);

      int count = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < k; j++) {
          if (board[i][j] == 2) {
            board[i][j] = 0;
            remainCheese++;
          }
          if (board[i][j] == 1) {
            count++;
          }
        }
      }

      if (count == 0) {
        break;
      }
    }

    System.out.println(level);
    System.out.println(remainCheese);
  }

  private static void dfs(int i, int j) {
    for (int l = 0; l < 4; l++) {
      int cx = i + dx[l];
      int cy = j + dy[l];

      if (cx >= 0 && cx < n && cy >= 0 && cy < k && !visited[cx][cy]) {
        visited[cx][cy] = true;

        if (board[cx][cy] == 1) {
          board[cx][cy] = 2;
        } else {
          dfs(cx, cy);
        }
      }
    }
  }
}
