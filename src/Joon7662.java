import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      TreeMap<Integer, Integer> map = new TreeMap<>();

      int n = Integer.parseInt(br.readLine());

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        String letter = st.nextToken();
        int value = Integer.parseInt(st.nextToken());

        if (letter.equals("I")) {
          map.put(value, map.getOrDefault(value, 0) + 1);
          continue;
        }
        
        if (map.isEmpty()) {
          continue;
        }
        
        if (value == -1) {
          int min = map.firstKey();
          map.put(min, map.get(min) - 1);
          if(map.get(min) <=0){
            map.remove(min);
          }
        } else if (value == 1) {
          int max = map.lastKey();
          map.put(max, map.get(max) - 1);
          if(map.get(max) <=0){
            map.remove(max);
          }
        }
      }

      System.out.println(map.isEmpty() ? "EMPTY"
          : map.lastKey() + " " + map.firstKey());
    }
  }
}
