import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int result = Integer.MAX_VALUE;
    int i = 0;
    int j = 0;
    int sum = 0;

    while (true) {
      if (sum >= S) {
        sum -= arr[i++];
        result = Math.min(result, j - i + 1);
      } else if (j == N) {
        break;
      } else {
        sum += arr[j++];
      }
    }
    System.out.println(result == Integer.MAX_VALUE ? 0 : result);
  }
}
