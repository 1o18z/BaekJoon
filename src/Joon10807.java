import java.util.Scanner;

public class Joon10807 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int[] arr = new int[N];
    int sum = 0;

    for (int i = 0; i < N; i++) {
      arr[i] += scan.nextInt();
    }
    int count = scan.nextInt();
    for (int j = 0; j < arr.length; j++) {
      if (arr[j] == count) sum++;
    }
    System.out.println(sum);
  }
}
