import java.io.*;
import java.util.*;

public class Joon1427 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] arr = br.readLine().toCharArray();

    Arrays.sort(arr);
    for (int i = arr.length - 1; i >= 0; i--) {
      System.out.print(arr[i]);
    }
  }
}
