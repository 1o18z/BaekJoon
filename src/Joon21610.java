import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static Queue<int[]> cloudQueue;

  static int n, m;
  static int[][] sky;
  static boolean[][] visited;

  static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
  static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    sky = new int[n][n];
    visited = new boolean[n][n];
    cloudQueue = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        sky[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    initialCloud();

    while (m > 0) {
      st = new StringTokenizer(br.readLine());
      int direction = Integer.parseInt(st.nextToken()) - 1;
      int distance = Integer.parseInt(st.nextToken());

      moveClouds(direction, distance);
      checkWater();
      makeCloud();
      m--;
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result += sky[i][j];
      }
    }

    System.out.println(result);
  }

  private static void initialCloud() {
    cloudQueue.add(new int[]{n - 1, 0});
    cloudQueue.add(new int[]{n - 1, 1});
    cloudQueue.add(new int[]{n - 2, 0});
    cloudQueue.add(new int[]{n - 2, 1});
  }

  private static void moveClouds(int direction, int distance) {
    for (int[] cloud : cloudQueue) {
      cloud[0] = (cloud[0] + (distance % n) * dx[direction] + n) % n;
      cloud[1] = (cloud[1] + (distance % n) * dy[direction] + n) % n;
      sky[cloud[0]][cloud[1]] += 1;
    }
  }

  private static void checkWater() {
    while (!cloudQueue.isEmpty()) {
      int[] cloud = cloudQueue.poll();
      visited[cloud[0]][cloud[1]] = true;

      for (int i = 1; i < 8; i += 2) {
        int cx = cloud[0] + dx[i];
        int cy = cloud[1] + dy[i];

        if (cy >= 0 && cy < n && cx >= 0 && cx < n && sky[cx][cy] != 0) {
          sky[cloud[0]][cloud[1]] += 1;
        }
      }
    }
  }

  private static void makeCloud() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (sky[i][j] >= 2 && !visited[i][j]) {
          sky[i][j] -= 2;
          cloudQueue.add(new int[]{i, j});
        }
      }
    }
    
    visited = new boolean[n][n];
  }
}
