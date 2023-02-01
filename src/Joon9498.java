import java.util.Scanner;
public class Joon9498 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int score = scan.nextInt();

        System.out.println(score >= 90 ? "A" : (score >= 80) ? "B" : (score >= 70) ? "C" : (score >= 60) ? "D" : "E" );
    }
}