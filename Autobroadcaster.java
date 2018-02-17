package Config;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Autobroadcaster { 
	private ArrayList<String> broadcastMessages = new ArrayList<String>();
	private int counter = -1; 
	@SuppressWarnings("unchecked")
    public void initMessages() {
        ArrayList<String> messages = (ArrayList<String>) Main.plugin.getConfig().getList("TestWorld.Autobroadcaster.Messages");
        broadcastMessages.addAll(messages);
    }	
	public int getNextMessage() {
		int nm = counter + 1;
		if (nm < broadcastMessages.size()) {
			counter++;
			return nm;
		} else {
			counter = 0; 
			return 0;
		}
	}
		public void broadcastMessage() {
			new BukkitRunnable() {
				public void run() {
					int nm = getNextMessage();
					String message = broadcastMessages.get(nm);
					Bukkit.broadcastMessage(message);
				}
			}.runTaskTimer(Main.plugin, 40, Main.plugin.getConfig().getLong("TestWorld.Autobroadcaster.delay")* 20 * 60);
		}
}