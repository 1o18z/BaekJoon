import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] board = new int[10001];
    
    board[1] = 1;
    board[2] = 2;
    board[3] = 3;

    for (int i = 4; i <= n; i++) {
      board[i] = (board[i - 1] + board[i - 2])%10007;
    }

    System.out.println(board[n]);
  }
}
