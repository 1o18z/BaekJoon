import java.io.*;

public class Joon2751 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    boolean[] arr = new boolean[2000001];
    // 수의 범위가 -1000000~1000000이므로 0의 기준을 인덱스 10000000로 잡음

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[Integer.parseInt(br.readLine()) + 1000000] = true;
    }
    for(int i=0; i<arr.length; i++){
      if(arr[i]){
        sb.append((i-1000000)).append('\n');
      }
    }
    System.out.println(sb);
  }
}
