import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(st.nextToken()); // 칭호 수
        int M = Integer.parseInt(st.nextToken()); // 캐릭터 수

        String[] type = new String[N];
        int[] number = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            type[i] = st.nextToken();
            number[i] = Integer.parseInt(st.nextToken());
            // 칭호
        }

        for (int i = 0; i < M; i++) {
            // 전투력
            int input = Integer.parseInt(br.readLine());

            int start = 0;
            int end = N - 1;
            int current = 0;

            while (start <= end) {
                int middle = (start + end) / 2;

                if (input <= number[middle]) {
                    end = middle - 1;
                    current = middle;
                } else {
                    start = middle + 1;
                }
            }
            sb.append(type[current] + "\n");
        }
        System.out.println(sb);
    }
}
