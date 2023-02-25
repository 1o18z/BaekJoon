import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Joon11651 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int number = Integer.parseInt(br.readLine());
    int[][] arr = new int[number][2];

    for (int i = 0; i < number; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[1] == o2[1]){
          return o1[0] - o2[0];
        } return o1[1] - o2[1];
      }
    });

    for (int i = 0; i < number; i++) {
      System.out.println(arr[i][0] + " " + arr[i][1]);
    }
  }
}
