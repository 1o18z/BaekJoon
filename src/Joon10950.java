import java.io.*;
import java.util.StringTokenizer;

public class Joon10950 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int arr[] = new int[T];
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                arr[i] = A + B;
            }
        for(int j=0; j<arr.length; j++){
            System.out.println(arr[j]);
        }


    }
}
