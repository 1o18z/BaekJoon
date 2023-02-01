import java.io.*;

public class Joon25304 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine()); // 총액
        int N = Integer.parseInt(br.readLine()); // 물건 수
        int arr[] = new int[N];
        int total = 0;

        for(int i=0; i<N;i++){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            arr[i] = a * b;
        }
        for(int j=0; j<arr.length; j++){
            total += arr[j];
        }
        System.out.println(total == X ? "Yes" : "No");
    }
}
