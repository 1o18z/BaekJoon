import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int n;
  static int[] board;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    board = new int[n];

    explore(0);
    System.out.println(count);
  }

  private static void explore(int depth) {
    if (depth == n) {
      count++;
      return;
    }
    
    for (int i = 0; i < n; i++) {
      board[depth] = i;

      if (isPossible(depth)) {
        explore(depth + 1);
      }
    }
  }

  private static boolean isPossible(int k) {
    for (int i = 0; i < k; i++) {
      if (board[k] == board[i] || Math.abs(board[k] - board[i]) == Math.abs(k - i)) {
        return false;
      }
    }
    
    return true;
  }
}
