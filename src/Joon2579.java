import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] score = new int[301];
    int[] arr = new int[301];

    for (int i = 1; i <= n; i++) {
      score[i] = Integer.parseInt(br.readLine());
    }

    arr[1] = score[1];
    arr[2] = score[1] + score[2];
    arr[3] = Math.max(score[1], score[2]) + score[3];

    for (int i = 4; i <= n; i++) {
      arr[i] = Math.max(arr[i - 2], arr[i - 3] + score[i - 1]) + score[i];
    }
    
    System.out.println(arr[n]);
  }
}
