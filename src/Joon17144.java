import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int r, c, t;
  static int[][] board;

  static int[] dx = {0, -1, 0, 1};
  static int[] dy = {1, 0, -1, 0};

  static Queue<Dust> queue;

  static int upCleaner;
  static int downCleaner;

  static class Dust {

    int x;
    int y;
    int value;

    public Dust(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());

    board = new int[r][c];

    for (int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < c; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < r; i++) {
      if (board[i][0] == -1) {
        upCleaner = i;
        downCleaner = i + 1;
        break;
      }
    }

    while (t-- > 0) {
      checkDust();
      spread();
      clean();
    }

    System.out.println(getResult());
  }

  private static void checkDust() {
    queue = new ArrayDeque<>();

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (board[i][j] == -1 || board[i][j] == 0 || board[i][j] < 5) {
          continue;
        }

        queue.add(new Dust(i, j, board[i][j]));
      }
    }
  }

  private static void spread() {
    while (!queue.isEmpty()) {
      Dust dust = queue.poll();
      int spreadCount = 0;
      int amount = dust.value / 5;

      for (int k = 0; k < 4; k++) {
        int cx = dust.x + dx[k];
        int cy = dust.y + dy[k];

        if (cx < 0 || cx >= r || cy < 0 || cy >= c || board[cx][cy] == -1) {
          continue;
        }
        board[cx][cy] += amount;
        spreadCount++;
      }

      board[dust.x][dust.y] -= amount * spreadCount;
    }
  }

  private static void clean() {
    cleanUp();
    cleanDown();
  }

  private static void cleanUp() {
    int up = upCleaner;

    for (int i = up - 1; i > 0; i--) {
      board[i][0] = board[i - 1][0];
    }

    for (int i = 0; i < c - 1; i++) {
      board[0][i] = board[0][i + 1];
    }

    for (int i = 0; i < up; i++) {
      board[i][c - 1] = board[i + 1][c - 1];
    }

    for (int i = c - 1; i > 1; i--) {
      board[up][i] = board[up][i - 1];
    }

    board[up][1] = 0;
  }

  private static void cleanDown() {
    int down = downCleaner;

    for (int i = down + 1; i < r - 1; i++) {
      board[i][0] = board[i + 1][0];
    }

    for (int i = 0; i < c - 1; i++) {
      board[r - 1][i] = board[r - 1][i + 1];
    }

    for (int i = r - 1; i > down; i--) {
      board[i][c - 1] = board[i - 1][c - 1];
    }

    for (int i = c - 1; i > 1; i--) {
      board[down][i] = board[down][i - 1];
    }

    board[down][1] = 0;
  }

  private static int getResult() {
    int sum = 2; // 공기청정기 제외
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        sum += board[i][j];
      }
    }

    return sum;
  }
}
