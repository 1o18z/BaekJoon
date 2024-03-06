import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static class Fireball {

    int i;
    int j;
    int mass;
    int speed;
    int direction;

    public Fireball(int r, int c, int m, int s, int d) {
      this.i = r;
      this.j = c;
      this.mass = m;
      this.speed = s;
      this.direction = d;
    }
  }

  static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
  static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

  static int[] oddDirection = {1, 3, 5, 7};
  static int[] evenDirection = {0, 2, 4, 6};

  static List<Fireball> allFireballList;
  static List<Fireball>[][] fireballList;

  static int n, m, k;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    allFireballList = new ArrayList<>();
    fireballList = new ArrayList[n][n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;
      int m = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      allFireballList.add(new Fireball(r, c, m, s, d));
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        fireballList[i][j] = new ArrayList<>();
      }
    }

    while (k > 0) {
      moveFireball();
      processFireball();
      k--;
    }

    System.out.println(getResult());
  }


  private static void moveFireball() {
    for (Fireball fireball : allFireballList) {
      fireball.i = (fireball.i + (fireball.speed % n) * dx[fireball.direction] + n) % n;
      fireball.j = (fireball.j + (fireball.speed % n) * dy[fireball.direction] + n) % n;
      fireballList[fireball.i][fireball.j].add(fireball);
    }
  }

  private static void processFireball() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (fireballList[i][j].size() < 2) {
          fireballList[i][j].clear();
          continue;
        }
        
        divideFireball(i, j);
      }
    }
  }

  private static void divideFireball(int y, int x) {
    int massSum = 0;
    int speedSum = 0;
    int odd = 0;
    int even = 0;

    for (Fireball fireball : fireballList[y][x]) {
      massSum += fireball.mass;
      speedSum += fireball.speed;

      if (fireball.direction % 2 == 0) {
        even += 1;
      } else {
        odd += 1;
      }
      allFireballList.remove(fireball);
    }
    
    fireballList[y][x].clear();

    if (massSum / 5 == 0) {
      return;
    }

    int[] directions = checkDirection((odd + even), odd, even);
    for (int direction : directions) {
      allFireballList.add(new Fireball(y, x, (massSum / 5), (speedSum / (odd + even)), direction));
    }
  }

  private static int[] checkDirection(int size, int odd, int even) {
    if (size == odd || size == even) {
      return evenDirection;
    }
    return oddDirection;
  }

  private static int getResult() {
    int result = 0;
    for (Fireball fireball : allFireballList) {
      result += fireball.mass;
    }
    return result;
  }
}
