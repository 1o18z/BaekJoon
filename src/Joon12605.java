import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Joon12605 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String L = br.readLine();
      String[] arr = L.split(" ");

      System.out.print("Case #" + (i + 1) + ": ");
      for (int j = arr.length - 1; j >= 0; j--) {
        System.out.print(arr[j] + " ");
      }
    }
  }
}





