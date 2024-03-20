import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int n, m;
  static int[] board;
  static int[] arr;
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    board = new int[n];
    arr = new int[m];
    visited = new boolean[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(board);
    explore(0);
    System.out.println(sb);
  }

  private static void explore(int depth) {
    if (depth == m) {
      for (int i = 0; i < m; i++) {
        sb.append(arr[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = board[i];
        explore(depth + 1);
        visited[i] = false;
      }
    }
  }
}
