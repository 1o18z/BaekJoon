import java.util.Scanner;

public class Joon2884 {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int H = scan.nextInt();
            int M = scan.nextInt();
            if(M >= 45){
                M = M - 45;
                System.out.println(H + " " + M);
            } else if(M < 45 && H > 0){
                M = (60 + M) - 45;
                H = H - 1;
                System.out.println(H + " " + M);
            } else if(M < 45 && H == 0){
                M = (60 + M) - 45;
                H = 23;
                System.out.println(H + " " + M);
            } else{
                System.out.println(H + " " + M);
            }


        }
    }
}
