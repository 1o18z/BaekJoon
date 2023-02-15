import java.io.*;
import java.util.Stack;

public class Joon10773 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> stack = new Stack<>();
    int N = Integer.parseInt(br.readLine());
    int sum = 0;

    for (int i = 0; i < N; i++) {
      int K = Integer.parseInt(br.readLine());
      if (K != 0) {
        stack.push(K);
      } else {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      }
    }
    for (int i : stack) {
      sum += i;
    }
    System.out.println(sum);
  }
}
