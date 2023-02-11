import java.io.*;
import java.util.*;

public class Joon10814 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[][] arr = new String[N][2];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = st.nextToken();
      arr[i][1] = st.nextToken();
    }
    Arrays.sort(arr, new Comparator<String[]>() {
      public int compare(String[] s1, String[] s2) {
        return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
        // 양의 정수일 경우에만 두 객체의 위치 바꿔줌
        // 나이순으로 정렬하면서 이름은 따로 비교 ㄴㄴ, 나이 같은 땐 0 반환되어 자연스레 입력순으로 정렬
      }
    });
    for (int i = 0; i < N; i++) {
      System.out.println(arr[i][0] + " " + arr[i][1]);
    }
  }
}
