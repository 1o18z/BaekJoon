import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String formula = br.readLine();
    String[] values = formula.split("-");
    int[] numbers = new int[values.length];
  

    for (int i = 0; i < values.length; i++) {
      int sum = 0;
      String[] numberString = values[i].split("\\+");
      
      for (String number : numberString) {
        sum += Integer.parseInt(number);
      }
      numbers[i] = sum;
    }

    int result = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      result -= numbers[i];
    }
    
    System.out.println(result);
  }
}
