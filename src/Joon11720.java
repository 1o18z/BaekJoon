import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Joon11720 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String A = br.readLine();
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += A.charAt(i) - '0';
    }

    System.out.println(sum);
  }
}
// N숫자만큼의 길이인 수를 하나 받음
// 그 수를 각각 하나씩 쪼개서 더함