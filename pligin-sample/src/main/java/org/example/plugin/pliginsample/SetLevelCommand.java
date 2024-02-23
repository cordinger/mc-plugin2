package org.example.plugin.pliginsample;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLevelCommand implements CommandExecutor {

  private PluginSample pluginSample;

  public SetLevelCommand(PluginSample pluginSample) {
    this.pluginSample = pluginSample;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player player) {
//      System.out.println(pluginSample);
//      player.setLevel(30);
      if (args.length == 1) {
        player.setLevel(Integer.parseInt(args[0]));
      } else {
//        player.sendMessage("Nooooo!!!");
        player.sendMessage(pluginSample.getConfig().getString("Message"));

      }

    }

    return false;
  }
}
