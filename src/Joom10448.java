import java.util.Scanner;

public class Joon10448 {
  static boolean[] isEurekaNumber = new boolean[1001];

  public static void preprocess() {
    int[] triangleNumbers = new int[50];
    int triangleNumberCount = 0;
    
    for (int i = 1; ; i++) {
      int triangleNumber = i * (i + 1) / 2;
      if (triangleNumber > 1000) break;
      triangleNumbers[triangleNumberCount++] = triangleNumber;
    }

    boolean[] isSumOfTriangleNumber = new boolean[1000];
    
    for (int i = 0; i < triangleNumberCount; i++) {
      for (int j = 0; j < triangleNumberCount; j++) {
        int sum = triangleNumbers[i] + triangleNumbers[j];
        if (sum < 1000) isSumOfTriangleNumber[sum] = true;
      }
    }
    
    for (int i = 1; i < 1000; i++) {
      if (!isSumOfTriangleNumber[i]) continue;
      
      for (int j = 0; j < triangleNumberCount; j++) {
        int sum = i + triangleNumbers[j];
        if (sum <= 1000) isEurekaNumber[sum] = true;
      }
    }
  }
  
  public static void main(String[] args) {
    preprocess();
    
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    while (T-- > 0) {
      int K = scanner.nextInt();
      System.out.println(isEurekaNumber[K] ? "1" : 0);
    }
  }
  
}
