import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    int count = 0;
    while (count != t) {
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      int[] result = new int[n];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr);

      List<Integer> odd = new ArrayList<>();
      List<Integer> even = new ArrayList<>();

      for (int i = 0; i < arr.length; i++) {
        if (i % 2 == 0) {
          even.add(arr[i]);
          continue;
        }
        odd.add(arr[i]);
      }
      odd.sort(Collections.reverseOrder());

      IntStream.range(0, even.size()).forEach(i -> result[i] = even.get(i));
      IntStream.range(0, odd.size()).forEach(i -> result[even.size() + i] = odd.get(i));

      int max = result[0] - result[result.length - 1];
      for (int i = 0; i < result.length - 1; i++) {
        max = Math.max(max, Math.abs(result[i] - result[i + 1]));
      }

      System.out.println(max);
      count++;
    }
  }
}
