import java.io.*;
import java.util.StringTokenizer;

public class Joon10807 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int sum = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] += Integer.parseInt(st.nextToken());
    }
    int count = Integer.parseInt(br.readLine());
    for (int j = 0; j < arr.length; j++) {
      if (arr[j] == count) sum++;
    }
    System.out.println(sum);
  }
}
