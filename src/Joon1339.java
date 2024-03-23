import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] alphabet = new int[26];
    
    for (int i = 0; i < n; i++) {
      String value = br.readLine();

      for (int j = 0; j < value.length(); j++) {
        alphabet[value.charAt(j) - 65] += (int) Math.pow(10, value.length() - 1 - j);
      }
    }

    Arrays.sort(alphabet);
    int[] arr = new int[26];
    for (int i = 0; i < alphabet.length; i++) {
      arr[i] = alphabet[alphabet.length - i - 1];
    }

    int number = 9;
    int result = 0;
    for (int j : arr) {
      if (j == 0) {
        break;
      }
      result += j * number--;
    }

    System.out.println(result);
  }
}
