import java.util.Scanner;
public class Joon2439 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for(int i=N; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print(" ");
            }
            for(int k=0; k<=N-i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
