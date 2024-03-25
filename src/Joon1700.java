import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int n, k;
  static List<Integer> multiTap;
  static List<Integer> plugs;
  static int result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    multiTap = new ArrayList<>();
    plugs = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < k; i++) {
      int value = Integer.parseInt(st.nextToken());
      if (multiTap.size() < n) {
        if (multiTap.contains(value)) {
          continue;
        }
        multiTap.add(value);
      } else {
        plugs.add(value);
      }
    }

    while (!plugs.isEmpty()) {
      if (multiTap.contains(plugs.get(0))) {
        plugs.remove(0);
        continue;
      }

      result++;
      boolean isNotBeUsed = false;
      int index = -1;
      int removeIndex = -1;

      for (int i = 0; i < multiTap.size(); i++) {
        if (!plugs.contains(multiTap.get(i))) {
          isNotBeUsed = true;
          multiTap.remove(i);
          multiTap.add(plugs.remove(0));
          break;
        }
        if (plugs.indexOf(multiTap.get(i)) > index) {
          index = plugs.indexOf(multiTap.get(i));
          removeIndex = i;
        }
      }

      if (!isNotBeUsed) {
        multiTap.remove(removeIndex);
        multiTap.add(plugs.remove(0));
      }
    }

    System.out.println(result);
  }
}
