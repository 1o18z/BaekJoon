import java.util.Scanner;

public class Joon1236 {
  public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int M = scanner.nextInt();
    
    char[][] arr = new char[N][M];
    for (int i = 0; i < N; i++) {
      arr[i] = scanner.next().toCharArray();
    }

    boolean[] existRow = new boolean[N];
    boolean[] existColumn = new boolean[M];

    int resultRow = N;
    int resultColumn = M;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] == 'X') {
          existRow[i] = true;
          existColumn[j] = true;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      if (existRow[i]) {
        resultRow--;
      }
    }
    for (int j = 0; j < M; j++) {
      if (existColumn[j]) {
        resultColumn--;
      }
    }
    System.out.println(Math.max(resultRow, resultColumn));
  }
  
}
