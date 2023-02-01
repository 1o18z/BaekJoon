import java.util.Scanner;
public class Joon2753 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        int luck = 0;
        if(year % 4 == 0 && year % 100 != 0){
            luck = 1;
        } else if(year % 400 == 0){
            luck = 1;
        } else {
            luck = 0;
        }
        System.out.println(luck);
    }
}