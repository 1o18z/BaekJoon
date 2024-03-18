import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int l, c;
  static Character[] arr;
  static Character[] temp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    l = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    arr = new Character[c];
    temp = new Character[l];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < c; i++) {
      arr[i] = st.nextToken().charAt(0);
    }

    Arrays.sort(arr);

    explore(0, 0);
  }

  private static void explore(int depth, int start) {
    if (depth == l) {
      if (check(temp)) {
        for (Character s : temp) {
          System.out.print(s);
        }
        System.out.println();
      }
      return;
    }

    for (int i = start; i < c; i++) {
      temp[depth] = arr[i];
      explore(depth + 1, i + 1);
    }
  }

  private static boolean check(Character[] temp) {
    int count1 = 0;
    int count2 = 0;

    for (Character c : temp) {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        count1++;
      } else {
        count2++;
      }
    }
    
    return count1 >= 1 && count2 >= 2;
  }
}
