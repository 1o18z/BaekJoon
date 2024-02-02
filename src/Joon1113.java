import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static int N, M, maxHeight, result;
  static int[][] arr;
  static boolean[][] visited;

  static class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N][M];

    for (int i = 0; i < N; i++) {
      String value = br.readLine();

      for (int j = 0; j < M; j++) {
        arr[i][j] = value.charAt(j) - '0';
        maxHeight = Math.max(maxHeight, arr[i][j]);
      }
    }

    result = 0;

    for (int i = 1; i < maxHeight; i++) {
      for (int j = 1; j < N - 1; j++) {
        for (int k = 1; k < M - 1; k++) {
          if (arr[j][k] == i) {
            result += bfs(j, k);
          }
        }
      }
    }

    System.out.println(result);
  }

  public static int bfs(int x, int y) {
    visited = new boolean[N][M];
    visited[x][y] = true;

    Deque<Position> queue = new ArrayDeque<>();
    List<Position> list = new ArrayList<>();

    queue.offer(new Position(x, y));
    list.add(new Position(x, y));

    while (!queue.isEmpty()) {
      Position position = queue.poll();
      x = position.x;
      y = position.y;

      for (int i = 0; i < 4; i++) {
        int cx = x + dx[i];
        int cy = y + dy[i];

        if (cx >= 0 && cx < N && cy >= 0 && cy < M) {
          if (!visited[cx][cy] && arr[x][y] >= arr[cx][cy]) {
            visited[cx][cy] = true;

            if (cx == 0 || cy == 0 || cx == N - 1 || cy == M - 1) {
              return 0;
            }

            queue.offer(new Position(cx, cy));
            list.add(new Position(cx, cy));
          }
        }
      }
    }

    for (Position position : list) {
      arr[position.x][position.y] += 1;
    }

    return list.size();
  }
}
