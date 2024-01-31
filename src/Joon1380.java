import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  static class Student {

    private String name;
    private int count = 0;
    private boolean isReturn;

    public Student(String name) {
      this.name = name;
      this.isReturn = false;
    }

    public void addCount() {
      count += 1;
      if (count == 2) {
        isReturn = true;
      }
    }

    public String getName() {
      return name;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, Student> map;
    int index = 1;

    while (true) {
      int N = Integer.parseInt(br.readLine());

      if (N == 0) {
        break;
      }

      map = new HashMap<>();
      for (int i = 1; i <= N; i++) {
        map.put(String.valueOf(i), new Student(br.readLine()));
      }

      for (int i = 0; i < N * 2 - 1; i++) {
        String value = br.readLine();

        Student student = map.get(value.split(" ")[0]);
        if (student != null) {
          student.addCount();
        }
      }

      for (Student student : map.values()) {
        if (!student.isReturn) {
          System.out.println(index + " " + student.getName());
          index++;
        }
      }
    }
  }
}
