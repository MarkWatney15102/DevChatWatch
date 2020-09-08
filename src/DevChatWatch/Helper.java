package DevChatWatch;

import org.bukkit.entity.Player;

public class Helper 
{
	private Player player;
	
	public void sendMessage(String message) 
	{
		this.player.sendMessage(Config.PLUGIN_CHAT_PREFIX + message);
	}
	
	public void print(String message)
	{
		System.out.println(Config.PLUGIN_CONSOLE_PREFIX + message);
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
