import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    int[] ate = new int[d + 1];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    ate[c]++;
    
    int result = 1; // 쿠폰 초밥
    for (int i = 0; i < k; i++) {
      if (ate[arr[i]] == 0) {
        result++;
      }
      ate[arr[i]]++;
    }

    int count = result;
    for (int i = 1; i < n; i++) {
      ate[arr[i - 1]]--;
      if (ate[arr[i - 1]] == 0) {
        count--;
      }

      if (ate[arr[(i + k - 1) % n]] == 0) {
        count++;
      }
      ate[arr[(i + k - 1) % n]]++;

      result = Math.max(result, count);
    }

    System.out.println(result);
  }
}
