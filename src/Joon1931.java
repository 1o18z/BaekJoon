import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static class Room {

    int start;
    int end;

    public Room(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Room> list = new ArrayList<>();

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      list.add(new Room(start, end));
    }

    list.sort((o1, o2) -> (o1.end == o2.end) ? o1.start - o2.start : o1.end - o2.end);

    int result = 0;
    int current = 0;

    for (int i = 0; i < n; i++) {
      Room room = list.get(i);
      if (current <= room.start) {
        current = room.end;
        result++;
      }
    }
    System.out.println(result);
  }
}
