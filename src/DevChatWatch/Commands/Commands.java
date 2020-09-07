package DevChatWatch.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import BadWord.BadWords;
import DevChatWatch.DevChatWatchHelper;
import DevChatWatch.Commands.Events.BadWord;
import DevChatWatch.Commands.Events.MutePlayer;
import Mute.Mute;

public class Commands 
{
	public Player player;
	public DevChatWatchHelper helper;
	public BadWords badwords;
	public Mute mute;
	private String command;
	private String[] args;
	
	public Commands(CommandSender sender, Command cmd, String command, String[] args) 
	{
		this.helper = new DevChatWatchHelper();
		this.badwords = new BadWords();
		this.mute = new Mute();
		
		this.player = (Player) sender;
		this.command = command;
		this.args = args;
		
		this.helper.setPlayer(player);
	}
	
	public boolean CommandListerner() 
	{
		boolean returnValue = false;
		
		if (this.command.equalsIgnoreCase("chatWatch")) {
			String action = this.args[0];
			
			BadWord badWord = new BadWord();
			badWord.setCommands(this);
			
			MutePlayer mutePlayer = new MutePlayer();
			mutePlayer.setCommands(this);
			
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
				default:
					this.helper.sendMessage("Usage: /chatWatch");
					returnValue = false;
			}
		}
		
		return returnValue;
	}
}
