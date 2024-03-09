import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static class Gear {

    int[] info = new int[8];

    public Gear(String value) {
      String[] values = value.split("");
      for (int i = 0; i < 8; i++) {
        info[i] = Integer.parseInt(values[i]);
      }
    }
  }

  static Gear[] gears = new Gear[4];
  static int result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 4; i++) {
      gears[i] = new Gear(br.readLine());
    }

    int k = Integer.parseInt(br.readLine());

    for (int i = 0; i < k; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int index = Integer.parseInt(st.nextToken());
      int rotationDirection = Integer.parseInt(st.nextToken());

      int[] directions = checkRotationDirection(index, rotationDirection);

      for (int j = 0; j < 4; j++) {
        if (directions[j] != 0) {
          rotate(gears[j], directions[j]);
        }
      }
    }

    getScore();

    System.out.println(result);
  }

  private static int[] checkRotationDirection(int index, int rotationDirection) {
    int[] directions = new int[4];
    directions[index - 1] = rotationDirection;

    for (int j = index - 1; j > 0; j--) {
      if (gears[j].info[6] != gears[j - 1].info[2]) {
        directions[j - 1] = directions[j] * -1;
      }
    }

    for (int j = index - 1; j < 3; j++) {
      if (gears[j].info[2] != gears[j + 1].info[6]) {
        directions[j + 1] = directions[j] * -1;
      }
    }
    
    return directions;
  }

  private static void rotate(Gear gear, int rotationDirection) {
    if (rotationDirection == 1) {
      rotateClockwise(gear);
    } else if (rotationDirection == -1) {
      rotateCounterClockwise(gear);
    }
  }

  private static void rotateCounterClockwise(Gear gear) {
    int[] afterRotation = new int[gear.info.length];
    afterRotation[7] = gear.info[0];

    System.arraycopy(gear.info, 1, afterRotation, 0, 7);
    gear.info = afterRotation;
  }

  private static void rotateClockwise(Gear gear) {
    int[] afterRotation = new int[gear.info.length];
    afterRotation[0] = gear.info[7];

    System.arraycopy(gear.info, 0, afterRotation, 1, 7);
    gear.info = afterRotation;
  }

  private static void getScore() {
    result += (gears[0].info[0] == 1) ? 1 : 0;
    result += (gears[1].info[0] == 1) ? 2 : 0;
    result += (gears[2].info[0] == 1) ? 4 : 0;
    result += (gears[3].info[0] == 1) ? 8 : 0;
  }
}
