import java.util.Scanner;

public class Main {
    static int[][] array;
    static boolean[] isVisited;
    static int count = 0;
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int M = scanner.nextInt();

        array = new int[N + 1][N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            array[A][B] = array[B][A] = 1; // A-B나 B-A나 동일
        }
        dfs(1);
    }

    static void dfs(int idx) {
        isVisited[idx] = true;

        for (int i = 1; i <= N; i++) {
            if (array[idx][i] == 1 && !isVisited[i]) {
                dfs(i);
                count++;
            }
        }
    }
}
