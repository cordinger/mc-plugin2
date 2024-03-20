package org.example.plugin.enemydown.mapper.data;

import lombok.Getter;
import lombok.Setter;

/**
 * プレイヤーのスコア情報を扱うオブゼクト。
 * DBに存在するテーブルと連動する。
 */
@Getter
@Setter
public class PlayerScore {

  private int id;
  private String player_Name;
  private int score;
  private String difficulty;
  private String registered_at;
}
