import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int[] arr = new int[t + 1];
    int[] result = new int[t + 1];
    arr[0] = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= t; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    } 

    for (int i = 1; i <= t; i++) {
      for (int j = 1; j <= i; j++) {
        result[i] = Math.max(result[i], arr[j] + result[i - j]);
      }
    }
    System.out.println(result[t]);
  }
}
