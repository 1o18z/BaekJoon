import java.io.*;

public class Joon2884 {
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int H = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);

            if(M < 45){
                H--;
                M = (M + 60) - 45;
                if(H < 0){
                    H = 23;
                }
                System.out.println(H + " " + M);
            } else{
                System.out.println(H + " " + (M - 45));
            }
        }
    }

