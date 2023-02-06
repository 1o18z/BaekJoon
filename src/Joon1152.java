import java.util.*;

public class Joon1152 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();

    StringTokenizer st = new StringTokenizer(s, " ");  // 공백을 구분
    System.out.println(st.countTokens()); // 공백 수 출력
  }
}
