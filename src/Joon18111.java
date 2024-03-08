import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main1 {

  static int resultTime = Integer.MAX_VALUE;
  static int resultHeight = Integer.MAX_VALUE;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int[][] board = new int[n][m];

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        int value = Integer.parseInt(st.nextToken());
        max = Math.max(max, value); 
        min = Math.min(min, value); 
        board[i][j] = value;
      }
    }

    Queue<Integer> queue = IntStream.rangeClosed(min, max).boxed()
        .collect(Collectors.toCollection(ArrayDeque::new));

    while (!queue.isEmpty()) {
      int target = queue.poll(); 
      int time = 0;
      int inventoryBlocks = b;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (board[i][j] == target) {
            continue;
          }
          if (board[i][j] > target) {
            time += (board[i][j] - target) * 2;
            inventoryBlocks += board[i][j] - target;
            continue;
          }
          if (board[i][j] < target) {
            time += target - board[i][j];
            inventoryBlocks -= target - board[i][j];
          }
        }
      }
      
      if (inventoryBlocks >= 0) {
        if (resultTime < time) {
          continue;
        }
        if (resultTime > time) {
          resultTime = time;
          resultHeight = target;
        } else {
          resultHeight = Math.max(resultHeight, target);
        }
      }
    }

    System.out.println(resultTime + " " + resultHeight);
  }
}
