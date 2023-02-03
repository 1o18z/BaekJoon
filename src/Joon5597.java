import java.io.*;
import java.util.HashSet;

public class Joon5597 {
  public static void main(String[] args) throws IOException {
    HashSet<Integer> set = new HashSet<Integer>();
    int[] arr = new int[31];

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 1; i <= 28; i++) {
      set.add(Integer.parseInt(br.readLine()));
    }
    for (int j = 0; j <= 30; j++) {
      if (set.contains(j) == false && j != 0) {
        arr[j] = j;
        System.out.println(arr[j]);
      }
    }
  }
}
