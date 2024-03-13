import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, k;
  static boolean[] visited;
  static int level = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    int[] board = new int[n * 2];
    visited = new boolean[n * 2];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n * 2; i++) {
      board[i] = Integer.parseInt(st.nextToken());
    }

    while (true) {
      level++;
      rotateBelt(board);
      setRobot(board);

      if (isMeet(board)) {
        break;
      }
    }

    System.out.println(level);
  }

  private static void rotateBelt(int[] board) {
    int value = board[n * 2 - 1];

    for (int i = n * 2 - 1; i > 0; i--) {
      board[i] = board[i - 1];
    }
    board[0] = value;

    for (int i = n - 1; i > 0; i--) {
      visited[i] = visited[i - 1];
    }

    visited[0] = false;
    visited[n - 1] = false;
  }

  private static void setRobot(int[] board) {
    for (int i = n - 1; i > 0; i--) {
      if (visited[i - 1] && !visited[i] && board[i] >= 1) {
        board[i] -= 1;
        visited[i - 1] = false;
        visited[i] = true;
      }
    }
    visited[n - 1] = false;

    if (board[0] >= 1) {
      visited[0] = true;
      board[0] -= 1;
    }
  }

  private static boolean isMeet(int[] board) {
    int count = 0;
    for (int i = 0; i < n * 2; i++) {
      if (board[i] == 0) {
        count++;
      }
    }

    return count >= k;
  }
}
