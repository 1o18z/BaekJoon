import java.io.*;
import java.util.StringTokenizer;

import java.io.*;
import java.util.StringTokenizer;
public class Joon11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write("Case #" + i + ": " + A + " + " + B + " = " + (A+B) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
