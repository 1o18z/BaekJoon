import java.io.*;
public class Joon2753 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        System.out.println((year % 4 == 0) ? ((year % 400 == 0) ? 1 : year % 100 == 0 ? 0 : 1) : 0);
    }
}