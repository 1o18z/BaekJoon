import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    BigInteger[] arr = new BigInteger[101];
    
    arr[1] = BigInteger.valueOf(1);
    arr[2] = BigInteger.valueOf(1);
    arr[3] = BigInteger.valueOf(1);
    arr[4] = BigInteger.valueOf(2);
    arr[5] = BigInteger.valueOf(2);

    for (int i = 6; i < arr.length; i++) {
      arr[i] = arr[i - 1].add(arr[i - 5]);
    }

    for (int i = 0; i < n; i++) {
      System.out.println(arr[Integer.parseInt(br.readLine())]);
    }
  }
}
