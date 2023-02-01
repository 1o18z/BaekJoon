import java.util.Scanner;
public class Joon2480 {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int A = scan.nextInt();
            int B = scan.nextInt();
            int C = scan.nextInt();
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

