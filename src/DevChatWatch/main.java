package DevChatWatch;

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
import DevChatWatch.Events.Chat;
import Mute.Mute;

public class main extends JavaPlugin implements CommandExecutor, Listener 
{
	public Helper helper;
	
	public BadWords badwords;
	public Mute mute;
	
	public void onEnable()
	{
		Base.init();
		this.helper = new Helper();
		this.badwords = new BadWords();
		this.mute = new Mute();
		
		
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
		
		Chat chat = new Chat(this);
		
		boolean checkChatBadWord = false;
		boolean checkMutedPlayer = false;
		
		checkChatBadWord = chat.checkChatBadWord(e);
		checkMutedPlayer = chat.checkMutedPlayer(e, player);
	
		if (checkChatBadWord == true) {
			e.setCancelled(true);
		} else if (checkMutedPlayer == true) {
			e.setCancelled(true);
		}
	}
}

