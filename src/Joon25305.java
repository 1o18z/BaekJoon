import java.io.*;
import java.util.*;

public class Joon25305 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    Integer[] arr = new Integer[N];

    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st2.nextToken());
    }
    Arrays.sort(arr, Comparator.reverseOrder());
    System.out.println(arr[k - 1]);
  }
}
