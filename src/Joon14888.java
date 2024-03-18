import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[] arr;
  static int[] operator;

  static int min = Integer.MAX_VALUE;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    arr = new int[n];
    operator = new int[4];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      operator[i] = Integer.parseInt(st.nextToken());
    }

    explore(arr[0], 1);

    System.out.println(max);
    System.out.println(min);
  }

  private static void explore(int i, int depth) {
    if (depth == n) {
      max = Math.max(i, max);
      min = Math.min(i, min);
      return;
    }

    for (int j = 0; j < 4; j++) {
      if (operator[j] > 0) {
        operator[j] -= 1;

        switch (j) {
          case 0 -> explore(i + arr[depth], depth + 1);
          case 1 -> explore(i - arr[depth], depth + 1);
          case 2 -> explore(i * arr[depth], depth + 1);
          default -> explore(i / arr[depth], depth + 1);
        }
        
        operator[j] += 1;
      }
    }
  }
}
