import java.io.*;

public class Joon8958 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(bf.readLine());

    String arr[] = new String[T];

    for (int i = 0; i < T; i++) {
      arr[i] = bf.readLine();
    }
    for (int i = 0; i < T; i++) {
      int sum = 0;
      int count = 0;
      for (int j = 0; j < arr[i].length(); j++) {
        if (arr[i].charAt(j) == 'O') {
          count++;
        } else {
          count = 0;
        }
        sum += count;
      }
      System.out.println(sum);
    }
  }
}
