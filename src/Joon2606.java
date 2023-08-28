/* 
    DFS
*/
import java.util.Scanner;

public class DFS {
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

/*
    BFS
*/
package org.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    static int[][] array;
    static boolean[] isVisited;
    static int M, N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine()); // 컴퓨터 수
        N = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

        array = new int[M + 1][M + 1]; // 번호가 1부터 시작해서 +1 (좌표랑 맞추기 위해)
        isVisited = new boolean[M + 1];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            array[A][B] = array[B][A] = 1; // 연결되어 있는 거니까 뒤집어도 같은 거
        }
        System.out.println(bfs(1));
    }

    static int bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[index] = true;
        queue.offer(index); // 현재 큐에 1 들어있음

        while (!queue.isEmpty()) {
            int value = queue.poll(); // 1 꺼냄
            for (int i = 1; i <= M; i++) {
                if (array[value][i] == 1 && !isVisited[i]) { // 방문처리 되어있는지 확인
                    queue.offer(i); // 방문 안 되어있으면 큐에 넣음
                    isVisited[i] = true; // 방문 처리
                    count++;
                }
            }
        }
        return count;
    }

}
