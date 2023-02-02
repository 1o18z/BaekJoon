import java.io.*;
import java.util.*;


public class Joon1546 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double[] arr = new double[Integer.parseInt(br.readLine())];
    double total = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      total += (arr[i] / arr[arr.length - 1]) * 100;
    }
    System.out.print(total / arr.length);
  }
}
