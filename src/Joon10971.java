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

    for (int i = 0; i < n; i++) {
      visited[i] = true;
      explore(i, i, 0, 0);
      visited[i] = false;
    }
    
    System.out.println(result);
  }

  private static void explore(int start, int now, int sum, int depth) {
    if (depth == n - 1) {
      if (board[now][start] != 0) {
        sum += board[now][start];
        result = Math.min(result, sum);
      }
      
      return;
    }

    for (int j = 0; j < n; j++) {
      if (!visited[j] && board[now][j] != 0) {
        visited[j] = true;
        explore(start, j, sum + board[now][j], depth + 1);
        visited[j] = false;
      }
    }
  }
}
