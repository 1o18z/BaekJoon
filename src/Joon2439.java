import java.io.*;

public class Joon2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=N; i>=1; i--){
            for(int j=1; j<i; j++){
                System.out.print(" ");
            }
            for(int k=0; k<=N-i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
