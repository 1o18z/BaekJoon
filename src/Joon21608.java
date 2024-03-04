import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[][] board;
  static Map<Integer, Student> students;

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static int result = 0;

  static class Student {

    int number;
    List<Integer> friends = new ArrayList<>();

    public Student(int number, int a, int b, int c, int d) {
      this.number = number;
      friends.add(a);
      friends.add(b);
      friends.add(c);
      friends.add(d);
    }
  }

  static class Seat {

    int friendCount;
    int blankCount;
    int x;
    int y;

    public Seat(int friendCount, int blankCount, int x, int y) {
      this.friendCount = friendCount;
      this.blankCount = blankCount;
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    students = new HashMap<>();
    board = new int[n][n];

    for (int i = 0; i < n * n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int number = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      students.put(number, new Student(number, a, b, c, d));
      sitStudent(number);
    }

    counting();
    System.out.println(result);
  }

  private static void sitStudent(int number) {
    List<Seat> seatList = new ArrayList<>();
    checkSeat(number, seatList);
    sort(seatList);
    sit(number, seatList);
  }

  private static void checkSeat(int number, List<Seat> seatList) {
    Student student = students.get(number);
    List<Integer> friends = student.friends;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int friendCount = 0;
        int blankCount = 0;

        for (int k = 0; k < 4; k++) {
          int cx = i + dx[k];
          int cy = j + dy[k];

          if (cx >= 0 && cy >= 0 && cx < n && cy < n) {
            if (board[cx][cy] == 0) {
              blankCount++;
            }
            if (friends.contains(board[cx][cy])) {
              friendCount++;
            }
          }
        }

        seatList.add(new Seat(friendCount, blankCount, i, j));
      }
    }
  }

  private static void sort(List<Seat> seatList) {
    seatList.sort((o1, o2) -> {
      if (o1.friendCount == o2.friendCount) {
        if (o1.blankCount == o2.blankCount) {
          if (o1.x == o2.x) {
            return o2.y - o1.y;
          }
          return o2.x - o1.x;
        }
        return o2.blankCount - o1.blankCount;
      }
      return o2.friendCount - o1.friendCount;
    });
  }

  private static void counting() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int count = 0;
        Student student = students.get(board[i][j]);

        for (int k = 0; k < 4; k++) {
          int cx = i + dx[k];
          int cy = j + dy[k];

          if (cx >= 0 && cy >= 0 && cx < n && cy < n) {
            if (student.friends.contains(board[cx][cy])) {
              count++;
            }
          }
        }

        compute(count);
      }
    }
  }

  private static void sit(int number, List<Seat> seatList) {
    for (Seat seat : seatList) {
      if (board[seat.x][seat.y] == 0) {
        board[seat.x][seat.y] = number;
        return;
      }
    }
  }

  private static void compute(int count) {
    switch (count) {
      case 1:
        result += 1;
        break;
      case 2:
        result += 10;
        break;
      case 3:
        result += 100;
        break;
      case 4:
        result += 1000;
        break;
    }
  }
}
