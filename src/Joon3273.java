import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < N; i++)
      a[i] = scanner.nextInt();
    int X = scanner.nextInt();

    int[] cnt = new int[1000001];
    for (int i = 0; i < N; i++) {
      cnt[a[i]]++;
    }
    long count = 0;
    for (int i = 1; i <= (X - 1) / 2; i++) {
      if (X - i <= 1000000) {
        count += (long) cnt[i] * cnt[X - i];
      }
    }
    System.out.println(count);
  }
}
