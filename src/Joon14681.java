import java.util.Scanner;
public class Joon14681 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int square = 0;
        if(x > 0 && y > 0){
            square = 1;
        } else if(x > 0 && y < 0){
            square = 4;
        } else if(x < 0 && y > 0){
            square = 2;
        } else{
            square = 3;
        }
        System.out.println(square);
    }
}