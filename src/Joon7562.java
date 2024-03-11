import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int m;
  static int[][] board;
  static boolean[][] visited;

  static int endX, endY;

  static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
  static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

  static class Position {

    int x;
    int y;
    int count;

    public Position(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    while (n-- > 0) {
      m = Integer.parseInt(br.readLine());
      board = new int[m][m];
      visited = new boolean[m][m];

      StringTokenizer st = new StringTokenizer(br.readLine());
      int startX = Integer.parseInt(st.nextToken());
      int startY = Integer.parseInt(st.nextToken());
      Position start = new Position(startX, startY, 0);

      st = new StringTokenizer(br.readLine());
      endX = Integer.parseInt(st.nextToken());
      endY = Integer.parseInt(st.nextToken());

      bfs(start);
    }
  }

  private static void bfs(Position position) {
    Queue<Position> queue = new ArrayDeque<>();
    queue.add(position);
    visited[position.x][position.y] = true;

    while (!queue.isEmpty()) {
      Position current = queue.poll();
      int cx = current.x;
      int cy = current.y;
      int count = current.count;

      if (cx == endX && cy == endY) {
        System.out.println(count);
        return;
      }

      for (int k = 0; k < 8; k++) {
        int mx = cx + dx[k];
        int my = cy + dy[k];

        if (mx >= 0 && mx < m && my >= 0 && my < m && !visited[mx][my]) {
          queue.add(new Position(mx, my, count + 1));
          visited[mx][my] = true;
        }
      }
    }
  }
}
