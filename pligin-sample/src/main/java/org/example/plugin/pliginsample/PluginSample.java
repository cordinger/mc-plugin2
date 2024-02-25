package org.example.plugin.pliginsample;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginSample extends JavaPlugin implements Listener {

  private int count;

  @Override
  public void onEnable() {
    saveDefaultConfig();
    getConfig().getString("Message");

    Bukkit.getPluginManager().registerEvents(this, this);
    getCommand("setlevel").setExecutor(new SetLevelCommand(this));
    getCommand("allsetlevel").setExecutor(new AllSetLevelCommand());

    String[] stringArray = new String[]{"test1", "test2", "test3"};
    List<String> stringList = List.of("test1", "test2", "test3");
    //stringList.add("test4");
    //stringList.remove(1);
    Map<Integer, String> map = new HashMap<>();
    map.put(1, "test1");
    map.put(2, "test2");
    map.put(3, "test3");
    String value = map.get(1);
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e) {
    // イベント発生時のプレイヤーやワールドなどの情報を変数に持つ。
    Player player = e.getPlayer();
    World world = player.getWorld();
    Location playerLocation = player.getLocation();

    world.spawn(new Location(world, playerLocation.getX() + 1, playerLocation.getY(), playerLocation.getZ()), Chicken.class);
    world.getBlockAt(
        new Location(world,
            playerLocation.getX() + 2,
            playerLocation.getY(),
            playerLocation.getZ())).setType(Material.DARK_OAK_WOOD);
  }

  /**
   * プレイヤーがスニークを開始/終了する際に起動されるイベントハンドラ。
   *
   * @param e イベント
   */
  @EventHandler
  public void onPlayerToggleSneak(PlayerToggleSneakEvent e) throws IOException {
    // イベント発生時のプレイヤーやワールドなどの情報を変数に持つ。
    Player player = e.getPlayer();
    World world = player.getWorld();

    List<Color> colorList = List.of(Color.RED, Color.BLUE, Color.WHITE, Color.BLACK);

    if (count % 2 == 0) {
      for (Color color : colorList) {
        // 花火オブジェクトをプレイヤーのロケーション地点に対して出現させる。
        Firework firework = world.spawn(player.getLocation(), Firework.class);

        // 花火オブジェクトが持つメタ情報を取得。
        FireworkMeta fireworkMeta = firework.getFireworkMeta();

        // メタ情報に対して設定を追加したり、値の上書きを行う。
        // 今回は青色で星型の花火を打ち上げる。
        fireworkMeta.addEffect(
            FireworkEffect.builder()
                .withColor(Color.RED)
                .withColor(Color.BLUE)
                .with(Type.STAR)
                .withFlicker()
                .build());
        fireworkMeta.setPower(0 + 1 + (2 * 1));

        // 追加した情報で再設定する。
        firework.setFireworkMeta(fireworkMeta);
      }
//      Path path = Path.of("fireworks.txt");
//      Files.writeString(path, "たーまやー");
//      player.sendMessage(Files.readString(path));
    }
    count++;

    int a;

  }

  @EventHandler
  public void onPlayerBedEnter(PlayerBedEnterEvent e) {
    Player p = e.getPlayer();
    ItemStack[] itemStacks = p.getInventory().getContents();
    for (ItemStack item : itemStacks) {
      if (!Objects.isNull(item) && item.getMaxStackSize() == 64 && item.getAmount() < 64) {
        item.setAmount(64);
      }
    }

    p.getInventory().setContents(itemStacks);
  }
}
