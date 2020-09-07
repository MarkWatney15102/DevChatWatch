package DevChatWatch;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class DevChatWatchHelper 
{
	private Player player;
	
	public void sendMessage(String message) 
	{
		this.player.sendMessage(ChatColor.DARK_RED + "[" + DevChatWatchConfig.PLUGIN_NAME + "] " + ChatColor.WHITE + message);
	}
	
	public void print(String message)
	{
		System.out.println("[" + DevChatWatchConfig.PLUGIN_NAME + "] " + message);
	}
	
	public Player getPlayer() 
	{
		return player;
	}

	public void setPlayer(Player player) 
	{
		this.player = player;
	}
}
