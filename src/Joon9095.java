import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> list = new ArrayList<>();

    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      list.add(Integer.parseInt(br.readLine()));
    }
    int[] dp = new int[11];

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i = 4; i < dp.length; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    for (Integer value : list) {
      System.out.println(dp[value]);
    }
  }
}
