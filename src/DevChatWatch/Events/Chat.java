package DevChatWatch.Events;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import DevChatWatch.main;

public class Chat 
{
	private main plugin;
	
	public Chat(main plugin)
	{
		this.plugin = plugin;
	}
	
	public boolean checkChatBadWord(AsyncPlayerChatEvent e) 
	{
		String badWordMessage = null;
		boolean cancellChatEvent = false;
		
		String message = e.getMessage().toLowerCase();
		ArrayList<String> badWords = this.plugin.badwords.getBadWordsList();
		
		for (String badWord : badWords) {	
			if(message.matches(".*" + badWord.toLowerCase() + "( .*)?")) {
				badWordMessage = "Watch your language";
				cancellChatEvent = true;
			}
		}
		
		if (badWordMessage != null) {
			this.plugin.helper.sendMessage(badWordMessage);
		}
		
		return cancellChatEvent;
	}
	
	public boolean checkMutedPlayer(AsyncPlayerChatEvent e, Player player)
	{
		String mutedMessage = null;
		boolean cancellChatEvent = false;
		
		ArrayList<Player> mutedPlayerList = this.plugin.mute.getMutePlayerList();
		
		for (Player user : mutedPlayerList) {
			if (user.getUniqueId().equals(player.getUniqueId())) {
				cancellChatEvent = true;
				mutedMessage = "You are muted";
			}
		}
		
		if (mutedMessage != null) {
			this.plugin.helper.sendMessage(mutedMessage);
		}
		
		return cancellChatEvent;
	}
}
