import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

  static String[][] board;
  static boolean[][] visited;

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static int level = 0;
  static boolean isProgress = false;

  static class Position {

    int x, y;

    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    board = new String[12][6];

    for (int i = 0; i < 12; i++) {
      String[] values = br.readLine().split("");
      System.arraycopy(values, 0, board[i], 0, 6);
    }

    while (true) {
      isProgress = false;
      bfs();
      down();

      if (!isProgress) {
        break;
      }

      level++;
    }

    System.out.println(level);
  }

  private static void bfs() {
    Queue<Position> queue = new ArrayDeque<>();
    visited = new boolean[12][6];

    for (int k = 0; k < 12; k++) {
      for (int l = 0; l < 6; l++) {
        if (!board[k][l].equals(".") && !visited[k][l]) {
          List<Position> list = new ArrayList<>();
          queue.add(new Position(k, l));
          list.add(new Position(k, l));

          visited[k][l] = true;

          while (!queue.isEmpty()) {
            Position position = queue.poll();
            int px = position.x;
            int py = position.y;

            for (int m = 0; m < 4; m++) {
              int cx = px + dx[m];
              int cy = py + dy[m];

              if (cx >= 0 && cx < 12 && cy >= 0 && cy < 6) {
                if (board[cx][cy].equals(board[px][py]) && !visited[cx][cy]) {
                  queue.add(new Position(cx, cy));
                  list.add(new Position(cx, cy));
                  visited[cx][cy] = true;
                }
              }
            }
          }

          pop(list);
        }
      }
    }
  }

  private static void pop(List<Position> list) {
    if (list.size() >= 4) {
      for (Position position : list) {
        board[position.x][position.y] = ".";
        isProgress = true;
      }
    }
  }

  private static void down() {
    for (int i = 0; i < 6; i++) {
      Queue<String> queue = new ArrayDeque<>();

      for (int j = 11; j >= 0; j--) {
        if (!board[j][i].equals(".")) {
          queue.add(board[j][i]);
          board[j][i] = ".";
        }
      }

      int index = 11;
      while (!queue.isEmpty()) {
        board[index][i] = queue.poll();
        index--;
      }
    }
  }
}
