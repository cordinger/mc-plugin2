package org.example.plugin.pliginsample;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AllSetLevelCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player player) {
      player.sendMessage("実行出来ません");
    } else {
      for (Player player : sender.getServer().getOnlinePlayers()) {
        player.setLevel(Integer.parseInt(args[0]));
        System.out.println("プレイヤーのレベルが" + args[0] + "に設定されました。");
      }
    }
    return false;
  }
}
