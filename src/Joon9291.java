import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<Integer> set;
    static int[][] board = new int[9][9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        for (int k = 0; k < number; k++) {
            if (k > 0) br.readLine();

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
          
            if (isValidSudoku()) {
                sb.append("Case ")
                        .append(k + 1)
                        .append(": CORRECT\n");
            } else {
                sb.append("Case ")
                        .append(k + 1)
                        .append(": INCORRECT\n");
            }
        }
        System.out.println(sb.toString());
    }


    private static boolean isValidSudoku() {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(i) || !checkCol(i)) return false;
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkBox(i, j)) return false;
            }
        }
        return true;
    }

    static boolean checkRow(int x) {
        set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (!set.add(board[x][i])) return false;
        }
        return true;
    }

    static boolean checkCol(int y) {
        set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (!set.add(board[i][y])) return false;
        }
        return true;
    }

    static boolean checkBox(int moveX, int moveY) {
        set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!set.add(board[moveX + i][moveY + j])) return false;
            }
        }
        return true;
    }
}
