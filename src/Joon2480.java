import java.io.*;
import java.util.StringTokenizer;

public class Joon2480 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int max = A;

            if(max < B) max = B;
            if(max < C) max = C;

            if(A == B && A == C){
                System.out.println(10000 + A*1000);
            } else if(A == B && A != C){
                System.out.println(1000 + A*100);
            } else if(A == C && A != B){
                System.out.println(1000 + A*100);
            } else if(B == C && B != A){
                System.out.println(1000 + B*100);
            } else{
                System.out.println(max*100);
            }
        }
    }

