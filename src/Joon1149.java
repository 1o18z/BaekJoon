class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] dp = new int[n + 1][3];

    for (int i = 1; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + a;
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + b;
      dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + c;
    }
    System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
  }
}
