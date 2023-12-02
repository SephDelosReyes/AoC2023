import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  static int sum = 0;
  public static void main(String[] args) {
    calcCalibration();
  }

  public static void calcCalibration() {
    String line = "";
    File calibrationFile = new File("resources/calibrations.txt");
    try (BufferedReader br = new BufferedReader(new FileReader(calibrationFile))) {
      while ((line = br.readLine()) != null) {
        List<Integer> numList = new ArrayList<>();
        // sanitize the lines (Part 2 JANKY AF)
        line = replaceWords(line);
        line.chars()
            .filter(i -> i <= 57 && i >= 48)
            .forEach(
                x -> {
                  numList.add(x);
                  System.out.println(numList);
                }
            );
        int numCount = numList.size();
        if (numCount > 1) {
          String s1 = Character.toString(numList.stream().findFirst().get());
          String s2 = Character.toString(numList.stream().skip(numCount - 1).findFirst().get());
          System.out.println(s1.concat(s2));
          sum = sum + Integer.parseInt(s1.concat(s2));
        } else {
          String s = Character.toString(numList.get(0)).concat(Character.toString(numList.get(0)));
          sum = sum + Integer.parseInt(s);
        }
      }
      System.out.println("Sum: "+ sum);
    } catch (IOException iox) {
      System.out.println("Ya done messed up a-a-ron!! " + iox.getMessage());
    }
  }

  public static String replaceWords(String line) {
    String one = "one";
    String two = "two";
    String three = "three";
    String four = "four";
    String five = "five";
    String six = "six";
    String seven = "seven";
    String eight = "eight";
    String nine = "nine";
    if (line.contains(one)) {
      line = line.replace(one, "o1e");
    } if (line.contains(two)) {
      line = line.replace(two, "t2o");
    } if (line.contains(three)) {
      line = line.replace(three, "t3e");
    } if (line.contains(four)) {
      line = line.replace(four, "f4r");
    } if (line.contains(five)) {
      line = line.replace(five, "f5e");
    } if (line.contains(six)) {
      line = line.replace(six, "s6x");
    } if (line.contains(seven)) {
      line = line.replace(seven, "s7n");
    } if (line.contains(eight)) {
      line = line.replace(eight, "e8t");
    } if (line.contains(nine)) {
      line = line.replace(nine, "n9e");
    }
    return line;
  }
}