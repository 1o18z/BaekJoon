import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static class GroupA {

    PriorityQueue<Integer> girlsA; // <0
    PriorityQueue<Integer> boysA; // >0

    public GroupA() {
      girlsA = new PriorityQueue<>();
      boysA = new PriorityQueue<>();
    }
  }

  static class GroupB {

    PriorityQueue<Integer> girlsB; // >0
    PriorityQueue<Integer> boysB; // <0

    public GroupB() {
      girlsB = new PriorityQueue<>();
      boysB = new PriorityQueue<>();
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    GroupA groupA = new GroupA();
    GroupB groupB = new GroupB();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int value = Integer.parseInt(st.nextToken());
      if (value < 0) {
        groupB.boysB.add(Math.abs(value));
      } else {
        groupA.boysA.add(value);
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int value = Integer.parseInt(st.nextToken());
      if (value < 0) {
        groupA.girlsA.add(Math.abs(value));
      } else {
        groupB.girlsB.add(value);
      }
    }

    int result = 0;
    while (!groupB.boysB.isEmpty() && !groupB.girlsB.isEmpty()) {
      int boy = groupB.boysB.poll();
      int girl = groupB.girlsB.peek();
      if (girl < boy) {
        result++;
        groupB.girlsB.poll();
      }
    }

    while (!groupA.boysA.isEmpty() && !groupA.girlsA.isEmpty()) {
      int girl = groupA.girlsA.poll();
      int boy = groupA.boysA.peek();
      if (boy < girl) {
        result++;
        groupA.boysA.poll();
      }
    }
    System.out.println(result);
  }
}
