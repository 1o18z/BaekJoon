package org.example.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] array;
    static boolean[][] isVisited;
    static int[] locationX = {0, 1, 0, -1};
    static int[] locationY = {1, 0, -1, 0};
    static int currentX, currentY;
    static int N;
    static int count;
    static int zero = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        N = scanner.nextInt();

        array = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String A = scanner.next();
            String[] splitA = A.split("");
            for (int j = 0; j < splitA.length; j++) {
                array[i][j] = Integer.parseInt(splitA[j]);
            }
        }
        for (int k = 0; k < N; k++) {
            for (int l = 0; l < N; l++) {
                if (!isVisited[k][l] && array[k][l] == 1) {
                    count = 0;
                    zero++;
                    dfs(k, l);
                    result.add(count);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;
        array[x][y] = zero;
        count++;

        for (int i = 0; i < 4; i++) {
            currentX = locationX[i] + x;
            currentY = locationY[i] + y;

            if (currentX >= 0 && currentX < N && currentY >= 0 && currentY < N) {
                if (!isVisited[currentX][currentY] && array[currentX][currentY] == 1) {
                    isVisited[currentX][currentY] = true;
                    array[currentX][currentY] = zero;
                    dfs(currentX, currentY);
                }
            }
        }
    }
}
