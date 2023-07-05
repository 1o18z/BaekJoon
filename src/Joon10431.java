import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int P = scanner.nextInt();

    while (P-- > 0) {
      int T = scanner.nextInt();
      int[] array = new int[20];

      for (int m = 0; m < 20; m++) {
        array[m] = scanner.nextInt();
      }

      int count = 0;
      for (int i = 0; i < 20; i++) {
        for (int j = 0; j < i; j++) {

          if (array[j] > array[i]) {
            int current = array[i];

            for (int k = i; k > j; k--) {
              array[k] = array[k - 1];
              count++;
            }
            array[j] = current;
            break;
          }
        }
      }

      System.out.println(T + " " + count);
    }
  }
}
