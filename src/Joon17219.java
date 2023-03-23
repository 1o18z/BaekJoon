import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int allPwdCount = Integer.parseInt(st.nextToken());
        int findPwdCount = Integer.parseInt(st.nextToken());

        for(int i=0; i<allPwdCount; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            String address = st1.nextToken();
            String passwd = st1.nextToken();
            map.put(address, passwd);
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<findPwdCount; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String findPasswd = st2.nextToken();
            if(map.containsKey(findPasswd)){
                sb.append(map.get(findPasswd));
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}
