import java.io.*;
import java.util.StringTokenizer;

public class Joon4344 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int C = Integer.parseInt(br.readLine());  // 받을개수

    for (int i = 0; i < C; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int[] arr = new int[N];
      double sum = 0;  // 성적합

      for (int j = 0; j < N; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
        sum += arr[j];
      }
      double total = sum / N;
      double count = 0;
      for (int j = 0; j < N; j++) {
        if (arr[j] > total) {
          count++;
        }
      }
      System.out.println(String.format("%.3f", count / N * 100) + "%");
    }
  }
}
