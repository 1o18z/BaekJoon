import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);
    int result = Integer.MAX_VALUE;

    int i = 0;
    int j = 0;

    while (i < N) {
      if (arr[i] - arr[j] < M) {
        i++;
        continue;
      }
      if (arr[i] - arr[j] == M) {
        result = M;
        break;
      }
      result = Math.min(result, arr[i] - arr[j]);
      j++;
    }
    System.out.println(result);
  }
}
