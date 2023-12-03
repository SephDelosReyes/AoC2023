import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    part1();
//    part2();
  }

  public static void part1() {
    List<Game> lgr = new ArrayList<>();
    List<String> lines = parseLine();
    for(String line : lines) {
      Game g = new Game(getGameId(line), 0, 0, 0, true);
      getColorCount(g, line);
      getValidGames(lgr, g);
    }
    int gameSum = 0;
    for (Game g : lgr) {
      gameSum += g.getGameId();
    }
    System.out.println("gamesum: " + gameSum);
  }

  public static void part2() {

  }

  public static List<String> parseLine() {
    List<String> lines = new ArrayList<>();
    String path = "resources/actual.txt";
    String line = "";
    File cubeFile = new File(path);
    try (FileReader fr = new FileReader(cubeFile);
        BufferedReader br = new BufferedReader(fr)) {
      while((line = br.readLine()) != null) {
        lines.add(line);
      }
      return lines;
    } catch (IOException iox) {
      System.out.println("Ya done messed up a-a-ron!! " + iox.getMessage());
    }
    return List.of();
  }

  private static List<Game> getValidGames(List<Game> lgr, Game gr) {
    //Constraints: 12 red cubes, 13 green cubes, and 14 blue cubes
    if (gr.isValid()) {
      System.out.println("lgr: "+gr.getGameId());
      lgr.add(gr);
    }
    return lgr;
  }

  private static boolean isValid(int r, int g, int b) {
    //Constraints: 12 red cubes, 13 green cubes, and 14 blue cubes
    if (r <= 12 && g <= 13 && b <= 14) {
      System.out.println(String.format("r: %s, g: %s, b: %s",r,g,b));
      return true;
    }
    return false;
  }

  public static Integer getGameId(String line) {
    //Game X:
    return Integer.parseInt(line.substring(5, line.indexOf(":")));
  }

  public static Game getColorCount(Game g, String line) {
    line = line.replace(" ", "");
    line = line.substring(line.indexOf(':') + 1);
    System.out.println("line cut: "+ line);
    String[] strArray = line.split(";");

    for (String str : strArray) {
      int redCount = 0, greenCount =0 , blueCount = 0;
      String[] perColor = str.split(",");
      for(String pc: perColor) {
        //System.out.println("pc: "+pc);
        if (pc.contains("red")) {
          //System.out.println("red: "+ i);
          redCount += Integer.parseInt(pc.substring(0, pc.indexOf("red")));
        } else if (pc.contains("green")) {
          //System.out.println("green: "+ i);
          greenCount += Integer.parseInt(pc.substring(0, pc.indexOf("green")));
        } else if (pc.contains("blue")) {
          //System.out.println("blue: "+ i);
          blueCount += Integer.parseInt(pc.substring(0, pc.indexOf("blue")));
        }
      }

      boolean validGame = isValid(redCount,greenCount,blueCount);
      g.setValid(validGame);
      if (!validGame) {
        break;
      }
    }
    System.out.println(g.toString());
    return g;
  }
}