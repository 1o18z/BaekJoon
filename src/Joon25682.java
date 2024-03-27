import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] board = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      String[] value = br.readLine().split("");
      for (int j = 1; j <= m; j++) {
        board[i][j] = value[j - 1].equals("B") ? 1 : 0;
      }
    }

    int[][] blackBoard = new int[n + 1][m + 1];
    int[][] whiteBoard = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if ((i + j) % 2 == 0) {
          blackBoard[i][j] = (board[i][j] == 1) ? 0 : 1;
          whiteBoard[i][j] = (board[i][j] == 0) ? 0 : 1;
        } else {
          whiteBoard[i][j] = (board[i][j] == 1) ? 0 : 1;
          blackBoard[i][j] = (board[i][j] == 0) ? 0 : 1;
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        blackBoard[i][j] += blackBoard[i - 1][j] + blackBoard[i][j - 1] - blackBoard[i - 1][j - 1];
        whiteBoard[i][j] += whiteBoard[i - 1][j] + whiteBoard[i][j - 1] - whiteBoard[i - 1][j - 1];
      }
    }

    int result = Integer.MAX_VALUE;
    for (int i = 1; i <= n - k + 1; i++) {
      for (int j = 1; j <= m - k + 1; j++) {
        int blackValue =
            blackBoard[i + k - 1][j + k - 1] - blackBoard[i + k - 1][j - 1] - blackBoard[i - 1][
                j + k - 1]
                + blackBoard[i - 1][j - 1];
        int whiteValue =
            whiteBoard[i + k - 1][j + k - 1] - whiteBoard[i + k - 1][j - 1] - whiteBoard[i - 1][
                j + k - 1]
                + whiteBoard[i - 1][j - 1];
        result = Math.min(result, (Math.min(blackValue, whiteValue)));
      }
    }

    System.out.println(result);
  }
}
