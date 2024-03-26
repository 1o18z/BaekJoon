import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int q = Integer.parseInt(br.readLine());
    int[][] board = new int[s.length() + 1][26];

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < 26; j++) {
        board[i][j] = board[i - 1][j];
      }
      board[i][s.charAt(i - 1) - 97] += 1;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < q; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char target = st.nextToken().charAt(0);
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      sb.append(board[end + 1][target - 97] - board[start][target - 97]).append("\n");
    }
    
    System.out.println(sb);
  }
}

