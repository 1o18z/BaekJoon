import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int r, c;
  static Character[][] board;

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  static Queue<Animal> animalQueue;
  static Queue<int[]> waterQueue;

  static int result = Integer.MAX_VALUE;

  static class Animal {

    int x, y, count;

    public Animal(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    board = new Character[r][c];

    animalQueue = new ArrayDeque<>();
    waterQueue = new ArrayDeque<>();

    for (int i = 0; i < r; i++) {
      String value = br.readLine();
      for (int j = 0; j < c; j++) {
        if (value.charAt(j) == 'S') {
          animalQueue.add(new Animal(i, j, 0));
        } else if (value.charAt(j) == '*') {
          waterQueue.add(new int[]{i, j});
        }
        board[i][j] = value.charAt(j);
      }
    }

    while (!animalQueue.isEmpty()) {

      int waterSize = waterQueue.size();

      for (int i = 0; i < waterSize; i++) {
        int[] water = waterQueue.poll();
        int wx = water[0];
        int wy = water[1];

        for (int j = 0; j < 4; j++) {
          int cx = wx + dx[j];
          int cy = wy + dy[j];

          if (cx < 0 || cx >= r || cy < 0 || cy >= c) {
            continue;
          }
          if (board[cx][cy] == '.') {
            board[cx][cy] = '*';
            waterQueue.add(new int[]{cx, cy});
          }
        }
      }

      int animalSize = animalQueue.size();

      for (int i = 0; i < animalSize; i++) {
        Animal animal = animalQueue.poll();
        int px = animal.x;
        int py = animal.y;
        int count = animal.count;

        for (int j = 0; j < 4; j++) {
          int cx = px + dx[j];
          int cy = py + dy[j];

          if (cx < 0 || cx >= r || cy < 0 || cy >= c) {
            continue;
          }
          if (board[cx][cy] == 'D') {
            result = Math.min(result, count + 1);
          } else if (board[cx][cy] == '.') {
            animalQueue.add(new Animal(cx, cy, count + 1));
            board[cx][cy] = 'S';
          }
        }
      }
    }

    System.out.println(result == Integer.MAX_VALUE ? "KAKTUS" : result);
  }
}
