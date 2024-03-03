import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int result = 0;
  static List<Integer> boysA = new ArrayList<>(); // <0
  static List<Integer> girlsA = new ArrayList<>();
  
  static List<Integer> boysB = new ArrayList<>(); // >0
  static List<Integer> girlsB = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int value = Integer.parseInt(st.nextToken());
      if (value < 0) {
        boysA.add(-value);
      } else {
        boysB.add(value);
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int value = Integer.parseInt(st.nextToken());
      if (value < 0) {
        girlsB.add(-value);
      } else {
        girlsA.add(value);
      }
    }

    Collections.sort(girlsA);
    Collections.sort(boysA);

    int i = 0;
    int j = 0;

    while (i < boysA.size() && j < girlsA.size()) {
      if (boysA.get(i) > girlsA.get(j)) {
        result++;
        i++;
        j++;
      } else {
        i++;
      }
    }

    Collections.sort(girlsB);
    Collections.sort(boysB);

    i = 0;
    j = 0;
    while (i < girlsB.size() && j < boysB.size()) {
      if (girlsB.get(i) > boysB.get(j)) {
        result++;
        i++;
        j++;
      } else {
        i++;
      }
    }
    System.out.println(result);
  }
}
