
import java.io.*;

public class Joon2525 {
     public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int A = Integer.parseInt(str[0]);
            int B = Integer.parseInt(str[1]);
            int C = Integer.parseInt(br.readLine());
            int D = 60 * A + B;    // 분으로 변경
            D = D + C;
            System.out.println(((D/60) % 24) + " " + (D % 60));

    }
}
