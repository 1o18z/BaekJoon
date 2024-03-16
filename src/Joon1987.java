import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int r, c;
  static Character[][] board;

  static List<Character> list = new ArrayList<>();

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static int result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    board = new Character[r][c];

    for (int i = 0; i < r; i++) {
      String value = br.readLine();
      for (int j = 0; j < c; j++) {
        board[i][j] = value.charAt(j);
      }
    }

    move(0, 0, 0);

    System.out.println(result);
  }

  private static void move(int i, int j, int count) {
    if (list.contains(board[i][j])) {
      result = Math.max(result, count);
      return;
    }

    list.add(board[i][j]);

    for (int k = 0; k < 4; k++) {
      int cx = i + dx[k];
      int cy = j + dy[k];

      if (cx < 0 || cx >= r || cy < 0 || cy >= c) {
        continue;
      }
      
      move(cx, cy, count + 1);
    }
    
    list.remove(board[i][j]);
  }
}
