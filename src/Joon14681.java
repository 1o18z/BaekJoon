import java.io.*;

public class Joon14681 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        System.out.println(x>0 ? y>0 ? 1 : 4 :y>0 ? 2 : 3);
    }
}