import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int G = Integer.parseInt(br.readLine());

    List<Integer> list = new ArrayList<>();
    int i = 1;
    int j = 2;

    while (j < 100_000) {
      if (Math.pow(j, 2) - Math.pow(i, 2) == G) {
        list.add(j);
        j++;
      } else if (Math.pow(j, 2) - Math.pow(i, 2) < G) {
        j++;
      } else {
        i++;
      }
    }

    Collections.sort(list);
    if (list.isEmpty()) {
      list.add(-1);
    }

    for (Integer value : list) {
      System.out.println(value);
    }
  }
}
