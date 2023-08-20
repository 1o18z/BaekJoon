package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N;
    static char[][] colorArray;
    static boolean[][] isVisited;
    static int[] locationX = {0, 1, 0, -1};
    static int[] locationY = {1, 0, -1, 0};
    static int count, weaknessCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        colorArray = new char[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                colorArray[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (colorArray[i][j] == 'G') {
                    colorArray[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j);
                    weaknessCount++;
                }
            }
        }
        System.out.println(count + " " + weaknessCount);
    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;
        char value = colorArray[x][y];

        for (int i = 0; i < 4; i++) {
            int currentX = x + locationX[i];
            int currentY = y + locationY[i];
            if (currentX >= 0 && currentX < N && currentY >= 0 && currentY < N) {
                if (!isVisited[currentX][currentY] && colorArray[currentX][currentY] == value) {
                    dfs(currentX, currentY);
                }
            }
        }
    }
}
