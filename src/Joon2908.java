import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Joon2908 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = 0;
    int D = 0;
    int result = 0;

    while (A != 0) {
      C = C * 10 + A % 10;
      A /= 10;
    }
    while (B != 0) {
      D = D * 10 + B % 10;
      B /= 10;
    }
    if (C > D) {
      result = C;
    } else {
      result = D;
    }
    System.out.print(result);
  }
}
