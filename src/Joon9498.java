import java.util.Scanner;
public class Joon9498 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int score = scan.nextInt();
        String grade = "";
        if(score > 89 && score <= 100){
            grade = "A";
        } else if(score > 79 && score <= 89){
            grade = "B";
        } else if(score > 69 && score <= 79) {
            grade = "C";
        } else if(score > 59 && score <= 69) {
            grade = "D";
        } else{
            grade = "F";
        }
        System.out.println(grade);
    }
}