import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, m;
  static int r, c, d;
  static int[][] room;

  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  static int result = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    room = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        room[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    room[r][c] = 2;
    clean(r, c, d);
    
    System.out.println(result);
  }

  private static void clean(int i, int j, int direction) {
    if (room[i][j] == 0) {
      room[i][j] = 2;
      result++;
    }

    for (int k = 0; k < 4; k++) {
      direction = (direction + 3) % 4;
      int cx = i + dx[direction];
      int cy = j + dy[direction];

      if (cx >= 0 && cx < n && cy >= 0 && cy < m && room[cx][cy] == 0) {
        clean(cx, cy, direction);
        return;
      }
    }

    int md = (direction + 2) % 4;
    int mx = i + dx[md];
    int my = j + dy[md];

    if (mx >= 0 && mx < n && my >= 0 && my < m && room[mx][my] != 1) {
      clean(mx, my, direction);
    }
  }
}
