import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      stack.add(Integer.parseInt(br.readLine()));
    }

    int result = 0;
    while (k != 0) {
      int value = stack.pop();
      
      if (value > k) {
        continue;
      } else if (value == k) {
        result += value / k;
        break;
      } else {
        result += k / value;
        k = k % value;
      }
    }
    System.out.println(result);
  }
}
