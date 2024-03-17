import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, s;
  static int[] board;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());

    board = new int[n];
    
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }

    explore(0, 0);
    System.out.println(s == 0 ? count - 1 : count);
  }

  private static void explore(int k, int sum) {
    if (k == n) {
      if (sum == s) {
        count++;
      }
      return;
    }

    explore(k + 1, sum + board[k]);
    explore(k + 1, sum);
  }
}
