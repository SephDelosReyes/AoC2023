import java.util.Optional;

public class Game {
  private Integer gameId;
  private Integer red;
  private Integer blue;
  private Integer green;
  private boolean isValid;

  public Game(Integer gameId, Integer red, Integer blue, Integer green, boolean isValid) {
    this.gameId = gameId;
    this.red = red;
    this.blue = blue;
    this.green = green;
    this.isValid = isValid;
  }

  public Integer getGameId() {
    return gameId;
  }

  public void setGameId(Integer gameId) {
    this.gameId = gameId;
  }

  public Integer getRed() {
    return red;
  }

  public void setRed(Integer red) {
    this.red = red;
  }

  public Integer getBlue() {
    return blue;
  }

  public void setBlue(Integer blue) {
    this.blue = blue;
  }

  public Integer getGreen() {
    return green;
  }

  public void setGreen(Integer green) {
    this.green = green;
  }

  public boolean isValid() {
    return isValid;
  }

  public void setValid(boolean valid) {
    isValid = valid;
  }
  @Override
  public String toString() {
    return String.format(
        "Game Id: %s \n Game Red: %s \n Game Green: %s \n Game Blue: %s ",
        getGameId(), getRed(), getGreen(), getBlue());
  }
}
