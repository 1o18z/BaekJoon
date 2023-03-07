import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Joon5086 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());

      if (first != 0 && second != 0) {
        if (second % first == 0) System.out.println("factor");
        else if (first % second == 0) System.out.println("multiple");
        else System.out.println("neither");
      }
      else break;
    }
  }
}
