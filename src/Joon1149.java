import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[][] board;
  static int[][] priceBoard;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    board = new int[n][3];
    priceBoard = new int[n][3];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    priceBoard[0][0] = board[0][0];
    priceBoard[0][1] = board[0][1];
    priceBoard[0][2] = board[0][2];

    int red = dp(n - 1, 0);
    int green = dp(n - 1, 1);
    int blue = dp(n - 1, 2);

    System.out.println(Math.min(Math.min(red, green), blue));
  }

  private static int dp(int index, int color) {
    if (priceBoard[index][color] == 0) {
      switch (color) {
        case 0:
          priceBoard[index][0] = Math.min(dp(index - 1, 1), dp(index - 1, 2)) + board[index][0];
        case 1:
          priceBoard[index][1] = Math.min(dp(index - 1, 0), dp(index - 1, 2)) + board[index][1];
        case 2:
          priceBoard[index][2] = Math.min(dp(index - 1, 0), dp(index - 1, 1)) + board[index][2];
      }
    }

    return priceBoard[index][color];
  }
}
