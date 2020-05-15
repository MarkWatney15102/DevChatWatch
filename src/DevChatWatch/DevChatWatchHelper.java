package DevChatWatch;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class DevChatWatchHelper 
{
	private Player player;

	public DevChatWatchHelper() 
	{
	}
	
	public void sendMessage(String message) 
	{
		this.player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + DevChatWatchConfig.PLUGIN_NAME + "] " + message);
	}
	
	public void print(String message)
	{
		System.out.println("[" + DevChatWatchConfig.PLUGIN_NAME + "] " + message);
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
