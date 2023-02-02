
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Joon1546 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  // 개수 입력받고
    double[] arr = new double[N];
    double total = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());  // 입력한 개수만큼 숫자 받고
    }
    Arrays.sort(arr);   // 오름차순으로 정렬 후
    for(int i=0; i<N; i++){
      total += (arr[i]/arr[arr.length-1])*100;  // arr값 / 최댓값 * 100한 거 총합을 total에 넣어서
    }
    System.out.print(total/N);  // total을 N으로 나눠 평균 구함
  }
}
