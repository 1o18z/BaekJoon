import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  static int n, m;
  static int[] board;
  static boolean[] visited;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[m];
    visited = new boolean[n];
    sb = new StringBuilder();

    explore(0);
    System.out.println(sb);
  }

  private static void explore(int k) {
    if (k == m) {
      for (int i = 0; i < m; i++) {
        sb.append(board[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        board[k] = i + 1;
        visited[i] = true;
        explore(k + 1);
        visited[i] = false;
      }
    }
  }
}
