import java.io.*;
import java.util.*;

public class Joon2562 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int max = 0;
    int idx = 0;

    for (int i = 0; i < 9; i++) {
      int A = Integer.parseInt(br.readLine());

      if (A > max) {
        max = A;
        idx = i + 1;
      }
    }
    System.out.println(max);
    System.out.println(idx);
  }
}