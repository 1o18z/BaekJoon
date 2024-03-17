import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[] board;
  static int[] lotto;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      board = new int[n];
      lotto = new int[6];
      visited = new boolean[n];

      if (n == 0) {
        break;
      }
      
      for (int i = 0; i < n; i++) {
        board[i] = Integer.parseInt(st.nextToken());
      }

      explore(0, 0);
      System.out.println();
    }
  }

  private static void explore(int depth, int start) {
    if (depth == 6) {
      for (int i = 0; i < 6; i++) {
        System.out.print(lotto[i] + " ");
      }
      
      System.out.println();
      return;
    }

    for (int i = start; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        lotto[depth] = board[i];
        explore(depth + 1, i + 1);
        visited[i] = false;
      }
    }
  }
}
