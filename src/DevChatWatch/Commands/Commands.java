package DevChatWatch.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import BadWord.BadWords;
import DevChatWatch.Helper;
import DevChatWatch.Events.BadWord;
import DevChatWatch.Events.Help;
import DevChatWatch.Events.MutePlayer;
import Mute.Mute;

public class Commands 
{
	public Player player;
	public Helper helper;
	public BadWords badwords;
	public Mute mute;
	private String command;
	private String[] args;
	
	public Commands(CommandSender sender, Command cmd, String command, String[] args) 
	{
		this.mute = new Mute();
		
		this.player = (Player) sender;
		this.command = command;
		this.args = args;
	}
	
	public boolean CommandListerner() 
	{
		boolean returnValue = false;
		
		if (this.command.equalsIgnoreCase("chatWatch")) {
			if (this.args.length > 0)  {
				String action = this.args[0];
				
				BadWord badWord = new BadWord(this.player);
				
				MutePlayer mutePlayer = new MutePlayer(this.player);
				
				switch (action.toLowerCase()) {
					case "addbadword":
						returnValue = badWord.addBadWord(this.args[1]);
						break;
						
					case "removebadword":
						returnValue = badWord.removeBadWord(this.args[1]);
						break;
						
					case "mute":
						returnValue = mutePlayer.mutePlayer(this.args[1]);
						break;
						
					case "unmute":
						returnValue = mutePlayer.unmutePlayer(this.args[1]);
						break;
						
					case "help":
						Help help = new Help(this);
						returnValue = help.printHelp();
						break;
					default:
						this.helper.sendMessage("Usage: '/chatWatch help' for help");
						returnValue = false;
				}
			}
		}
		
		return returnValue;
	}
}
