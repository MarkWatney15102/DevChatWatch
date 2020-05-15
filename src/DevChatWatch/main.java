package DevChatWatch;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import BadWord.BadWords;
import Base.Base;

public class main extends JavaPlugin implements CommandExecutor, Listener 
{
	public DevChatWatchHelper helper;
	
	public BadWords badwords;
	
	public void onEnable()
	{
		Base.init();
		helper = new DevChatWatchHelper();
		badwords = new BadWords();
	}
	
	public void onDisable()
	{
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String command, String[] args) 
	{
		if (command.equalsIgnoreCase("chatWatch")) {
			Player player = (Player) sender;
			helper.setPlayer(player);
			
			switch (args[0].toLowerCase()) {
				case "addbadword":
					if (args[1] != null) {
						this.badwords.addBadWord(args[1]);
						this.helper.sendMessage("Word added to Bad words");
					} else {
						this.helper.sendMessage("You need to add a word. Usage: /chatWatch addBadword <badword>");
					}
					break;
				default:
					// Help
			}
			
			return true;
		}
		
		return false;
	}
}

