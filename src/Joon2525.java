
import java.util.Scanner;

public class Joon2525 {
     public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int A = scan.nextInt();
            int B = scan.nextInt();
            int C = scan.nextInt();
            int D = 60 * A + B;
            D = D + C;
            int H = (D/60) % 24;
            int M = D % 60;
            System.out.println(H + " " + M);

    }
}
