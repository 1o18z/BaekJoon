import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    List<Integer> list = new ArrayList<>();
    int result = 0;

    for (int i = 0; i < n - 1; i++) {
      list.add(arr[i + 1] - arr[i]);
    }
    Collections.sort(list);

    for (int i = 0; i < n - k; i++) {
      result += list.get(i);
    }
    System.out.println(result);
  }
}
