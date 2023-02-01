import java.io.*;
import java.util.Scanner;
public class Joon2480 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            int C = Integer.parseInt(str[2]);
            int money = 0;
            int max = A;

            if(max < B) max = B;
            if(max < C) max = C;

            if(A == B && A == C){
                money = 10000 + A*1000;
            } else if(A == B && A != C){
                money = 1000 + A*100;
            } else if(A == C && A != B){
                money = 1000 + A*100;
            } else if(B == C && B != A){
                money = 1000 + B*100;
            } else{
                money = max*100;
            }
            System.out.println(money);
        }
    }

