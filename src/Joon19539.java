import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n];
    int sum = 0;
    int odd = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int value = Integer.parseInt(st.nextToken());
      arr[i] = value;
      sum += value;
      
      if (value % 2 == 1) {
        odd++;
      }
    }

    System.out.println((sum % 3 == 0) && (odd <= sum / 3) ? "YES" : "NO");
  }
}
