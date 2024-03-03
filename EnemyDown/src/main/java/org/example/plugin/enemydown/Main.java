package org.example.plugin.enemydown;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.plugin.enemydown.command.EnemyDownCommand;

public final class Main extends JavaPlugin implements Listener {

  @Override
  public void onEnable() {
    EnemyDownCommand enemyDownCommand = new EnemyDownCommand(this);
    Bukkit.getPluginManager().registerEvents(enemyDownCommand, this);
    getCommand("enemyDown").setExecutor(enemyDownCommand);
  }

//  @EventHandler
//  public void onEnemyDeath(EntityDeathEvent e) {
//    e.getEntity().getKiller().sendMessage("敵を倒した！");
//  }

}
