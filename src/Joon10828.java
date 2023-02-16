import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Joon10828 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<String> stack = new Stack<>();
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String T = br.readLine();
      if (T.equals("top")) {
        if (stack.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(stack.peek());
        }
      }
      if (T.equals("size")) {
        System.out.println(stack.size());
      }
      if (T.equals("empty")) {
        if (stack.isEmpty()) {
          System.out.println(1);
        } else {
          System.out.println(0);
        }
      }
      if (T.equals("pop")) {
        if (stack.isEmpty()) {
          System.out.println(-1);
        } else {
          System.out.println(stack.pop());
        }
      }
      if (T.contains("push")) {
        String str = T.substring(T.indexOf(" ") + 1);
        stack.push(str);
      }
    }
  }
}
