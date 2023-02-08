import java.io.*;
import java.util.*;

public class Joon10809 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[26];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = -1;
    }
    String S = br.readLine();
    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);  // 문자 추출해 ch 변수에 저장

      if (arr[ch - 'a'] == -1) {  // ch의 문자의 위치를 arr 배열의 값으로 바꿔줌 (0부터 시작하니 ch의 문자 위치는 i임)
        arr[ch - 'a'] = i;  // arr 배열의 인덱스는 ch가 갖고있는 문자 인코딩값(아스키코드값)에 'a'나 97을 빼주면 됨
      }                   // ch에 b가 담겨있을 경우 b-'a'나 b-97하면 arr[1]은 문자 b 가리키게 됨
    }
    for (int val : arr) {
      System.out.print(val + " ");
    }
  }
}
