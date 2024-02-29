import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

  static class Present {

    int price;
    int happiness;

    public Present(int price, int happiness) {
      this.price = price;
      this.happiness = happiness;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    Present[] arr = new Present[n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      arr[i] = new Present(p, v);
    }

    Arrays.sort(arr, Comparator.comparingInt(o -> o.price));

    int i = 0;
    int j = 0;
    long sum = 0;
    long result = Integer.MIN_VALUE;

    while (true) {
      while (j < n && arr[j].price - arr[i].price < d) {
        sum += arr[j].happiness;
        j++;
      }
      result = Math.max(result, sum);

      if (j == n) {
        break;
      }
      sum -= arr[i].happiness;
      i++;
    }
    System.out.println(result);
  }
}
