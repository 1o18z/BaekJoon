import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] background = new boolean[101][101];

        int C = Integer.parseInt(br.readLine());
        int count=0;

        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()); // 가로
            int Y = Integer.parseInt(st.nextToken()); // 세로

            for (int j = Y; j < Y + 10; j++) { // 세로
                for (int k = X; k < X + 10; k++) { // 가로
                    if (!background[j][k]) {
                        background[j][k] = true;
                        count++;
                    }
                }
            }
        }
      
        System.out.println(count);
    }
}
