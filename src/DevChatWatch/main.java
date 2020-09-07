package DevChatWatch;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import BadWord.BadWords;
import Base.Base;
import DevChatWatch.Commands.Commands;
import Mute.Mute;

public class main extends JavaPlugin implements CommandExecutor, Listener 
{
	public DevChatWatchHelper helper;
	
	public BadWords badwords;
	public Mute mute;
	
	public void onEnable()
	{
		Base.init();
		helper = new DevChatWatchHelper();
		badwords = new BadWords();
		mute = new Mute();
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable()
	{
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) 
	{
		Commands cmds = new Commands(sender, cmd, command, args);
		return cmds.CommandListerner();
	}
	
	@EventHandler
	public void checkChat(AsyncPlayerChatEvent e) 
	{
		Player player = e.getPlayer();
		this.helper.setPlayer(player);
		
		boolean checkChatBadWord = false;
		boolean checkMutedPlayer = false;
		
		checkChatBadWord = this.checkChatBadWord(e);
		checkMutedPlayer = this.checkMutedPlayer(e, player);
	
		if (checkChatBadWord == true) {
			e.setCancelled(true);
		} else if (checkMutedPlayer == true) {
			e.setCancelled(true);
		}
	}
	
	private boolean checkChatBadWord(AsyncPlayerChatEvent e) 
	{
		String badWordMessage = null;
		boolean cancellChatEvent = false;
		
		String message = e.getMessage().toLowerCase();
		ArrayList<String> badWords = this.badwords.getBadWordsList();
		
		for (String badWord : badWords) {	
			if(message.matches(".*" + badWord.toLowerCase() + "( .*)?")) {
				badWordMessage = "Watch your language";
				cancellChatEvent = true;
			}
		}
		
		if (badWordMessage != null) {
			this.helper.sendMessage(badWordMessage);
		}
		
		return cancellChatEvent;
	}
	
	private boolean checkMutedPlayer(AsyncPlayerChatEvent e, Player player)
	{
		String mutedMessage = null;
		boolean cancellChatEvent = false;
		
		ArrayList<Player> mutedPlayerList = this.mute.getMutePlayerList();
		
		for (Player user : mutedPlayerList) {
			if (user.getUniqueId().equals(player.getUniqueId())) {
				cancellChatEvent = true;
				mutedMessage = "You are muted";
			}
		}
		
		if (mutedMessage != null) {
			this.helper.sendMessage(mutedMessage);
		}
		
		return cancellChatEvent;
	}
}

