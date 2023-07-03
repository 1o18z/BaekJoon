import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main {
 	public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int T = Integer.parseInt(br.readLine());
		
		int currentX = (P+T)%(2*W);
		int currentY = (Q+T)%(2*H);
		
		currentX = W - Math.abs(W-currentX);
		currentY = H - Math.abs(H-currentY);
		
		System.out.println(currentX+" "+currentY);
 	}
  
}
