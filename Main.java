package Config;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static Main plugin;
	private Autobroadcaster aCaster = new Autobroadcaster();
	public void onEnable() {
		plugin = this;
		loadConfig();
		aCaster.broadcastMessage();
	}
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		aCaster.initMessages();
		saveConfig(); 
	}
}