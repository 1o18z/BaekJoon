import java.io.*;

public class Joon2739 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        for(int i = 1; i < 10; i++){
            System.out.println(N + " * " + i + " = " + N*i);
        }
    }
}
