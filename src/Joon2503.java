import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Base> list;

    static class Base {
        int number;
        int strike;
        int ball;

        public Base(int number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            list.add(new Base(number, strike, ball));
        }

        System.out.println(checkNumber());
    }

    static int checkNumber() {
        int count = 0;
        for (int i = 123; i <= 987; i++) {
            if (!checkDuplicateNumber(i)) continue;

            int pass = 0;
            for (int j = 0; j < N; j++) {
                int expectedStrike = 0;
                int expectedBall = 0;

                Base base = list.get(j);
                String number = String.valueOf(base.number);
                String expectedNumber = String.valueOf(i);

                for (int k = 0; k < 3; k++) {
                    if (number.charAt(k) == expectedNumber.charAt(k)) expectedStrike++;
                }
                for (int l = 0; l < 3; l++) {
                    for (int m = 0; m < 3; m++) {
                        if (l != m && (number.charAt(l) == expectedNumber.charAt(m))) expectedBall++;
                    }
                }
                if (expectedStrike == base.strike && expectedBall == base.ball) pass++;
            }
            if (pass == N) count++;
        }
        return count;
    }

    static boolean checkDuplicateNumber(int currentNumber) {
        String number = String.valueOf(currentNumber);
        char first = number.charAt(0);
        char second = number.charAt(1);
        char third = number.charAt(2);

        if (first == second) return false;
        if (first == third) return false;
        if (second == third) return false;
        if (first == '0' || second == '0' || third == '0') return false;
        return true;
    }
}
