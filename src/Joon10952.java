import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Joon10952 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A == 0 && B == 0) break;
            System.out.println(A + B);
        }
    }

}