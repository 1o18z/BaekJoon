import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 5
        K = Integer.parseInt(st.nextToken()); // 17
        System.out.println(bfs(N));
    }

    static int bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visit[x] = 1; // 5에 0 넣음

        while (!queue.isEmpty()) {
            int poll = queue.poll(); //  하나 꺼내서

            if (poll == K) { // 꺼낸게 17에 도달했으면
                return visit[poll] - 1; // 17에 해당하는 숫자 반환
            }
            if (poll - 1 >= 0 && visit[poll - 1] == 0) { // -1이 0 이상이고 방문하지 않았다면
                visit[poll - 1] = visit[poll] + 1; // -1 위치는 이전 위치 +1
                queue.offer(poll - 1);
            }
            if (poll + 1 <= 100000 && visit[poll + 1] == 0) {
                visit[poll + 1] = visit[poll] + 1;
                queue.offer(poll + 1);
            }
            if (poll * 2 <= 100000 && visit[poll * 2] == 0) {
                visit[poll * 2] = visit[poll] + 1;
                queue.offer(poll * 2);
            }
        }
        return -1;
    }

}
