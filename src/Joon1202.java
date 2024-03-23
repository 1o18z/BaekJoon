import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static class Jewel {

    int weight;
    int price;

    public Jewel(int weight, int price) {
      this.weight = weight;
      this.price = price;
    }
  }

  static int n, k;
  static List<Jewel> jewels;
  static PriorityQueue<Integer> bags;
  static PriorityQueue<Integer> possibleJewels;
  static long result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    jewels = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int price = Integer.parseInt(st.nextToken());
      jewels.add(new Jewel(weight, price));
    }

    jewels.sort((o1, o2) -> {
      if (o1.weight == o2.weight) {
        return o2.price - o1.price;
      }
      return o1.weight - o2.weight;
    });

    bags = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      bags.add(Integer.parseInt(br.readLine()));
    }

    int index = 0;
    int size = jewels.size();
    possibleJewels = new PriorityQueue<>((o1, o2) -> o2 - o1);

    while (!bags.isEmpty()) {
      int bag = bags.poll();

      while (index < size && jewels.get(index).weight <= bag) {
        possibleJewels.add(jewels.get(index).price);
        index++;
      }

      if (!possibleJewels.isEmpty()) {
        result += possibleJewels.poll();
      }
    }
    
    System.out.println(result);
  }
}
