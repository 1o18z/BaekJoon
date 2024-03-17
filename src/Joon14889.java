import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[][] board;
  static boolean[] visited;
  static int result = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    board = new int[n][n];
    visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    explore(0, 0);
    System.out.println(result);
  }

  private static void explore(int i, int depth) {
    if (depth == n / 2) {
      calculate();
      return;
    }

    for (int j = i; j < n; j++) {
      if (!visited[j]) {
        visited[j] = true;
        explore(j + 1, depth + 1);
        visited[j] = false;
      }
    }
  }

  private static void calculate() {
    int start = 0;
    int link = 0;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i; j < n; j++) {
        if (visited[i] && visited[j]) {
          start += board[i][j] + board[j][i];
        } else if (!visited[i] && !visited[j]) {
          link += board[i][j] + board[j][i];
        }
      }
    }

    result = Math.min(result, Math.abs(start - link));
  }
}
