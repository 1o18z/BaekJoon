import java.io.*;
import java.util.Stack;

public class Joon9012 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < N; i++) {
      String T = br.readLine();
      char[] arr = T.toCharArray();

      for (int j = 0; j < arr.length; j++) {
        if (arr[j] == '(') {
          stack.push('(');
        } else {
          if (stack.isEmpty()) {
            stack.push('m');
            break;
          }
          stack.pop();
        }
      }
      if (stack.isEmpty()) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
      stack.clear();
    }
  }
}

