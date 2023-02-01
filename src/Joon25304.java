import java.util.Scanner;

public class Joon25304 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int X = scan.nextInt(); // 총액
        int N = scan.nextInt(); // 물건 수
        int a = 0;
        int b = 0;
        int arr[] = new int[N];
        int total = 0;

        for(int i=0; i<N;i++){
            a = scan.nextInt();
            b = scan.nextInt();
            arr[i] = a * b;
        }
        for(int j=0; j<arr.length; j++){
            total += arr[j];
        }
        String result = (total == X) ? "Yes" : "No";
        System.out.println(result);
    }
}
