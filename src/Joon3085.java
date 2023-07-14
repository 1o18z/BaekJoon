import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    char[][] map = new char[N][N];
    for (int i = 0; i < N; i++) {
      map[i] = scanner.next().toCharArray();
    }

    int result = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (j + 1 < N && map[i][j] != map[i][j + 1]) {
          swapCandy(map, i, j, i, j + 1);
          result = Math.max(result, Math.max(findMaxColumn(map, N), findMaxRow(map, N)));
          swapCandy(map, i, j, i, j + 1);
        }
        if (i + 1 < N && map[i][j] != map[i + 1][j]) {
          swapCandy(map, i, j, i + 1, j);
          result = Math.max(result, Math.max(findMaxColumn(map, N), findMaxRow(map, N)));
          swapCandy(map, i, j, i + 1, j);
        }
      }
    }
    System.out.println(result);
  }

  public static void swapCandy(char[][] map, int r1, int c1, int r2, int c2) {
    char temp = map[r1][c1];
    map[r1][c1] = map[r2][c2];
    map[r2][c2] = temp;
  }

  public static int findMaxRow(char[][] map, int N) {
    int maxLength = 0;
    for (int i = 0; i < N; i++) {
      int length = 1;

      for (int j = 1; j < N; j++) {
        if (map[i][j] == map[i][j - 1]) {
          length++;
        } else {
          maxLength = Math.max(length, maxLength);
          length = 1;
        }
      }
      maxLength = Math.max(length, maxLength);
    }
    return maxLength;
  }

  public static int findMaxColumn(char[][] map, int N) {
    int maxLength = 0;
    for (int i = 0; i < N; i++) {
      int length = 1;

      for (int j = 1; j < map.length; j++) {
        if (map[j][i] == map[j - 1][i]) {
          length++;
        } else {
          maxLength = Math.max(length, maxLength);
          length = 1;
        }
      }
      maxLength = Math.max(length, maxLength);
    }
    return maxLength;
  }

}
