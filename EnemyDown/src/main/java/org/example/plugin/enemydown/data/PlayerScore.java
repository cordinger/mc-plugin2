package org.example.plugin.enemydown.data;

/**
 * EnemyDownのゲームを実行する左右のスコア情報を扱うオブジェクト。 プレイヤー名、合計点数、日時などの情報を持つ。
 */
public class PlayerScore {

  private String playerName;
  private int score;


  private int gameTime;

  public PlayerScore(String playerName) {
    this.playerName = playerName;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getGameTime() {
    return gameTime;
  }

  public void setGameTime(int gameTime) {
    this.gameTime = gameTime;
  }


}
